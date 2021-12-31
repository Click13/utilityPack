package com.click13.Datenstrukturen;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Click13Queue<E>{

    private static class Node<E>{
        private E content;
        private Node<E> nextNode;

        private void setContent(E content){
            this.content = content;
        }

        public void setNextNode(Node<E> nextNode){
            this.nextNode = nextNode;
        }

        public Node<E> getNextNode(){
            return nextNode;
        }

        public E getContent(){
            return content;
        }

        public boolean hasNextNode(){
            if (nextNode != null){
                return true;
            }
            else {
                return false;
            }
        }
    }

    private Node <E> head;
    private int size;

    public Click13Queue(){
        head = null;
        size = 0;
    }

    public boolean add(E e) throws IllegalStateException {
        Node<E> neu = new Node<>();
        neu.setContent(e);
        if (isEmpty()){
            head = neu;
            size++;
            return true;
        }
        try {
            Node<E> pointer = head;
            while (pointer.hasNextNode()) {
                pointer = pointer.getNextNode();
            }
            pointer.setNextNode(neu);
            size++;
            return true;
        }
        catch (Exception exception) {
            throw new IllegalStateException();
        }
    }

    public E remove() throws NoSuchElementException{
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else{
            Node<E> tmp = head;
            head = head.getNextNode();
            size--;
            return tmp.getContent();
        }
    }

    public boolean offer(E e) throws ClassCastException, NullPointerException, IllegalStateException{
        if (e == null){
            throw new NullPointerException("NULL is not allowed here!");
        }
        if (!(e instanceof E)){
            throw new ClassCastException();
        }
        try {
            return add(e);
        }
        catch (IllegalStateException illegalStateException){
            throw new IllegalStateException(illegalStateException);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size() == 0 && head == null){
            return true;
        }
        else{
            return false;
        }
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public Iterator<E> getIterator(){
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return !isEmpty();
            }

            @Override
            public E next() {
                try{
                    return getNext();
                }
                catch(NullPointerException nullPointerException){}
                return null;
            }
        };
    }

    private E getNext() throws NullPointerException{
        if (head == null){
            throw new NullPointerException();
        }
        return remove();
    }
}
