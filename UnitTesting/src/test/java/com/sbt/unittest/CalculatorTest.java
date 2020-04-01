package com.sbt.unittest;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParametersSumTest.class,
        DivTest.class,
        MultTest.class,
        SubTest.class
})
public class CalculatorTest {
}
