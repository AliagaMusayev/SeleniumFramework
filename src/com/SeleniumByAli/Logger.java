package com.SeleniumByAli;

import java.io.*;

public class Logger {

    public void WriteErrorLog(String logMessage) throws IOException {
        File errorFile = new File(System.getProperty("user.dir")+"\\ErrorLogs.txt");
        if(!errorFile.exists()){
            errorFile.createNewFile();
        }
        Writer writeToFile = null;
        BufferedWriter writer = new BufferedWriter(writeToFile);
        try{
            writer.write(logMessage);
        }

        finally {
            writer.close();
        }
    }

    public void WriteInfoLog(String logMessage){

    }
}
