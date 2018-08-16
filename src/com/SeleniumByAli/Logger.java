package com.SeleniumByAli;

import com.SeleniumByAli.CustomExceptions.LoggingException;

import java.io.*;

public class Logger {

    public synchronized void WriteErrorLog(String logMessage, String fullFilePathAndName) throws IOException {
        try{
            File errorFile = new File(fullFilePathAndName);
            if(!errorFile.exists()){
                errorFile.createNewFile();
            }
            FileWriter writeToFile = new FileWriter(errorFile,true);
            BufferedWriter writer = new BufferedWriter(writeToFile);
            try{
                writer.write(logMessage);
            }

            finally {
                writer.close();
            }
        }
        catch (LoggingException ex){
            throw new LoggingException("Exception on Writing Error Logs to file");
        }

    }

    public void WriteInfoLog(String logMessage) throws LoggingException {

        // TODO : write method logic
        throw new LoggingException("During creation of Info Log file there happened error");
    }
}
