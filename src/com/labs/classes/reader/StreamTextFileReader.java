package com.labs.classes.reader;


import com.labs.classes.exception.UnableToReadException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class StreamTextFileReader extends BaseReader {

    public StreamTextFileReader(File file) {
        super(file);
    }

    public StreamTextFileReader(String path) {
        super(path);
    }

    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }


    public void close() throws IOException {

    }

    public String read() throws UnableToReadException{
        try(FileInputStream fin = new FileInputStream(this.file)) { // try withou resources
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            //return Arrays.toString(buffer); wtf???
            return new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UnableToReadException(String.format("Could not read %s!", this.path));
    }
}
