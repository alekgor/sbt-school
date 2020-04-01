package com.sbt.unittest;

import org.junit.Assert;
import org.junit.Test;

public class SubTest {
    Calculator calc = new Calculator();

    @Test
    public void testSub() {
        Assert.assertEquals(0,calc.sub(0,0));
        Assert.assertEquals(1,calc.sub(1,0));
        Assert.assertEquals(1,calc.sub(0,-1));
        Assert.assertEquals(0,calc.sub(1,1));
        Assert.assertEquals(0,calc.sub(-1,-1));
    }
}
