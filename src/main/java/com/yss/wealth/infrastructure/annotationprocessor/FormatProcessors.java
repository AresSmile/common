package com.yss.wealth.infrastructure.annotationprocessor;

import com.yss.wealth.infrastructure.annotation.Format;
import com.yss.wealth.infrastructure.util.BeanUtilExtend;

import java.util.ArrayList;
import java.util.List;/**
*
* @author:zhuhongmin
* @date:2020/7/30
* @description: 注解解释入口
**/
public class FormatProcessors {
    private static List<FormatProcessor> processors = new ArrayList<>();
    static {
        processors.add(new PrdFormatProcessor());
        processors.add(new NetFormatProcessor());
        processors.add(new OrgFormatProcessor());
        processors.add(new TradeAccountRelatedProcessor());
        processors.add(new FundAccountRelatedProcessor());
        processors.add(new CertificateTypeFormatProcessor());
    }


    public static void process(Format.FormatType type, List<BeanUtilExtend.InnerFormat> innerFormats){
        for (FormatProcessor processor : processors) {
            if (processor.match(type)){
                processor.format(innerFormats);
                return;
            }
        }
    }
}
