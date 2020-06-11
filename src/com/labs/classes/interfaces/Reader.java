package com.labs.classes.interfaces;

import com.labs.classes.exception.UnableToCloseExcepton;
import com.labs.classes.exception.UnableToReadException;

public interface Reader {
    String read() throws UnableToReadException, UnableToCloseExcepton;
}
