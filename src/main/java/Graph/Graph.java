package Graph;

import java.util.LinkedList;

public class Graph {

    private LinkedList<Vertex> verticies;

    public Graph(){
       verticies = new LinkedList<>();
    }

    public boolean addVertex(String label,int x, int y){
        for (int i = 0; i < verticies.size();i++){
            if (verticies.get(i).getLabel().equals(label)){
                return false;
            }
        }
        verticies.add(new Vertex(label, x, y));
        return true;
    }

    public boolean removeVertex(String label){
        for (int i = 0; i < verticies.size(); i++){
            if (verticies.get(i).getLabel().equals(label)){
                for (int j = 0; j < verticies.size(); j++){
                    verticies.get(j).removeEdgeToVertex(verticies.get(i));
                }
                verticies.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean addEdge(String label1, String label2){
        Vertex v1 = null;
        Vertex v2 = null;
        for (int i = 0; i < verticies.size(); i++){
            if (verticies.get(i).getLabel().equals(label1)){
                v1 = verticies.get(i);
            }
        }
        for (int i = 0; i < verticies.size(); i++){
            if (verticies.get(i).getLabel().equals(label2)){
                v2 = verticies.get(i);
            }
        }
        if (v1 != null && v2 != null){
            boolean result1 = v1.addEdgetoVertex(v2);
            boolean result2 = v2.addEdgetoVertex(v1);
            if (result1 && result2){
                return true;
            }
            else{
                v1.removeEdgeToVertex(v2);
                v2.removeEdgeToVertex(v1);
                return false;
            }
        }
        else{
            return false;
        }
    }

    public boolean removeEdge(String label1, String label2){
        Vertex v1 = null;
        Vertex v2 = null;
        for (int i = 0; i < verticies.size(); i++){
            if (verticies.get(i).getLabel().equals(label1)){
                v1 = verticies.get(i);
            }
        }
        for (int i = 0; i < verticies.size(); i++){
            if (verticies.get(i).getLabel().equals(label2)){
                v2 = verticies.get(i);
            }
        }
        if (v1 != null && v2 != null){
            boolean result1 = v1.removeEdgeToVertex(v2);
            boolean result2 = v2.removeEdgeToVertex(v1);
            if (result1 && result2){
                return true;
            }
            if (result1 && !result2){
                v1.addEdgetoVertex(v2);
            }
            if (!result1 && result2){
                v2.addEdgetoVertex(v1);
            }
            return false;
        }
        else{
            return false;
        }
    }

    public LinkedList<Vertex> getAdjVertices(String label){
        for (int i = 0; i < verticies.size(); i++){
            if (verticies.get(i).getLabel().equals(label)){
                return verticies.get(i).getAdjVertices();
            }
        }
        return null;
    }

    private float heurestik(Vertex aktuell, Vertex ziel){
        int aktuellX = aktuell.getX();
        int aktuellY = aktuell.getY();
        int zielX = ziel.getX();
        int zielY = ziel.getY();
        return (float) Math.sqrt((aktuellX-zielX)*(aktuellX-zielX)+(aktuellY-zielY)*(aktuellY-zielY));
    }

    public LinkedList<String> findPath(String startLabel, String zielLabel){
        Queue visited = new Queue(false);
        Queue visible = new Queue(true);
        Vertex start = getVertex(startLabel);
        Vertex end = getVertex(zielLabel);
        if (start != null && end != null){
            for (int i = 0; i < verticies.size(); i++){
                verticies.get(i).setDistance(heurestik(verticies.get(i), end));
            }
            visible.enqueue(start);
            while (!visible.isEmpty()){
                Vertex item = visible.getHead();
                visible.dequeue();
                LinkedList<Vertex> piontVisibleVerticies = item.getAdjVertices();
                visited.enqueue(item);
                if(item.equals(end)){
                    for (int i = 0; i < visited.size(); i++){

                    }
                }
                for (int i = 0; i < piontVisibleVerticies.size(); i++){
                    if (visited.contains(piontVisibleVerticies.get(i))){
                        piontVisibleVerticies.remove(i);
                    }
                }
                for (int i = 0; i < piontVisibleVerticies.size(); i++){
                    visible.enqueue(piontVisibleVerticies.get(i));
                }
            }
            return null;
        }
        else{
            return null;
        }
    }

    public boolean hasPath(String startLabel, String zielLabel){
        if (findPath(startLabel, zielLabel) != null){
            return true;
        }
        else {
            return false;
        }
    }

    private Vertex getVertex(String label){
        for (int i = 0; i < verticies.size(); i++){
            if(verticies.get(i).getLabel().equals(label)){
                return verticies.get(i);
            }
        }
        return null;
    }
}
