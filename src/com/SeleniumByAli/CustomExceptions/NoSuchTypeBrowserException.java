package com.SeleniumByAli.CustomExceptions;

public class NoSuchTypeBrowserException extends  Exception {

    public NoSuchTypeBrowserException(){
        super();
    }

    public NoSuchTypeBrowserException(String exceptionMessage){
        super(exceptionMessage);
    }

}
