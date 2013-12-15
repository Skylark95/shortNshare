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

import java.io.IOException;

import javax.inject.Inject;

import com.google.api.services.urlshortener.Urlshortener;
import com.google.api.services.urlshortener.model.Url;
import com.skylark95.shortnshare.api.UnableToShortenUrlException;
import com.skylark95.shortnshare.api.UrlShortener;

public class GoogleUrlShortener implements UrlShortener {

    private final Urlshortener googleUrlShortenerApi;

    @Inject
    public GoogleUrlShortener(Urlshortener googleUrlShortenerApi) {
        this.googleUrlShortenerApi = googleUrlShortenerApi;
    }
    
    @Override
    public String shorten(String longURL) throws UnableToShortenUrlException {
        Url theShortURL = null;
        Url theLongURL = createLongURL(longURL);
        
        try {
            theShortURL = googleUrlShortenerApi.url().insert(theLongURL).execute();
        } catch (IOException e) {
            throw new UnableToShortenUrlException(e);
        }
        
        return theShortURL.getId();
    }

    private Url createLongURL(String longURL) {
        return new Url().setLongUrl(longURL);
    }

}
