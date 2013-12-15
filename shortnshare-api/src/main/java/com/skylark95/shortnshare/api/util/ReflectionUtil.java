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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class ReflectionUtil {
    
    private ReflectionUtil() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String className, Class<T> type, Object... initargs) {
        return (T) getInstance(className, initargs);
    }

    public static Object getInstance(String className, Object... initargs) {
        Object instance = null;
        
        try {
            instance = getInstance(Class.forName(className), initargs);
        } catch (ClassNotFoundException e) {
            throwReflectionUtilException(e);
        }
        
        return instance;
    }

    public static <T> T getInstance(Class<T> clazz, Object... initargs) {
        T instance = null;

        if (clazz != null) {
            try {
                instance = getConstructor(clazz).newInstance(initargs);
            } catch (IllegalArgumentException e) {
                throwReflectionUtilException(e);
            } catch (InstantiationException e) {
                throwReflectionUtilException(e);
            } catch (IllegalAccessException e) {
                throwReflectionUtilException(e);
            } catch (InvocationTargetException e) {
                throwReflectionUtilException(e);
            }
        }

        return instance;
    }

    private static <T> Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameterTypes) {
        Constructor<T> constructor = null;

        try {
            constructor = clazz.getConstructor(parameterTypes);
        } catch (SecurityException e) {
            throwReflectionUtilException(e);
        } catch (NoSuchMethodException e) {
            throwReflectionUtilException(e);
        }

        return constructor;
    }

    private static void throwReflectionUtilException(Throwable cause) {
        throw new ReflectionUtilsException(cause);
    }

}
