package com.click13.Logging;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Level;

public class LoggTest {

    @Test
    public void testStatics(){
        Assert.assertEquals(Logg.OFF, Level.OFF);
        Assert.assertEquals(Logg.SEVERE, Level.SEVERE);
        Assert.assertEquals(Logg.WARNING, Level.WARNING);
        Assert.assertEquals(Logg.INFO, Level.INFO);
        Assert.assertEquals(Logg.CONFIG, Level.CONFIG);
        Assert.assertEquals(Logg.FINE, Level.FINE);
        Assert.assertEquals(Logg.FINER, Level.FINER);
        Assert.assertEquals(Logg.FINEST, Level.FINEST);
        Assert.assertEquals(Logg.ALL, Level.ALL);
    }

    @Test
    public void testLevel(){
        Logg logg = new Logg();
        logg.setLevel(Logg.OFF);
        Assert.assertEquals(logg.getLevel(),Logg.OFF);
        logg.setLevel(Logg.SEVERE);
        Assert.assertEquals(logg.getLevel(),Logg.SEVERE);
        logg.setLevel(Logg.WARNING);
        Assert.assertEquals(logg.getLevel(),Logg.WARNING);
        logg.setLevel(Logg.INFO);
        Assert.assertEquals(logg.getLevel(), Logg.INFO);
        logg.setLevel(Logg.CONFIG);
        Assert.assertEquals(logg.getLevel(), Logg.CONFIG);
        logg.setLevel(Logg.FINE);
        Assert.assertEquals(logg.getLevel(), Logg.FINE);
        logg.setLevel(Logg.FINER);
        Assert.assertEquals(logg.getLevel(), Logg.FINER);
        logg.setLevel(Logg.FINEST);
        Assert.assertEquals(logg.getLevel(), Logg.FINEST);
        logg.setLevel(Logg.ALL);
        Assert.assertEquals(logg.getLevel(), Logg.ALL);
    }
}
