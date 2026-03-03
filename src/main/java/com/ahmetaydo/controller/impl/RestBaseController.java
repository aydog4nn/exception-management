package com.ahmetaydo.controller.impl;

import com.ahmetaydo.model.RootEntitiy;

public class RestBaseController {

    public  <T> RootEntitiy<T> ok(T data){
        return RootEntitiy.ok(data);
    }

    public <T> RootEntitiy<T> error(String errorMessage){
        return RootEntitiy.error(errorMessage);
    }

}
