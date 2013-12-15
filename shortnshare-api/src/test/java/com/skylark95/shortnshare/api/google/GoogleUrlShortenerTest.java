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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.api.services.urlshortener.Urlshortener;
import com.google.api.services.urlshortener.Urlshortener.Url.Insert;
import com.google.api.services.urlshortener.model.Url;
import com.skylark95.shortnshare.api.UnableToShortenUrlException;

@RunWith(MockitoJUnitRunner.class)
public class GoogleUrlShortenerTest {
    
    private static final String EXPECTED_LONG_URL = "https://www.google.com/";
    private static final String EXPECTED_SHORT_URL = "http://goo.gl/8dLJ3B";
    
    @InjectMocks private GoogleUrlShortener googleUrlShortener;
    
    @Mock private Urlshortener googleUrlShortenerApi;
    @Mock private Urlshortener.Url googleApiUrl;
    @Mock private Insert insert;
    
    private String shortUrl;
    private Url longUrl;
    
    @Before
    public void setUp() throws IOException {
        shortUrl = null;
        longUrl = new Url().setLongUrl(EXPECTED_LONG_URL);
        
        when(googleUrlShortenerApi.url()).thenReturn(googleApiUrl);
        when(googleApiUrl.insert(longUrl)).thenReturn(insert);
        when(insert.execute()).thenReturn(new Url().setId(EXPECTED_SHORT_URL));
    }

    @Test
    public void doesCallGoogleApiToShortenUrl() throws IOException, UnableToShortenUrlException {
        whenTheURLIsShortened();
        verify(insert).execute();
    }
    
    @Test(expected = UnableToShortenUrlException.class)
    public void doesThrowUnableToShortenUrlExceptionIfGoogleApiThrowsIOException() throws IOException, UnableToShortenUrlException {
        doThrow(IOException.class).when(insert).execute();
        whenTheURLIsShortened();
    }
    
    @Test
    public void doesReturnShortenedUrl() throws UnableToShortenUrlException {
        whenTheURLIsShortened();
        assertThat(shortUrl).isEqualTo(EXPECTED_SHORT_URL);
    }
    
    @Test
    public void doesCallInsertWithLongUrl() throws UnableToShortenUrlException, IOException {
        whenTheURLIsShortened();
        verify(googleApiUrl).insert(longUrl);
    }
    
    private void whenTheURLIsShortened() throws UnableToShortenUrlException {
        shortUrl = googleUrlShortener.shorten(EXPECTED_LONG_URL);
    }

}
