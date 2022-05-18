package com.shg.graph;


import org.junit.Test;

/**
 * @author: shg
 * @create: 2022-05-17 4:34 下午
 */
public class ListGraphTest {

    @Test
    public void testGenerator() {
        ListGraphGenerator<String, Integer> generator = new ListGraphGenerator<>();
        ListGraph<String, Integer> graph = generator.generateListUnDigraph(Data.BFS_01);
        graph.bfs("A");

        ListGraphGenerator<Integer, Integer> generator1 = new ListGraphGenerator<>();
        ListGraph<Integer, Integer> graph1 = generator1.generateListDigraph(Data.BFS_02);
        graph1.bfs(0);
    }

    @Test
    public void test01() {
        Graph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("V1", "V0", 9);
        graph.addEdge("V1", "V2", 3);
        graph.addEdge("V2", "V0", 2);
        graph.addEdge("V2", "V3", 5);
        graph.addEdge("V3", "V4", 1);
        graph.addEdge("V0", "V4", 6);
//        ((ListGraph<String, Integer>) graph).print();
//        graph.removeEdge("V1", "V0");
//        ((ListGraph<String, Integer>) graph).print();
//        graph.removeVertex("V0");
//        ((ListGraph<String, Integer>) graph).print();
        graph.bfs("V1");
        System.out.println();
    }

}