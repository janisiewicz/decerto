package com.decerto.demo.operator;

import java.util.function.BinaryOperator;

public interface DataOperator<T> extends BinaryOperator<T> {
    String getCode();
}
