package com.skylark95.googl.api.core.url;

import com.google.api.services.urlshortener.model.Url;

public class GoogleLongUrlFactory implements URLFactory<Url> {

    @Override
    public Url createUrl(String url) {
        return new Url().setLongUrl(url);
    }

}
