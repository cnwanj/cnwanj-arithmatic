package org.gxuwz.arithmatic.interview.sourcecode.map;

/**
 * @Author: vovhh
 * @Date: 2020-12-29 17:35:06
 * @Description:
 * map接口
 */
public interface Map<K, V> {
    // 存
    V put(K key, V value);
    // 取
    V get(K key);
    // 长度
    int size();

    interface Node<K, V> {
        K getKey();
        V getValue();
    }
}
