package org.jgrapht.alg.cycle;

import java.util.*;

 /**
     * Implementation of a labeled path. It is used in
     * AhujaOrlinSharmaCyclicExchangeLocalAugmentation to efficiently maintain the paths in the
     * calculation.
     *
     * @param <V> the vertex type
     *
     * @author Christoph Grüne
     * @since June 7, 2018
     */

public class LabeledPath<V> implements Cloneable {

        /**
         * the vertices in the path
         */
        public ArrayList<V> vertices;
        /**
         * the labels the path contains
         */
        public HashSet<Integer> labels;
        /**
         * the cost of the path
         */
        public double cost;

        /**
         * Constructs a LabeledPath with the given inputs
         *
         * @param vertices the vertices of the path in order of the path
         * @param cost the cost of the edges connecting the vertices
         * @param labels the mapping of the vertices to labels (subsets)
         */
        public LabeledPath(ArrayList<V> vertices, double cost, HashSet<Integer> labels)
        {
            this.vertices = vertices;
            this.cost = cost;
            this.labels = labels;
        }

        /**
         * Adds a vertex to the path
         *
         * @param v the vertex
         * @param edgeCost the cost of the edge connecting the last vertex of the path and the new
         *        vertex
         * @param label the label of the new vertex
         */
        public void addVertex(V v, double edgeCost, int label)
        {
            this.vertices.add(v);
            this.cost += edgeCost;
            this.labels.add(label);
        }

        /**
         * Returns the start vertex of the path
         *
         * @return the start vertex of the path
         */
        public V getHead()
        {
            return vertices.get(0);
        }

        /**
         * Returns the end vertex of the path
         *
         * @return the end vertex of the path
         */
        public V getTail()
        {
            return vertices.get(vertices.size() - 1);
        }

        /**
         * Returns whether the path is empty, i.e. has no vertices
         *
         * @return whether the path is empty
         */
        public boolean isEmpty()
        {
            return vertices.isEmpty();
        }

        /**
         * Returns a shallow copy of this labeled path instance. Vertices are not cloned.
         *
         * @return a shallow copy of this path.
         *
         * @throws RuntimeException in case the clone is not supported
         *
         * @see java.lang.Object#clone()
         */
        @Override
        @SuppressWarnings("unchecked")
        public LabeledPath<V> clone()
        {
            try {
                LabeledPath<V> newLabeledPath = (LabeledPath<V>) super.clone();
                newLabeledPath.vertices = (ArrayList<V>) this.vertices.clone();
                newLabeledPath.labels = (HashSet<Integer>) this.labels.clone();
                newLabeledPath.cost = this.cost;

                return newLabeledPath;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
}
