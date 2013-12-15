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
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.urlshortener.Urlshortener;
import com.skylark95.shortnshare.api.inject.Api;
import com.skylark95.shortnshare.api.inject.ApiProvider;

public class GoogleUrlshortenerApiProvider extends ApiProvider<Urlshortener> {

    private final HttpTransport httpTransport;
    private final JsonFactory jsonFactory;
    private final HttpRequestInitializer httpRequestInitializer;
    private final GoogleClientRequestInitializer googleClientRequestInitializer;

    @Inject
    public GoogleUrlshortenerApiProvider(Api api, HttpTransport httpTransport, JsonFactory jsonFactory,
            GoogleClientRequestInitializer googleClientRequestInitializer) {
        this(api, httpTransport, jsonFactory, null, googleClientRequestInitializer);
    }
    
    
    public GoogleUrlshortenerApiProvider(Api api, HttpTransport httpTransport, JsonFactory jsonFactory, 
            HttpRequestInitializer httpRequestInitializer, GoogleClientRequestInitializer googleClientRequestInitializer) {
        super(api);
        this.httpTransport = httpTransport;
        this.jsonFactory = jsonFactory;
        this.httpRequestInitializer = httpRequestInitializer;
        this.googleClientRequestInitializer = googleClientRequestInitializer;
        
    }
    
    @Override
    public Urlshortener get() {
        return new Urlshortener.Builder(httpTransport, jsonFactory, httpRequestInitializer)
            .setApplicationName(getApi().getApplicationName())
            .setGoogleClientRequestInitializer(googleClientRequestInitializer)
            .build();
    }

}
