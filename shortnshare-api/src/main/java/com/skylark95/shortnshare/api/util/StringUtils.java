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

public final class StringUtils {
    
    private StringUtils() {
    }
    
    public static String delimit(String delimiter, String... values) {
        StringBuilder builder = new StringBuilder();
        int last = values.length - 1;
        for (int i = 0; i < last; i++) {
            builder.append(values[i]);
            builder.append(delimiter);
        }
        builder.append(values[last]);
        return builder.toString();
    }
    
    public static String sentance(String string) {
        if (isEmpty(string)) {
            return string;
        }
        char upperCase = Character.toUpperCase(string.charAt(0));
        return upperCase + string.substring(1);
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

}
