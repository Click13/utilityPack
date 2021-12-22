package com.click13.Graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestVertex {

    @Test
    public void testConstructor(){
        Vertex t1 = new Vertex("1", 1, 1);
        
        assertEquals("1",t1.getLabel());
        assertEquals(t1.getLabel(), "1");
    }

    @Test
    public void testLabel(){
        Vertex t1 = new Vertex("", 1, 1);
        assertEquals("", t1.getLabel());
        t1.setLabel("label");
        assertEquals("label", t1.getLabel());
    }

    @Test
    public void testX(){
        Vertex t1 = new Vertex("label", 1, 1);
        assertTrue(t1.getX() == 1);
        t1.setX(13);
        assertTrue(t1.getX() == 13);
        assertFalse(t1.getX() == 1);
    }

    @Test
    public void testY(){
        Vertex t1 = new Vertex("label", 1, 1);
        assertTrue(t1.getY() == 1);
        t1.setY(13);
        assertTrue(t1.getY() == 13);
        assertFalse(t1.getY() == 1);
    }

    @Test
    public void testEquals(){
        Vertex v1 = new Vertex("", 1, 2);
        Vertex v2 = new Vertex("", 1, 2);
        assertTrue(v1.equals(v2));
        assertTrue(v2.equals(v1));
    }

    @Test
    public void testGetDistance(){
        Vertex v1 = new Vertex("label", 1, 1);
        v1.setDistance(1.0f);
        assertTrue(1.0f == v1.getDistance());
        assertFalse(2.0f == v1.getDistance());
    }
}
