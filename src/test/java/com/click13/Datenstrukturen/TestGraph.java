package com.click13.Datenstrukturen;

import org.junit.Assert;
import org.junit.Test;

public class TestGraph {

    @Test
    public void testSize(){
        Graph<String> g = new Graph<>();
        int anzahlttest = 10000;
        Assert.assertTrue(g.size() == 0);
        for (int i = 0; i < anzahlttest; i++){
            g.add("");
            Assert.assertTrue(g.size() == i + 1);
        }
    }

    @Test
    public void testIsEmpty(){
        Graph<String> g = new Graph<>();
        Assert.assertTrue(g.isEmpty());
        int anzahlttest = 10000;
        for (int i = 0; i <= anzahlttest; i++){
            g.add("" + i);
            Assert.assertFalse(g.isEmpty());
        }
        for (int i = anzahlttest+1; i != 0; i--){
            g.remove("" + i);
            Assert.assertFalse(g.isEmpty());
        }
        Assert.assertTrue(g.isEmpty());
    }

    @Test
    public void testContains(){//TODO
        Assert.fail();
    }

    @Test
    public void testAdd(){//TODO
        Assert.fail();
    }

    @Test
    public void testRemove(){//TODO
        Assert.fail();
    }

    @Test
    public void testClear(){//TODO
        Assert.fail();
    }

    @Test
    public void testAddEdge(){//TODO
        Assert.fail();
    }

    @Test
    public void testRemoveEdge(){//TODO
        Assert.fail();
    }
}
