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

package io.github.softwarecats.casino.bet;

import io.github.softwarecats.casino.event.Outcome;
import org.apache.commons.lang3.math.Fraction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BetTest {

    Bet bet;
    Outcome outcome;

    @Before
    public void setUp() {
        outcome = new Outcome("Outcome 1", Fraction.getFraction(2));
        bet = new Bet(1, outcome);
    }

    @Test
    public void winAmount() {
        Bet bet = new Bet(5, outcome);
        assertEquals(15, bet.winAmount());
    }

    @Test
    public void loseAmount() {
        Bet bet = new Bet(5, outcome);
        assertEquals(5, bet.loseAmount());
    }

    @Test
    public void price() {
        Assert.assertEquals(bet.getAmountBet(), bet.price());
    }
}