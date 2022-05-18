package com.shg.graph;

/**
 * @author: shg
 * @create: 2022-05-17 4:11 下午
 */
public interface Graph<K, E> {

    /**
     *
     * @return 边的个数
     */
    int edgesSize();

    /**
     *
     * @return 定点个数
     */
    int verticesSize();

    /**
     * 添加一个顶点
     * @param k
     */
    void addVertex(K k);

    /**
     * 添加一条无权值的边
     * @param from
     * @param to
     */
    void addEdge(K from, K to);

    /**
     * 添加一条带权值的边
     * @param from
     * @param to
     * @param weight
     */
    void addEdge(K from, K to, E weight);

    /**
     * 删除一个顶点
     * @param k
     */
    void removeVertex(K k);

    /**
     * 删除一条边
     * @param from
     * @param to
     */
    void removeEdge(K from, K to);

    void bfs(K begin);
}
