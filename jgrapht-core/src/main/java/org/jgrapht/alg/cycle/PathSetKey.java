package org.jgrapht.alg.cycle;

import java.util.*;

 /**
     * Implementation of a key for the path maps. It is used in
     * AhujaOrlinSharmaCyclicExchangeLocalAugmentation to efficiently maintain the path sets in the
     * calculation.
     *
     * @param <V> the vertex type
     *
     * @author Christoph Grüne
     * @since June 7, 2018
     */
    public class PathSetKey<V>
    {
        /**
         * the head of the paths indexed by this key
         */
        private V head;
        /**
         * the tail of the paths indexed by this key
         */
        private V tail;
        /**
         * the label set of the paths indexed by this key
         */
        private Set<Integer> labels;

        /**
         * Constructs a new PathSetKey object
         *
         * @param head the head of the paths indexed by this key
         * @param tail the tail of the paths indexed by this key
         * @param labels the label set of the paths indexed by this key
         */
        public PathSetKey(V head, V tail, Set<Integer> labels)
        {
            this.head = head;
            this.tail = tail;
            this.labels = labels;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(head, tail, labels);
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
                return true;
            else if (!(o instanceof PathSetKey))
                return false;

            @SuppressWarnings("unchecked") PathSetKey<V> other = (PathSetKey<V>) o;
            return Objects.equals(head, other.head) && Objects.equals(tail, other.tail)
                && Objects.equals(labels, other.labels);
        }
    }
