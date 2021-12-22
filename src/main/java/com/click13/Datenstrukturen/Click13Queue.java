package com.click13.Datenstrukturen;

import java.util.NoSuchElementException;

public class Click13Queue<E>{

    private class Node<E>{
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

    private Node <E>head;
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

    public boolean offer(E e) throws ClassCastException, NullPointerException{
        if (e == null){
            throw new NullPointerException();
        }
        if (!(e instanceof E)){
            throw new ClassCastException();
        }
        return add(e);
    }

    public E poll() {
        if (isEmpty()){
            return null;
        }
        Node<E> tmp = head;
        head = head.getNextNode();
        size--;
        return tmp.getContent();
    }

    public E element() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return head.getContent();
    }

    public E peek() {
        if (isEmpty()){
            return null;
        }
        return head.getContent();
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
}
