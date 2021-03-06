package com.labs.classes.reader;

import com.labs.classes.exception.UnableToReadException;
import com.labs.classes.interfaces.Reader;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader extends BaseReader implements Reader {
    private Properties props;

    public PropertyFileReader(File file) {
        super(file);
    }

    public PropertyFileReader(String path) {
        super(path);
    }

    @Override
    public String read() throws UnableToReadException {
        this.props = new Properties();
        try {
            if (!this.path.endsWith(".properties")) {
                throw new RuntimeException("Provide the file in proper format");
            }
            InputStream inputStream = new FileInputStream(new File(this.path).getAbsolutePath());
            this.props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new UnableToReadException("");
        }
        return "OK"; // :)
    }

    public String getPropertyValue(String key) {
        return this.props.getProperty(key);
    }
}
