package com.bnpp.bcefit.lafabrique.saison7.avengers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;


class DivideUtilTest {

    @Test
    void test_divide() {

        assertThat(DivideUtil.divide(4, 2)).isEqualTo(2.0);
    }

    @Test
    void test_should_throw_exception_when_divide_by_zero() {
        Throwable aThrowable = catchThrowable(() -> DivideUtil.divide(4, 0));
        assertThat(aThrowable).isInstanceOf(ArithmeticException.class).hasMessageContaining("by zero");
    }
}