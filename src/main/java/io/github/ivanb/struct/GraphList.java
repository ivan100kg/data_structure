package io.github.ivanb.struct;

import io.github.ivanb.Struct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphList implements Struct {
    private Map<Integer, java.util.List<Integer>> adjList;

    public GraphList() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        this.adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(int source, int destination) {
        this.adjList.get(source).add(destination);
        this.adjList.get(destination).add(source); // Для неориентированного графа
    }

    public java.util.List<Integer> getNeighbors(int vertex) {
        return this.adjList.get(vertex);
    }

    public void printGraph() {
        for (int vertex : this.adjList.keySet()) {
            System.out.println(vertex + " -> " + this.adjList.get(vertex));
        }
    }

    public static void main(String[] args) {

    }

    @Override
    public void show() {
        GraphList graph = new GraphList();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(3, 5);

        System.out.println(graph.getNeighbors(0));
        System.out.println(graph.getNeighbors(1));
        System.out.println(graph.getNeighbors(2));
        System.out.println(graph.getNeighbors(3));
        System.out.println(graph.getNeighbors(4));
        System.out.println(graph.getNeighbors(5));

        graph.printGraph();
    }
}
