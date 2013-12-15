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

package com.skylark95.shortnshare.api.util;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.skylark95.shortnshare.api.inject.ApiModule;

public final class InjectUtil {
    
    private InjectUtil() {
    }
    
    public static <T> T getInstance(Class<T> type, ApiModule... modules) {
        return createInjector(modules).getInstance(type);
    }

    public static <T> T injectMembers(T instance, ApiModule... modules) {
        createInjector(modules).injectMembers(instance);
        return instance;
    }

    private static Injector createInjector(ApiModule... modules) {
        return Guice.createInjector(modules);
    }

}
