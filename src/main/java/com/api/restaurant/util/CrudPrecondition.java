package com.api.restaurant.util;

import com.api.restaurant.exception.RessourceNotFoundException;

public final class CrudPrecondition {

    public static <T> T checkfound(T object){
        if(object == null){
            throw new RessourceNotFoundException();
        }
        else
            return object;
    }
}
