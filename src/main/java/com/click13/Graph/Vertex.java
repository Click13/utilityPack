package com.click13.Graph;

import java.util.LinkedList;

public class Vertex {

    private String label;
    private LinkedList<Vertex> adjVertices;
    private float distance;
    int x;
    int y;

    public Vertex(String label, int x, int y){
        this.x = x;
        this.y = y;
        this.label = label;
        adjVertices = new LinkedList<>();
        adjVertices.clear();
    }

    public void setLabel(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public LinkedList<Vertex> getAdjVertices(){
        return adjVertices;
    }

    public boolean addEdgetoVertex(Vertex vertex){
        if (adjVertices.contains(vertex)){
            return false;
        }else{
            adjVertices.add(vertex);
            return true;
        }
    }

    public boolean removeEdgeToVertex(Vertex vertex){
        if (adjVertices.contains(vertex)){
            adjVertices.remove(vertex);
            return true;
        }
        else{
            return false;
        }
    }

    public float getDistance(){
        return distance;
    }

    public void setDistance(float distance){
        this.distance = distance;
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public boolean equals(Vertex vertex){
        if (vertex.getLabel().equals(this.label) && this.x == vertex.getX() && this.y == vertex.getY()){
            return true;
        }
        else{
            return false;
        }
    }
}
