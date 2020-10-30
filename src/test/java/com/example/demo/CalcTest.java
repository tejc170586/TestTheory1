package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.api.AbstractAssert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalcTest {
	static Calc calc = null;
	@BeforeAll
	static void テスト前処理() {
	    calc = new Calc();
	}
	@Test
	void addテスト_正常() {
	    assertEquals(calc.add(1, 3), 4);
	    assertThat(calc.add(1, 3)).isEqualTo(4);
	    
	    //クラスCalcのメソッドsub(int x, int y)の正常系テスト
	    assertEquals(calc.sub(3, 1), 2);
	    
	    //クラスCalcのメソッドdiv(int x, int y)の正常系テスト
	    assertThatThrownBy(() -> {
	    	calc.div(5, 0);
	    })
	    .isInstanceOf(ArithmeticException.class)
	    .hasMessageContaining("by zero");
	    
	    //クラスCalcのメソッドmult(int x, int y)の正常系テスト
	    assertEquals(calc.mul(2, 5), 10);
	}
	@AfterAll
	static void テスト後処理() {
	    calc = null;
	}
}
