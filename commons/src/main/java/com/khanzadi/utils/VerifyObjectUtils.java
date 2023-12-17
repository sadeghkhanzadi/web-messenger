package com.khanzadi.utils;

import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.exeption.MessengerException;

public class VerifyObjectUtils {
    public static <T> T requireNonNull(T obj, String entryType) throws MessengerException {
        if (obj == null || obj == "")
            throw new MessengerException("Error"+ entryType +"param is Empty");
        return obj;
    }

    public static <T> boolean isNewUsers(UsersDto dto) throws MessengerException {
        if (dto != null){
            return StringUtils.isNullOrEmpty(String.valueOf(dto.getId()!= null ? dto.getId() : null));
        } throw new MessengerException("Json Users Model is null");
    }
}
