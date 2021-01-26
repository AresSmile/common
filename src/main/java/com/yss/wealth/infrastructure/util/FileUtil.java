package com.yss.wealth.infrastructure.util;

import cn.hutool.core.util.ObjectUtil;
import com.yss.wealth.infrastructure.common.ECode;
import com.yss.wealth.infrastructure.common.MessageException;
import com.yss.wealth.infrastructure.enums.UnitEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author xuanfei.Chen
 * @description
 * @date 2020/5/28 14:22
 */
public class FileUtil {

    /**
     * @description 上传单个文件
     * @author xuanfei.Chen
     * @date 2020/6/1 9:10
     */
    public static void uploadSingleFile(String dirPath, MultipartFile uploadFile) {
        if (StringUtils.isEmpty(dirPath)) {
            throw new MessageException("文件上传地址为null");
        }
        //检查上传文件路径是否存在，不存在就创建目录
        File dir = new File(dirPath);
        if (!dir.exists()) {
            boolean flag = dir.mkdirs();
            if (!flag) {
                throw new MessageException("文件目录创建失败");
            }
        }
        File file = new File(dirPath + File.separator + uploadFile.getOriginalFilename());
        try {
            uploadFile.transferTo(file);
        } catch (IOException e) {
            throw new MessageException("文件最终上传失败，请联系系统管理员");
        }
    }

    /**
     * @description 下载单个文件
     * @author xuanfei.Chen
     * @date 2020/6/1 9:16
     */
    public static void downSingleFile(String path, String fileName) {
        String filePathString = path + File.separator + fileName;
        FileInputStream fileIn = null;
        ServletOutputStream out = null;
        File file;
        try {
            HttpServletResponse response = getResponse();
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", encodeFileName(fileName, getRequest())));
            file = new File(filePathString);
            fileIn = new FileInputStream(file);
            out = response.getOutputStream();
            byte[] outputByte = new byte[1024];
            int readTmp = 0;
            while ((readTmp = fileIn.read(outputByte)) != -1) {
                out.write(outputByte, 0, readTmp); //并不是每次都能读到1024个字节，所以用readTmp作为每次读取数据的长度，否则会出现文件损坏的错误
            }
        } catch (Exception e) {
            throw MessageException.builder().message("文件下载失败！").code(ECode.REMOTE_ERROR).build();
        } finally {
            try {
                fileIn.close();
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断文件大小
     *
     * @param len  文件长度
     * @param size 限制大小
     * @param unit 限制单位（B,K,M,G）
     * @return
     */
    public static boolean checkFileSize(Long len, int size, UnitEnum unit) {
//        long len = file.length();
        double fileSize = 0;
        if (UnitEnum.B.equals(unit)) {
            fileSize = (double) len;
        } else if (UnitEnum.K.equals(unit)) {
            fileSize = (double) len / 1024;
        } else if (UnitEnum.M.equals(unit)) {
            fileSize = (double) len / 1048576;
        } else if (UnitEnum.G.equals(unit)) {
            fileSize = (double) len / 1073741824;
        }
        return !(fileSize > size);
    }

    /**
     * @description 删除目录下所有文件
     * @author xuanfei.Chen
     * @date 2020/6/1 9:07
     */
    public static void deleteAllFile(String dataPath) {
        File file = new File(dataPath);
        if (!file.exists()) {
            return;
        }
        if (!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp;
        for (String s : tempList) {
            if (dataPath.endsWith(File.separator)) {
                temp = new File(dataPath + s);
            } else {
                temp = new File(dataPath + File.separator + s);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                deleteAllFile(dataPath + File.separator + s);
                deleteUserDataFolder(dataPath + File.separator + s);
            }
        }
    }

    public static void deleteUserDataFolder(String dataPath) {
        try {
            deleteAllFile(dataPath);
            String filePath = dataPath;
            filePath = filePath;
            File myFilePath = new File(filePath);
            myFilePath.delete();
        } catch (Exception e) {
            throw MessageException.builder().message("删除路径下所有文件失败！").code(ECode.DELETE_ERROR).build();
        }
    }

    /**
     * @description 反编译文件名
     * @author xuanfei.Chen
     * @date 2020/6/1 9:09
     */
    public static String encodeFileName(String fileNames, HttpServletRequest request) {
        String codedFilename = null;
        try {
            String agent = request.getHeader("USER-AGENT");
            if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident") || null != agent && -1 != agent.indexOf("Edge")) {// ie浏览器及Edge浏览器
                String name = java.net.URLEncoder.encode(fileNames, "UTF-8");
                codedFilename = name;
            } else if (null != agent && -1 != agent.indexOf("Mozilla")) {
                // 火狐,Chrome等浏览器
                codedFilename = new String(fileNames.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return codedFilename;
    }

    public static HttpServletRequest getRequest() {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        if (ObjectUtil.isEmpty(requestAttributes)) {
            return null;
        }

        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }

    public static HttpServletResponse getResponse() {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        if (ObjectUtil.isEmpty(requestAttributes)) {
            return null;
        }

        return ((ServletRequestAttributes) requestAttributes).getResponse();
    }

}
