package com.SeleniumByAli.CustomExceptions;

import java.io.IOException;

public class LoggingException extends IOException {

    public LoggingException(){
        super();
    }

    /**
     * @param message
     */
    public  LoggingException(String message){
        super(message);
    }
}
