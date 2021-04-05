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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public abstract class RandomEvent extends HashSet<Outcome> {

    /**
     * Instantiates a empty RandomEvent. Outcomes can be added to it later.
     */
    public RandomEvent() {
        super();
    }

    /**
     * Creates a RandomEvent using the super() statement, invoking the TreeSet constructor.
     * It then loads that collection using elements of the given array.
     *
     * @param outcomes a primitive array of outcomes
     */
    public RandomEvent(Outcome[] outcomes) {
        super(Arrays.asList(outcomes));
    }

    /**
     * Creates a RandomEvent using the super() statement to invoke the TreeSet constructor.
     * It then loads that collection using the collection parameter.
     * This relies on the fact that all classes that implement Collection will provide the iterator(); the
     * constructor can convert the elements of the input collection to a proper Set.
     *
     * @param outcomes a collection of outcomes
     */
    public RandomEvent(Collection<? extends Outcome> outcomes) {
        super(outcomes);
    }

    /**
     * Adds an Outcome to this RandomEvent. This can be used by a builder to construct all of the bets in this Bin.
     * Since this class is really just a facade over the underlying collection object, this method can simply
     * delegate the real work to the underlying collection.
     *
     * @param outcome an outcome to add to this RandomEvent
     * @return true if this set did not already contain the specified element
     */
    @Override
    public boolean add(Outcome outcome) {
        return super.add(outcome);
    }

    /**
     * An easy-to-read representation of the list of Outcomes in this Bin.
     *
     * @return string of the form ‘[outcome, outcome, ...]’
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
