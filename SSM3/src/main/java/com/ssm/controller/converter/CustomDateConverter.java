package com.ssm.controller.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张镠
 * @date 2019/7/21 - 23:46
 * 日期转换器
 */
public class CustomDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source){
        //实现将日期串转为日期类型
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            //转换成功直接返回
            return simpleDateFormat.parse(source);
        }catch (ParseException e){
            e.printStackTrace();
        }
        //若参数绑定失败返回null
        return null;
    }
}
