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

package com.skylark95.shortnshare.api.inject.google;

import javax.inject.Inject;

import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.urlshortener.Urlshortener;
import com.skylark95.shortnshare.api.UrlShortener;
import com.skylark95.shortnshare.api.inject.Api;

public class GoogleTestInstances {

    @Inject private UrlShortener urlShortener;
    @Inject private Urlshortener urlShortenerApi;
    @Inject private Api api;
    @Inject private HttpTransport httpTransport;
    @Inject private JsonFactory jsonFactory;
    @Inject private GoogleClientRequestInitializer googleClientRequestInitializer;

    public UrlShortener getUrlShortener() {
        return urlShortener;
    }
    
    public Urlshortener getUrlShortenerApi() {
        return urlShortenerApi;
    }

    public Api getApi() {
        return api;
    }

    public HttpTransport getHttpTransport() {
        return httpTransport;
    }

    public JsonFactory getJsonFactory() {
        return jsonFactory;
    }

    public GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
        return googleClientRequestInitializer;
    }

}
