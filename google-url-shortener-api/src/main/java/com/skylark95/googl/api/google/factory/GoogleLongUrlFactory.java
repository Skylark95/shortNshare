package com.skylark95.googl.api.google.factory;

import com.google.api.services.urlshortener.model.Url;
import com.skylark95.googl.api.factory.URLFactory;

public class GoogleLongUrlFactory implements URLFactory<Url> {

    @Override
    public Url create(String url) {
        return new Url().setLongUrl(url);
    }

}
