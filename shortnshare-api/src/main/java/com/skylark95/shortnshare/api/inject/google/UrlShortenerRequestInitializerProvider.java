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
import com.google.api.services.urlshortener.UrlshortenerRequestInitializer;
import com.skylark95.shortnshare.api.inject.Api;
import com.skylark95.shortnshare.api.inject.ApiProvider;

public class UrlShortenerRequestInitializerProvider extends ApiProvider<GoogleClientRequestInitializer> {

    @Inject
    public UrlShortenerRequestInitializerProvider(Api api) {
        super(api);
    }

    @Override
    public GoogleClientRequestInitializer get() {
        return new UrlshortenerRequestInitializer(getApi().getKey());
    }

}
