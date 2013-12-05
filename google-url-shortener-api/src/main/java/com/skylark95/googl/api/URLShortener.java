package com.skylark95.googl.api;

public interface URLShortener {
    
    abstract String shorten(String url) throws UnableToShortenURLException;

}
