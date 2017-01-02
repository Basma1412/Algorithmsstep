/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;

/**
 *
 * @author Basma Mohamed
 */
public class Graph {
        private final List<Node> vertexes;
        private final List<Edge> edges;

        public Graph(List<Node> vertexes, List<Edge> edges) {
                this.vertexes = vertexes;
                this.edges = edges;
        }

        public List<Node> getVertexes() {
                return vertexes;
        }

        public List<Edge> getEdges() {
                return edges;
        }



}