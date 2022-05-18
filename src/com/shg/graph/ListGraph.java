package com.shg.graph;

import java.util.*;

/**
 * @author: shg
 * @create: 2022-05-17 4:21 下午
 */
public class ListGraph<K, E> implements Graph<K, E> {
    private Map<K, Vertex<K, E>> vertices;
    private Set<Edge<K, E>> edges;

    public ListGraph() {
        vertices = new HashMap<>();
        edges = new HashSet<>();
    }

    public void print() {
        vertices.forEach((k, vertex) -> {
            System.out.println(k + "->" + vertex);
        });

        edges.forEach(System.out::println);
    }

    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(K k) {
        vertices.put(k, new Vertex<>(k));
    }

    @Override
    public void addEdge(K from, K to) {
        addEdge(from, to, null);
    }

    @Override
    public void addEdge(K from, K to, E weight) {
        Vertex<K, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        Vertex<K, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        Edge<K, E> edge = new Edge<>(weight, fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
        }
        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeVertex(K k) {
        Vertex<K, E> vertex = vertices.remove(k);
        if (vertex == null) return;
        Iterator<Edge<K, E>> iterator = vertex.inEdges.iterator();
        while (iterator.hasNext()) {
            Edge<K, E> edge = iterator.next();
            edge.from.outEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }
        iterator = vertex.outEdges.iterator();
        while (iterator.hasNext()) {
            Edge<K, E> edge = iterator.next();
            edge.to.inEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }
    }

    @Override
    public void removeEdge(K from, K to) {
        Vertex<K, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;
        Vertex<K, E> toVertex = vertices.get(to);
        if (toVertex == null) return;

        Edge<K, E> edge = new Edge<>(fromVertex, toVertex);
        if (edges.remove(edge)) {
            fromVertex.outEdges.remove(edge);
            toVertex.inEdges.remove(edge);
        }
    }

    @Override
    public void bfs(K begin) {
        Vertex<K, E> vertex = vertices.get(begin);
        if (vertex == null) throw new IllegalArgumentException("不存在该节点");

        Queue<Vertex<K, E>> queue = new LinkedList<>();
        Set<K> visited = new HashSet<>(); // 使用一个Set用来记录哪些顶点已经入队
        queue.offer(vertex);
        visited.add(vertex.key);
        while (!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.println(vertex);
            vertex.outEdges.forEach(edge -> {
                if (!visited.contains(edge.to.key)) {
                    queue.offer(edge.to);
                    visited.add(edge.to.key);
                }
            });
        }
    }

    /**
     * 图的边
     *
     * @param <K>
     * @param <E>
     */
    private static class Edge<K, E> {
        E weight;
        Vertex<K, E> from;
        Vertex<K, E> to;

        public Edge(Vertex<K, E> from, Vertex<K, E> to) {
            this(null, from, to);
        }

        public Edge(E weight, Vertex<K, E> from, Vertex<K, E> to) {
            this.weight = weight;
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge<?, ?> edge = (Edge<?, ?>) o;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "weight=" + weight +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }

    /**
     * 图的定点
     *
     * @param <K>
     * @param <E>
     */
    private static class Vertex<K, E> {
        K key;
        Set<Edge<K, E>> inEdges;
        Set<Edge<K, E>> outEdges;

        public Vertex(K key) {
            this.key = key;
            this.inEdges = new HashSet<>();
            this.outEdges = new HashSet<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?, ?> vertex = (Vertex<?, ?>) o;
            return Objects.equals(key, vertex.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }

    @Override
    public String toString() {
        return "ListGraph{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                '}';
    }
}
