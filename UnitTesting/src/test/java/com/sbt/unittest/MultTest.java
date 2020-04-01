package com.sbt.unittest;

import org.junit.Assert;
import org.junit.Test;

public class MultTest {
    Calculator calc = new Calculator();

    @Test
    public void testMult() {
        Assert.assertEquals(0, calc.mult(0, 0));
        Assert.assertEquals(0, calc.mult(-1, 0));
        Assert.assertEquals(0, calc.mult(1, 0));
        Assert.assertEquals(-1, calc.mult(-1, 1));
        Assert.assertEquals(1, calc.mult(-1, -1));
        Assert.assertEquals(1, calc.mult(1, 1));
    }
}
