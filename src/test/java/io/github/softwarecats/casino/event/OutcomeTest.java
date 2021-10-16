/*
 * Copyright © Bowen Wu 2021.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.softwarecats.casino.event;

import org.apache.commons.lang3.math.Fraction;
import org.junit.Test;

import static org.junit.Assert.*;

public class OutcomeTest {

    @Test
    public void testEquals() {
        assertEquals(
                new Outcome("Outcome 1", Fraction.TWO_THIRDS),
                new Outcome("Outcome 1", Fraction.TWO_THIRDS));

        assertNotEquals(
                new Outcome("Outcome 1", Fraction.TWO_THIRDS),
                new Outcome("Outcome 1", Fraction.THREE_FIFTHS));
    }

    @Test
    public void testHashCode() {
        assertEquals(
                new Outcome("Outcome 1", Fraction.TWO_THIRDS).hashCode(),
                new Outcome("Outcome 1", Fraction.TWO_THIRDS).hashCode());

        assertNotEquals(
                new Outcome("Outcome 1", Fraction.TWO_THIRDS).hashCode(),
                new Outcome("Outcome 1", Fraction.THREE_FIFTHS).hashCode());
    }

    @Test
    public void winAmountWithFraction() {
        assertEquals(Fraction.ONE, new Outcome("Outcome 1", Fraction.TWO_THIRDS).winAmount(Fraction.getFraction(3, 2)));
        assertEquals(Fraction.ONE, new Outcome("Outcome 1", Fraction.THREE_FIFTHS).winAmount(Fraction.getFraction(5, 3)));
    }

    @Test
    public void WinAmountWithInt() {
        assertEquals(Fraction.ONE, new Outcome("Outcome 1", Fraction.ONE_THIRD).winAmount(3));
        assertEquals(Fraction.ONE, new Outcome("Outcome 1", Fraction.ONE_FIFTH).winAmount(5));
    }

    @Test
    public void testToString() {
        assertEquals("Outcome 1 (2:3)", new Outcome("Outcome 1", Fraction.TWO_THIRDS).toString());
        assertEquals("Outcome 2 (3:5)", new Outcome("Outcome 2", Fraction.THREE_FIFTHS).toString());
    }
}