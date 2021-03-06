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

import lombok.Getter;
import org.apache.commons.lang3.math.Fraction;

import java.util.Objects;

/**
 * Outcome contains a single outcome on which a bet can be placed.
 */
public class Outcome {

    /**
     * Holds the name of the Outcome. Examples include “1", “Red”, “Pass Line”.
     */
    protected final String name;

    /**
     * Holds the fractional odds for this Outcome. This is the multiplier for the win amount.
     */
    @Getter protected final Fraction odds;

    /**
     * Sets the name and odds from the parameters.
     * The denominator will be 1.
     *
     * @param name the name of this outcome
     * @param odds the payout odds numerator
     */
    public Outcome(String name, int odds) {
        this(name, odds, 1);
    }

    /**
     * Sets the name and odds from the parameters. This method will create an appropriate {@link Fraction} from the given
     * values.
     *
     * @param name        the name of this outcome
     * @param numerator   the payout odds numerator
     * @param denominator the payout odds denominator
     */
    public Outcome(String name, int numerator, int denominator) {
        this(name, Fraction.getFraction(numerator, denominator));
    }

    /**
     * Sets the name and odds from the parameters.
     *
     * @param name the name of this outcome
     * @param odds the payout odds as a fraction
     */
    public Outcome(String name, Fraction odds) {
        this.name = name;
        this.odds = odds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outcome outcome = (Outcome) o;
        return Objects.equals(name, outcome.name) && Objects.equals(odds, outcome.odds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, odds);
    }

    /**
     * Returns the product of this {@link Outcome}‘s odds by the given amount.
     *
     * @param amount amount of the bet
     * @return the amount won
     */
    public Fraction winAmount(Fraction amount) {
        return odds.multiplyBy(amount);
    }

    /**
     * Returns the product of this {@link Outcome}‘s odds by the given amount.
     *
     * @param amount amount of the bet
     * @return the amount won
     */
    public Fraction winAmount(int amount) {
        return odds.multiplyBy(Fraction.getFraction(amount));
    }

    /**
     * Returns the product this {@link Outcome}'s odds numerator by the given amount, divided by the odds' denominator.
     *
     * @param amount the amount
     * @param event  the event that determines the actual odds to use
     * @return the fraction
     */
    public Fraction winAmount(Fraction amount, RandomEvent event) {
        return winAmount(amount);
    }

    /**
     * Returns the product this {@link Outcome}'s odds numerator by the given amount, divided by the odds' denominator.
     *
     * @param amount the amount
     * @param event  the event that determines the actual odds to use
     * @return the fraction
     */
    public Fraction winAmount(int amount, RandomEvent event) {
        return winAmount(amount);
    }

    /**
     * An easy-to-read String output method is also handy. This should return a String representation of the name
     * and the odds. A form that looks like 1-2 Split (17:1) is the goal.
     *
     * @return string representation of the {@link Outcome}
     */
    @Override
    public String toString() {
        return String.format("%s (%d:%d)", name, odds.getNumerator(), odds.getDenominator());
    }
}
