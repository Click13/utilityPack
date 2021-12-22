package com.click13.Graph;

public class Queue {
    private class Item{

        private Vertex vertex;
        private Item nextItem;

        public Item(Vertex vertex){
            this.vertex = vertex;
        }

        public Vertex getPayload(){
            return vertex;
        }

        public void setNextItem(Item nextItem){
            this.nextItem = nextItem;
        }

        public Item getNextItem(){
            return nextItem;
        }
    }

    private Item head;
    private boolean isOrdered;

    public Queue(boolean isOrdered){
        this.isOrdered = isOrdered;
        head = null;
    }

    public boolean isOrdered(){
        return isOrdered;
    }

    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean enqueue(Vertex vertex){
        if (head == null){
            head = new Item(vertex);
            return true;
        }
        else {
            if (contains(vertex)){
                return false;
            }
            else{
                Item pointer = head;
                while(pointer.getNextItem() != null){
                    pointer = pointer.getNextItem();
                }
                Item newItem = new Item(vertex);
                pointer.setNextItem(newItem);
                if (isOrdered()){
                    bulkInsert(orderQueue());
                }
                return true;
            }
        }
    }

    private void bulkInsert(Item[] items){
        head = items[0];
        Item pointer = head;
        for (int i = 1; i < items.length; i++){
            pointer.setNextItem(items[i]);
            pointer = pointer.getNextItem();
        }
    }

    private Item[] orderQueue(){
        Vertex[] verticies = new Vertex[size()];
        Item pointer = head;
        for (int i = 0; i < verticies.length; i++){
            verticies[i] = pointer.getPayload();
            pointer = pointer.getNextItem();
        }
        for (int i = 0; i < verticies.length; i++){
            tausche(posOf(minimum(i, verticies), verticies), i, verticies);
        }
        Item[] out = new Item[verticies.length];
        for (int i = 0; i < verticies.length; i++){
            out[i] = new Item(verticies[i]);
        }
        return out;
    }

    private Vertex[] tausche(int a, int b, Vertex[] verticies){
        Vertex tmp = verticies[a];
        verticies[a] = verticies[b];
        verticies[b] = tmp;
        return verticies;
    }

    private float minimum(int start, Vertex[] verticies){
        float min = verticies[start].getDistance();
        for (int i = 0; i < verticies.length; i++){
            if (verticies[i].getDistance() < min){
                min = verticies[i].getDistance();
            }
        }
        return min;
    }

    private int posOf(float distanz, Vertex[] verticies){
        int out = 0;
        for (int i = 0; i < verticies.length; i++){
            if (verticies[i].getDistance() == distanz){
                out = i;
            }
        }
        return out;
    }

    public boolean contains(Vertex vertex){
        Item pointer = head;
        while (pointer.getNextItem() != null){
            if (pointer.getPayload().equals(vertex)){
                return true;
            }
            pointer = pointer.getNextItem();
        }
        return false;
    }

    public boolean dequeue(){
        if (head == null){
            return false;
        }
        head = head.getNextItem();
        return true;
    }

    public Vertex getHead(){
        if (head == null){
            return null;
        }
        else{
            return head.getPayload();
        }
    }

    public void empty(){
        head = null;
    }

    public int size(){
        int out = 0;
        Item pointer = head;
        if (isEmpty()){
            return out;
        }
        while(pointer.getNextItem() != null){
            out++;
            pointer = pointer.getNextItem();
        }
        return out;
    }
}
