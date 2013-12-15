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

package com.skylark95.shortnshare.api.inject;

public abstract class Api {
    
    private final String applicationName;
    private final String key;
    
    public Api(String key) {
        this("shortNshare/1.0-SNAPSHOT", key);
    }
    
    public Api(String applicationName, String key) {
        this.applicationName = applicationName;
        this.key = key;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getKey() {
        return key;
    }
    
}
