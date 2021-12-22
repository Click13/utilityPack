package com.click13.Datenstrukturen;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph<E>{

    private class Node<E>{
        private E content;
        private LinkedList<Node<E>> connectedNodes;

        public Node(){
            content = null;
            connectedNodes = new LinkedList<>();
        }

        private void setContent(E content){
            this.content = content;
        }

        public void addConnectedNode(Node<E> newNode){
            connectedNodes.add(newNode);
        }

        public LinkedList<Node<E>> getConnectedNodes(){
            return connectedNodes;
        }

        public E getContent(){
            return content;
        }

        public boolean equals(Node<E> n){
            if (n == null){
                return false;
            }
            if (n.getContent() == content && n.getConnectedNodes().equals(connectedNodes) ){
                return true;
            }
            return false;
        }

        public boolean hasConnectedNodes(){
            if (connectedNodes.isEmpty()){
                return false;
            }
            else {
                return true;
            }
        }
    }

    LinkedList<Node<E>> nodes;

    public Graph(){
        nodes = new LinkedList<>();
    }

    public int size() {
        return nodes.size();
    }

    public boolean isEmpty() {
        if (size() == 0){
            return true;
        }
        return false;
    }

    public boolean contains(E e) {
        return false;
    }

    public boolean add(E e) {
        Node<E> tmp = new Node<>();
        tmp.setContent(e);
        return nodes.add(tmp);
    }

    public boolean remove(E e) {//TODO
        Node<E> tmp = new Node<>();
        return nodes.remove(tmp);
    }

    public void clear() {
        nodes.clear();
    }
}
