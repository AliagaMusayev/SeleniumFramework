package com.SeleniumByAli.CustomExceptions;

public class CookieUnavailableException extends Exception {

    public CookieUnavailableException(){
        super();
    }

    public CookieUnavailableException(String message){
        super(message);
    }
}
