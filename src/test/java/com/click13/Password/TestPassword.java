package com.click13.Password;

import org.junit.Assert;
import org.junit.Test;

import static com.click13.Password.Password.isPasswordComplex;

public class TestPassword {

    @Test
    public void testIsPasswordComplex(){
        Assert.assertTrue(isPasswordComplex("AAgh90!"));
        Assert.assertTrue(isPasswordComplex("89HHioüag!?"));
        Assert.assertFalse(isPasswordComplex("password"));
        Assert.assertFalse(isPasswordComplex("test"));
        Assert.assertFalse(isPasswordComplex("13"));
    }
}
