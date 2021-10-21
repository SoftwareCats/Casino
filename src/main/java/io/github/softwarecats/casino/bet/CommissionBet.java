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
import io.github.softwarecats.casino.player.Player;
import org.apache.commons.lang3.math.Fraction;

public class CommissionBet extends Bet {

    protected double vigorish = 0.05;

    public CommissionBet(int amountBet, Outcome outcome) {
        super(amountBet, outcome);
    }

    public CommissionBet(int amountBet, Outcome outcome, Player parent) {
        super(amountBet, outcome, parent);
    }

    /**
     * <p>Computes the price for this bet.</p>
     *
     * <p>A Buy bet is a right bet; it has a numerator greater than or equal to the denominator (for example, 2:1 odds,
     * which risks 1 to win 2), the price is 5% of the amount bet. A $20 Buy bet has a price of $21.</p>
     *
     * <p>A Lay bet is a wrong bet; it has a denominator greater than the numerator (for example, 2:3 odds, which risks
     * 3 to win 2), the price is 5% of 2/3 of the amount. A $30 bet Laid at 2:3 odds has a price of $31, the $30 bet,
     * plus the vig of 5% of $20 payout.</p>
     *
     * @return the price to place the bet
     */
    @Override
    public int price() {
        double commission;

        if (outcome.getOdds().getNumerator() >= outcome.getOdds().getDenominator()) {
            // Buy bet
            commission = amountBet * vigorish;
        } else {
            // Lay bet
            commission = outcome.winAmount(amountBet).multiplyBy(Fraction.getFraction(vigorish)).doubleValue();
        }

        return (int) (super.price() + commission);
    }
}
