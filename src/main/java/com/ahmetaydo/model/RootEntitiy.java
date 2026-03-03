package com.ahmetaydo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootEntitiy<T> {
    
    
    
    private boolean result;
    
    private String errorMessage;
    
    private T data;

    
    public static <T> RootEntitiy<T> ok(T data){
        RootEntitiy<T> rootEntitiy = new RootEntitiy<>();
        rootEntitiy.setData(data);
        rootEntitiy.setResult(true);
        rootEntitiy.setErrorMessage(null);
        
        return rootEntitiy;
    }

    public static  <T> RootEntitiy<T> error(String errorMessage){
        RootEntitiy<T> rootEntitiy = new RootEntitiy<>();
        rootEntitiy.setData(null);
        rootEntitiy.setErrorMessage(errorMessage);
        rootEntitiy.setResult(false);

        return rootEntitiy;
    }
    
    
}
