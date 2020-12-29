package org.gxuwz.arithmatic.interview.sourcecode.map;

/**
 * @Author: vovhh
 * @Date: 2020-12-29 17:35:12
 * @Description:
 */
public class HashMap<K, V> implements Map<K, V> {

    private Node<K, V>[] hashTable = null;
    private int size;

    public HashMap() {
        hashTable = new Node[16];
    }

    /**
     * 1.通过key进行hs算法得出hashCode
     * 2.通过hashCode算出数组下标
     * 3.判断该数组下标元素是否为空，不为空直接存储
     * 4.若不为空进行链表存储，返回
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        int hashCode = key.hashCode();
        // 获取hash下标
        int index = getHash(hashCode);
        // 获取该下标的链表
        Node<K, V> linked = hashTable[index];
        if (linked == null) {
            // 直接存储
            hashTable[index] = new Node<>(key, value, hashCode, null);
            size++;
        } else {
            // 头插法，将新元素插入到原来链表的头部
            hashTable[index] = new Node<>(key, value, hashCode, linked);
        }
        return hashTable[index].getValue();
    }

    /**
     * 通过key获取hashCode，进行取模获取数组下标
     * @param hashCode
     * @return
     */
    private int getHash(int hashCode) {
        int index = hashCode % 16;
        return index >= 0 ? index : -index;
    }

    /**
     * 1.获取key的hashCode，并通过hashCode获取数组下标
     * 2.通过下标获取对应的链表
     * 3.循环遍历链表，若key和hashCode相等，返回value，否则返回null
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        if (size() == 0)
            return null;
        int hashCode = key.hashCode();
        // 获取hash下标
        int index = getHash(hashCode);
        // 获取该下标的链表，并查找链表中对应的value
        return getValue(hashTable[index], key, hashCode);
//        Node<K, V> linked = hashTable[index];
//        while(linked != null) {
//            if (key.equals(linked.getKey()) && linked.getHash() == hashCode) {
//                return linked.getValue();
//            }
//            linked = linked.next;
//        }
//        return null;
    }

    private V getValue(Node<K, V> linked, K key, int hashCode) {
        // 若key相等且hashCode相等
        if (key.equals(linked.getKey()) && linked.getHash() == hashCode) {
            return linked.getValue();
        }
        // 若链表的下一个节点不为null，递归遍历
        if (linked.next != null)
            return getValue(linked.next, key, hashCode);
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    class Node<K, V> implements Map.Node<K, V> {

        K key;
        V value;
        int hash;
        Node<K, V> next;

        public Node(K key, V value, int hash, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public int getHash() {
            return hash;
        }
    }
}
