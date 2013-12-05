package com.skylark95.googl.api.core.url;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.google.api.services.urlshortener.model.Url;

public class GoogleLongUrlFactoryTest {
    
    private static final String LONG_URL = "https://www.google.com/";
    
    @Test
    public void canCreateGoogleLongUrl() {
        URLFactory<Url> googleLongUrlFactory = new GoogleLongUrlFactory();
        Url createdUrl = googleLongUrlFactory.createUrl(LONG_URL);
        assertThat(createdUrl.getLongUrl()).isEqualTo(LONG_URL);
    }

}
