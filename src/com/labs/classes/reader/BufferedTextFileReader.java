package com.labs.classes.reader;


import com.labs.classes.exception.UnableToCloseExcepton;
import com.labs.classes.exception.UnableToReadException;
import com.labs.classes.interfaces.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedTextFileReader extends BaseReader implements Reader {

    public BufferedTextFileReader(File file) {
        super(file);
    }

    public BufferedTextFileReader(String path) {
        super(path);
    }

    public String read() throws UnableToReadException, UnableToCloseExcepton {
        BufferedReader objReader = null;
        StringBuilder sb = new StringBuilder("");
        try {
            String strCurrentLine;

            objReader = new BufferedReader(new FileReader(this.path));

            while ((strCurrentLine = objReader.readLine()) != null) {

                sb.append(strCurrentLine);
            }
            return sb.toString();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                throw new UnableToCloseExcepton("Unable to close");
            }
        }
        throw new UnableToReadException("Unable to read");
    }
}
