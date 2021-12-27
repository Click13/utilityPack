package com.click13.Datenstrukturen;

import org.junit.Assert;
import org.junit.Test;

public class TestClick13Queue {

    @Test
    public void testConstructor(){
        Click13Queue<String> q = new Click13Queue<>();
        Assert.assertTrue(q.isEmpty());
        Assert.assertTrue(q.size() == 0);
    }

    @Test
    public void testClear(){
        Click13Queue<String> q = new Click13Queue<>();
        Assert.assertTrue(q.isEmpty());
        q.add("A");
        Assert.assertFalse(q.isEmpty());
        q.clear();
        Assert.assertTrue(q.isEmpty());
    }

    @Test
    public void testRemove(){//TODO
        Assert.assertTrue(false);
    }

    @Test
    public void testAdd(){//TODO
        Assert.assertTrue(false);
    }

    @Test
    public void testOffer(){//TODO
        Assert.assertTrue(false);
    }

    @Test
    public void testSize(){//TODO
        Assert.assertTrue(false);
    }

    @Test
    public void testGetIterator(){//TODO
        Assert.assertTrue(false);
    }
}
