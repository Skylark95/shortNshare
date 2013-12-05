package com.skylark95.googl.api;

import java.io.IOException;

public class UnableToShortenURLException extends Exception {

    private static final long serialVersionUID = -1156997496107755001L;
    
    public UnableToShortenURLException(IOException e) {
        super(e);
    }

}
