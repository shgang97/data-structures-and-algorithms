package com.shg.graph;

/**
 * @author: shg
 * @create: 2022-05-18 1:01 上午
 */
public class ListGraphGenerator<K, V> {

    /**
     * 根据数据生成有向图或无向图
     * @param data 生成图的原始数据
     * @param directed 生成无向图还是有向图
     * @return
     */
    public ListGraph<K, V> generateListGraph(Object[][] data, boolean directed) {
        ListGraph<K, V> graph = new ListGraph<>();

        for (Object[] row : data) {
            if (row.length == 1) {
                graph.addVertex((K) row[0]);
            } else if (row.length == 2) {
                graph.addEdge((K) row[0], (K) row[1]);
                if (!directed) {
                    graph.addEdge((K) row[1], (K) row[0]);
                }
            } else if (row.length == 3) {
                graph.addEdge((K) row[0], (K) row[1], (V) row[2]);
                if (!directed) {
                    graph.addEdge((K) row[1], (K) row[0], (V) row[2]);
                }
            }
        }
        return graph;
    }

    /**
     * 生成有向图
     * @param data
     * @return
     */
    public ListGraph<K, V> generateListDigraph(Object[][] data) {
        return generateListGraph(data, true);
    }

    /**
     * 生成无向图
     * @param data
     * @return
     */
    public ListGraph<K, V> generateListUnDigraph(Object[][] data) {
        return generateListGraph(data, false);
    }

}
