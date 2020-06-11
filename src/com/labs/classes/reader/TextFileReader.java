package com.labs.classes.reader;

import com.labs.classes.exception.UnableToReadException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TextFileReader<i> extends BaseReader {

    public TextFileReader(File file){
        super(file);
    }

    public TextFileReader(String path){
        super(path);
    }

    //@Override
    public String read() throws UnableToReadException {
        try(FileReader reader = new FileReader(this.file))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }

            }
            return new String(buf);

        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToReadException("");
        }

    }

    //int[] routePointsArray = new int[3];
}
