package com.yss.wealth.infrastructure.annotationprocessor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import com.yss.wealth.infrastructure.annotation.Format;
import com.yss.wealth.infrastructure.constant.CertificateType;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;
import com.yss.wealth.infrastructure.util.StringUtil;
import lombok.Data;

import java.util.List;

/**
 * @author:zhuhongmin
 * @date:2020/11/28
 * @description: 证件类型格式化器
 **/
public class CertificateTypeFormatProcessor implements FormatProcessor {
    @Override
    public boolean match(Format.FormatType type) {
        return Format.FormatType.CERTIFICATE_TYPE_FORMAT.equals(type);
    }

    @Override
    public void format(List<BeanUtilExtend.InnerFormat> formats) {

        formats.forEach(format -> {
            format.getFields().forEach(field -> {
                Format formatAnn = field.getAnnotation(Format.class);
                if (ObjectUtil.isEmpty(formatAnn)) {
                    return;
                }
                String[] filedNames = formatAnn.fieldName();
                if (filedNames.length != 2) {
                    return;
                }
                String custTypeFieldName = filedNames[0];
                String certificateTypeFieldName = filedNames[1];
                if (StringUtil.isEmpty(custTypeFieldName) || StringUtil.isEmpty(certificateTypeFieldName)) {
                    return;
                }

                String custType = ObjectUtil.isEmpty(ReflectUtil.getFieldValue(format.getObj(), custTypeFieldName)) ? "" : ReflectUtil.getFieldValue(format.getObj(), custTypeFieldName).toString();
                String certificateType = ObjectUtil.isEmpty(ReflectUtil.getFieldValue(format.getObj(), certificateTypeFieldName)) ? "" : ReflectUtil.getFieldValue(format.getObj(), certificateTypeFieldName).toString();
                if (StringUtil.isEmpty(custType) || StringUtil.isEmpty(certificateType)) {
                    return;
                }
                ReflectUtil.setFieldValue(format.getObj(), field, CertificateType.getCertificateTypeName(custType, certificateType));
            });
        });

    }
}
