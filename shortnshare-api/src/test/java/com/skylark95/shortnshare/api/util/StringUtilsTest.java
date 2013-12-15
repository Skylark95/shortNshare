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

import static org.fest.assertions.api.Assertions.assertThat;
import static com.skylark95.shortnshare.api.util.StringUtils.sentance;
import static com.skylark95.shortnshare.api.util.StringUtils.isEmpty;
import static com.skylark95.shortnshare.api.util.StringUtils.delimit;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void canSentanceString() {
        assertThat(sentance("sentance")).isEqualTo("Sentance");
    }
    
    @Test
    public void canSentanceNull() {
        assertThat(sentance(null)).isNull();
    }
    
    @Test
    public void isEmptyIfNull() {
        assertThat(isEmpty(null)).isTrue();
    }
    
    @Test
    public void isEmptyIfEmpty() {
        assertThat(isEmpty("")).isTrue();
    }
    
    @Test
    public void isNotEmptyIfNotEmpty() {
        assertThat(isEmpty("a")).isFalse();
    }
    
    @Test
    public void canDelimitString() {
        assertThat(delimit(".", "A", "B", "C")).isEqualTo("A.B.C");
    }

}
