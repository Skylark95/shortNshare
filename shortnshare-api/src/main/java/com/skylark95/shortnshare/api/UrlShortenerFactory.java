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


import com.skylark95.shortnshare.api.inject.ApiModule;
import com.skylark95.shortnshare.api.util.InjectUtil;
import com.skylark95.shortnshare.api.util.ReflectionUtil;
import com.skylark95.shortnshare.api.util.StringUtils;

public final class UrlShortenerFactory {
    
    private static final String API_MODULE;
    private static final String MODULE_PACKAGE;
    
    static {
        API_MODULE = "ApiModule";
        MODULE_PACKAGE = ApiModule.class.getPackage().getName();
    }
    
    private UrlShortenerFactory() {
    }
    
    public static UrlShortener getUrlShortenerFor(UrlShortenerService service) {
        ApiModule apiModule = getModuleFor(service);
        return InjectUtil.getInstance(UrlShortener.class, apiModule);
    }

    private static ApiModule getModuleFor(UrlShortenerService service) {
        String module = generateModuleName(service);
        return ReflectionUtil.getInstance(module, ApiModule.class);
    }
    
    private static String generateModuleName(UrlShortenerService service) {
        String serviceName = service.toString().toLowerCase();
        String moduleName = StringUtils.sentance(serviceName) + API_MODULE;
        return StringUtils.delimit(".", MODULE_PACKAGE, serviceName, moduleName);
    }

}
