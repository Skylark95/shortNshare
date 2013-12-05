package com.skylark95.googl.api.google;

import java.io.IOException;

import com.google.api.services.urlshortener.Urlshortener;
import com.google.api.services.urlshortener.model.Url;
import com.skylark95.googl.api.URLShortener;
import com.skylark95.googl.api.UnableToShortenURLException;
import com.skylark95.googl.api.factory.URLFactory;

public class GoogleUrlShortener implements URLShortener {

    private Urlshortener shortener;
    private URLFactory<Url> googleLongUrlFactory;

    public GoogleUrlShortener(Urlshortener shortener, URLFactory<Url> googleLongUrlFactory) {
        this.shortener = shortener;
        this.googleLongUrlFactory = googleLongUrlFactory;
    }
    
    @Override
    public String shorten(String url) throws UnableToShortenURLException {
        Url shortenedUrl = null;
        Url urlToShorten = googleLongUrlFactory.create(url);
        
        try {
            shortenedUrl = shortener.url().insert(urlToShorten).execute();
        } catch (IOException e) {
            throw new UnableToShortenURLException(e);
        }
        
        return shortenedUrl.getId();
    }

}
