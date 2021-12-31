package com.click13.Datenstrukturen;

import org.jetbrains.annotations.Contract;

import java.util.LinkedList;

public class Graph<E>{

    private static class Node<E>{
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

        public void removeConnectedNode(Node<E> node){
            connectedNodes.remove(node);
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
        Node<E> tmp = new Node<>();
        tmp.setContent(e);
        return nodes.contains(tmp);
    }

    public boolean add(E e) {
        Node<E> tmp = new Node<>();
        tmp.setContent(e);
        return nodes.add(tmp);
    }

    public boolean remove(E e) {
        Node<E> tmp = new Node<>();
        tmp.setContent(e);
        return nodes.remove(tmp);
    }

    public void clear() {
        nodes.clear();
    }

    public boolean addEdge(E e,E a){
        Node<E> t1 = new Node<>();
        t1.setContent(e);
        Node<E> t2 = new Node<>();
        t2.setContent(a);
        if (nodes.contains(t1) && nodes.contains(t2)){
            Node<E> n1 = nodes.get(nodes.indexOf(t1));
            Node<E> n2 = nodes.get(nodes.indexOf(t2));
            n1.addConnectedNode(n2);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean removeEdge(E e, E a){
        Node<E> t1 = new Node<>();
        t1.setContent(e);
        Node<E> t2 = new Node<>();
        t2.setContent(a);
        if (nodes.contains(t1) && nodes.contains(t2)){
            Node<E> n1 = nodes.get(nodes.indexOf(t1));
            Node<E> n2 = nodes.get(nodes.indexOf(t2));
            if (!n1.hasConnectedNodes()){
                return false;
            }
            else{
                n1.removeConnectedNode(n2);
                return true;
            }
        }
        else{
            return false;
        }
    }
}
