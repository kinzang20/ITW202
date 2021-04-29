package com.example.todo_9;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
@SmallTest
public class ExampleUnitTest {
public   Calculator mCalculator;

@Before
    public void setUp(){
    mCalculator =new Calculator();
}
@Test
public  void addTwoNumbers(){
    double result = mCalculator.add(1d,2d);
    assertThat(result,is(equalTo(3d)));
}
    @Test
    public  void subTwoNumbers() {
        double result = mCalculator.sub(4d, 2d);
        assertThat(result, is(equalTo(2d)));
    }
    @Test
    public  void mulTwoNumbers() {
        double result = mCalculator.mul(-1d, 2d);
        assertThat(result, is(equalTo(-2d)));
    }
    @Test
    public  void divTwoNumbers() {
        double result = mCalculator.div(10d, 2d);
        assertThat(result, is(equalTo(5d)));
    }
}