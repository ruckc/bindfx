/*
 * Copyright 2016 ruckc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.ruck.bindfx;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ruckc
 */
public final class MathBindings {

    private MathBindings() {
    }

    public static NumberBinding abs(NumberBinding ov) {
        if (ov instanceof DoubleBinding) {
            return abs((DoubleBinding) ov);
        } else {
            throw new UnsupportedOperationException("Does not current support " + ov.getClass() + " in the abs method");
        }
    }

    public static DoubleBinding abs(DoubleBinding ov) {
        DoubleBinding db = new DoubleBinding() {
            {
                super.bind(ov);
            }

            @Override
            protected double computeValue() {
                return Math.abs(ov.getValue());
            }

            @Override
            public ObservableList<?> getDependencies() {
                return FXCollections.singletonObservableList(ov);
            }

            @Override
            public void dispose() {
                super.unbind(ov);
            }
        };
        return db;
    }

    public static DoubleBinding abs(ObservableValue<Double> ov) {
        DoubleBinding db = new DoubleBinding() {
            {
                super.bind(ov);
            }

            @Override
            protected double computeValue() {
                return Math.abs(ov.getValue());
            }

            @Override
            public ObservableList<?> getDependencies() {
                return FXCollections.singletonObservableList(ov);
            }

            @Override
            public void dispose() {
                super.unbind(ov);
            }
        };
        return db;
    }
}
