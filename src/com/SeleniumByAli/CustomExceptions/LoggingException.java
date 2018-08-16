package com.SeleniumByAli.CustomExceptions;

import java.io.IOException;

public class LoggingException extends IOException {

    public LoggingException(){
        super();
    }

    public  LoggingException(String message){
        super(message);
    }
}
