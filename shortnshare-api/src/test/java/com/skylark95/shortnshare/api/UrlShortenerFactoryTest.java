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

package com.skylark95.shortnshare.api;

import static com.skylark95.shortnshare.api.UrlShortenerService.GOOGLE;
import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.skylark95.shortnshare.api.google.GoogleUrlShortener;

public class UrlShortenerFactoryTest {

    @Test
    public void canGetUrlShorterForGoogleService() {
        UrlShortener urlShortener = UrlShortenerFactory.getUrlShortenerFor(GOOGLE);
        assertThat(urlShortener).isInstanceOf(GoogleUrlShortener.class);
    }

}