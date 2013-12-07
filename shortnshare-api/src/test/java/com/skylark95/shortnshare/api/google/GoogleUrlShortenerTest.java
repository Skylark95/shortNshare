/* 
 * Copyright (C) 2013 Derek <derek@skylark95.com>
 * 
 * This file is part of shortNshare.
 * 
 * shortNshare is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * shortNshare is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with shortNshare.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.skylark95.shortnshare.api.google;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.api.services.urlshortener.Urlshortener;
import com.google.api.services.urlshortener.Urlshortener.Url.Insert;
import com.google.api.services.urlshortener.model.Url;
import com.skylark95.shortnshare.api.URLShortener;
import com.skylark95.shortnshare.api.UnableToShortenURLException;

@RunWith(MockitoJUnitRunner.class)
public class GoogleUrlShortenerTest {
    
    private static final String URL_TO_SHORTEN = "https://www.google.com/";
    private static final String SHORTENED_URL = "http://goo.gl/8dLJ3B";
    
    @Mock private Urlshortener shortener;
    @Mock private Urlshortener.Url shortenerUrl;
    @Mock private Insert insert;
    
    private Url urlModel;
    private String shortenedUrl;
    
    private URLShortener googleUrlShortener;
    
    @Before
    public void setUp() throws IOException {
        shortenedUrl = null;
        urlModel = new Url();
        
        when(shortener.url()).thenReturn(shortenerUrl);
        when(shortenerUrl.insert(urlModel)).thenReturn(insert);
        when(insert.execute()).thenReturn(new Url().setId(SHORTENED_URL));
        
        googleUrlShortener = new GoogleUrlShortener(shortener, urlModel);
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
    
    @Test
    public void doesSetLongUrlOnUrlModel() throws UnableToShortenURLException {
        whenTheURLIsShortened();
        assertThat(urlModel.getLongUrl()).isEqualTo(URL_TO_SHORTEN);
    }

    private void whenTheURLIsShortened() throws UnableToShortenURLException {
        shortenedUrl = googleUrlShortener.shorten(URL_TO_SHORTEN);
    }

}
