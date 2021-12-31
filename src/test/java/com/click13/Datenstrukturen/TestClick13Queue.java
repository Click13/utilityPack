package com.click13.Datenstrukturen;

import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Random;

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
    public void testRemove(){
        Click13Queue<String> q = new Click13Queue<>();
        String[] arr = new String[1000];
        for (int i= 0; i < arr.length; i++){
            arr[i] = getRandomString(10);
            q.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++){
            Assert.assertTrue(arr[i].equals(q.remove()));
        }
    }

    @Test
    public void testAdd(){
        Click13Queue<String> q = new Click13Queue<>();
        int anzahltest = 1000;
        Assert.assertEquals(0, q.size());
        String[] arr = new String[anzahltest];
        for (int i= 0; i < arr.length; i++){
            arr[i] = getRandomString(10);
            q.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++){
            Assert.assertTrue(arr[i].equals(q.remove()));
        }
    }

    @Test
    public void testOffer(){
        Click13Queue<String> q = new Click13Queue<>();
        try{
            q.offer(null);
            Assert.fail();
        }
        catch (NullPointerException e){
            Assert.assertEquals(e.getMessage(),"NULL is not allowed here!");
        }
        Assert.assertTrue(q.isEmpty());
        q.offer("");
        Assert.assertFalse(q.isEmpty());
        q.clear();

        String[] arr = new String[1000];
        for (int i= 0; i < arr.length; i++){
            arr[i] = getRandomString(10);
            q.offer(arr[i]);
        }
        for (int i = 0; i < arr.length; i++){
            Assert.assertTrue(arr[i].equals(q.remove()));
        }
    }

    @Test
    public void testSize(){
        Click13Queue<String> q = new Click13Queue<>();
        int anzahlTests = 10000;
        Assert.assertTrue(q.size() == 0);
        for (int i = 1; i <= anzahlTests; i++) {
            q.add("");
            Assert.assertEquals(q.size(), i);
        }
        for (int i = anzahlTests; i != 0; i--){
            Assert.assertEquals(q.size(), i);
            q.remove();
            Assert.assertEquals(q.size(), i-1);
        }
    }

    @Test
    public void testIsEmpty(){
        Click13Queue<String> q = new Click13Queue<>();
        Assert.assertTrue(q.isEmpty());
        int anzahlTests = 10;
        for(int i = 1; i <= anzahlTests; i++){
            q.add("");
            Assert.assertFalse(q.isEmpty());
        }
        for (int i = anzahlTests; i != 0; i--){
            Assert.assertFalse(q.isEmpty());
            q.remove();
        }
        Assert.assertTrue(q.isEmpty());
    }

    @Test
    public void testGetIterator(){
        Click13Queue<String> q = new Click13Queue<>();
        int anzahltests = 1000;
        String[] arr = new String[anzahltests];
        for (int i = 0; i < anzahltests; i++){
            arr[i] = getRandomString(10);
            q.add(arr[i]);
        }
        Iterator<String> e = q.getIterator();
        int i = 0;
        while (e.hasNext()){
            Assert.assertEquals(e.next(),arr[i]);
            i++;
        }
    }

    private @NotNull String getRandomString(int i){
        byte[] bytearray = new byte[256];
        String myString = null;
        StringBuffer buffer = null;
        String alphanumerics = null;

        new Random().nextBytes(bytearray);
        myString = new String(bytearray, StandardCharsets.UTF_8);
        buffer = new StringBuffer();
        alphanumerics = myString.replaceAll("[^A-Z0-9]", "");
        for (int m = 0; m < alphanumerics.length(); m++){
            if (Character.isLetter(alphanumerics.charAt(m)) && (i > 0)  || Character.isDigit(alphanumerics.charAt(m)) && (i > 0)){
                buffer.append(alphanumerics.charAt(m));
                i--;
            }
        }
        return buffer.toString();
    }
}
