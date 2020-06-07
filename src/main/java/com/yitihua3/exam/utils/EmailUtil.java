package com.yitihua3.exam.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    验证邮箱是否合法
 */
public class EmailUtil {
    public static boolean isEmail(String email) {
        //邮箱格式
        Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = emailPattern.matcher(email);
        if(matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }
}
