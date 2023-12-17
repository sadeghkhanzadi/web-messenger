package com.khanzadi.utils;

import com.khanzadi.exeption.MessengerException;

import java.util.Map;

public class StringUtils {
    public static boolean isNullOrEmpty(String content) {
        return content == null || content.trim().isEmpty() || content.length() == 0;
    }
    public static boolean hasText(String text) {
        return (text != null && !"".equals(text) && text.length() > 0);
    }

    public static String getNotNullValue(String... values) {
        for (String value : values) {
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    public static boolean isBoolean(String content) {
        boolean result = false;
        if (content != null && (content.toLowerCase().equals("true") || content.toLowerCase().equals("false"))) {
            result = true;
        }
        return result;
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen = length(cs);
        if (strLen == 0) {
            return true;
        } else {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static int length(CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }



    public static String replaceAll(String content, Map<String, String> keyValue) {
        final String[] result = {content};
        keyValue.forEach((key, value) ->
                result[0] = result[0].replaceAll(key, value));
        return result[0];
    }


    public static boolean isDigit(String input) {
        if (input == null) {
            return false;
        }
        boolean isDigit = true;
        for (char ch : input.toCharArray()) {
            if (!Character.isDigit(ch)) {
                isDigit = false;
                break;
            }
        }
        return isDigit;
    }

    public static <T> T requireNonNull(T obj, String entryType) throws MessengerException {
        if (obj == null || obj == "")
            throw new MessengerException("Error"+ entryType +"param is Empty");
        return obj;
    }
}
