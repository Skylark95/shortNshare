package com.skylark95.googl.api;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.api.services.urlshortener.Urlshortener;
import com.google.api.services.urlshortener.Urlshortener.Url.Insert;
import com.google.api.services.urlshortener.model.Url;
import com.skylark95.googl.api.core.url.URLFactory;

@RunWith(MockitoJUnitRunner.class)
public class GoogleUrlShortenerTest {
    
    private static final String URL_TO_SHORTEN = "https://www.google.com/";
    private static final String SHORTENED_URL = "http://goo.gl/8dLJ3B";
    
    @Mock private Urlshortener shortener;
    @Mock private URLFactory<Url> googleLongUrlFactory;
    @Mock private Urlshortener.Url shortenerUrl;
    @Mock private Insert insert;
    
    private String shortenedUrl;
    private Url googleShortUrl;
    private Url googleLongUrl;
    
    @InjectMocks private GoogleUrlShortener googleUrlShortener;
    
    @Before
    public void setUp() throws IOException {
        shortenedUrl = null;
        googleLongUrl = new Url().setLongUrl(URL_TO_SHORTEN);
        googleShortUrl = new Url().setId(SHORTENED_URL);
        when(googleLongUrlFactory.createUrl(URL_TO_SHORTEN)).thenReturn(googleLongUrl);
        when(shortener.url()).thenReturn(shortenerUrl);
        when(shortenerUrl.insert(googleLongUrl)).thenReturn(insert);
        when(insert.execute()).thenReturn(googleShortUrl);
    }

    @Test
    public void doesCallGoogleApiToShortenUrl() throws IOException, UnableToShortenURLException {
        whenTheURLIsShortened();
        verify(insert).execute();
    }
    
    @Test(expected = UnableToShortenURLException.class)
    public void doesThrowUnableToShortenUrlExceptionIfGoogleApiThrowsIOException() throws IOException, UnableToShortenURLException {
        doThrow(IOException.class).when(insert).execute();
        whenTheURLIsShortened();
    }
    
    @Test
    public void doesReturnShortenedUrl() throws UnableToShortenURLException {
        whenTheURLIsShortened();
        assertThat(shortenedUrl).isEqualTo(SHORTENED_URL);
    }

    private void whenTheURLIsShortened() throws UnableToShortenURLException {
        shortenedUrl = googleUrlShortener.shorten(URL_TO_SHORTEN);
    }

}
