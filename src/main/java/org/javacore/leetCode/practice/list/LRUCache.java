package org.javacore.leetCode.practice.list;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 */
class LRUCache {


    private MyLinkedHashMap cache;

    class MyLinkedHashMap extends LinkedHashMap<Integer, Integer> {

        private int sizeLimit;

        public MyLinkedHashMap(int capacity) {
            super(capacity, 0.75f, true);
            this.sizeLimit = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return sizeLimit < size();
        }
    }

    public LRUCache(int capacity) {
        cache = new MyLinkedHashMap(capacity);
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
