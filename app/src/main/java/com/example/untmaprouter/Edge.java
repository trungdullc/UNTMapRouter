package com.example.untmaprouter;

// Edge class covering roads with distance, direction, and linked location
public class Edge {
    private Node from;
    private Node to;
    private double weight;
    private String direction;

    public Edge(Node from, Node to, double weight, String direction) {
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.direction = direction;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    public String getDirection() {
        return direction;
    }
}
