package com.skylark95.googl.api.google.factory;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.google.api.services.urlshortener.model.Url;
import com.skylark95.googl.api.factory.URLFactory;
import com.skylark95.googl.api.google.factory.GoogleLongUrlFactory;

public class GoogleLongUrlFactoryTest {
    
    private static final String LONG_URL = "https://www.google.com/";
    
    @Test
    public void canCreateGoogleLongUrl() {
        URLFactory<Url> googleLongUrlFactory = new GoogleLongUrlFactory();
        Url createdUrl = googleLongUrlFactory.create(LONG_URL);
        assertThat(createdUrl.getLongUrl()).isEqualTo(LONG_URL);
    }

}
