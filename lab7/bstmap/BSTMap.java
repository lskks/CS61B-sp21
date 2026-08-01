package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class Node{
        K key;
        V value;
        Node left;
        Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    private Node recursiveSearch(K key, Node node) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            return recursiveSearch(key, node.left);
        } else if (key.compareTo(node.key) == 0) {
            return node;
        } else {
            return recursiveSearch(key, node.right);
        }
    }

    public BSTMap() {
        clear();
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        return recursiveSearch(key, root) != null;
    }

    @Override
    public V get(K key) {
        if (!containsKey(key))
            return null;
        return recursiveSearch(key, root).value;
    }

    @Override
    public int size() {
        return size;
    }

    private Node recursiveInsert(K key, V value, Node node) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = recursiveInsert(key, value, node.left);
        } else if (key.compareTo(node.key) > 0) {
            node.right = recursiveInsert(key, value, node.right);
        }

        return node;
    }

    @Override
    public void put(K key, V value) {
        if (root == null) {
            root = recursiveInsert(key, value, null);
        } else {
            recursiveInsert(key, value, root);
        }
        size++;
    }

    public void printInOrder(Node node) {
        printInOrder(node.left);
        System.out.println(node.key.toString() + " : " + node.value.toString());
        printInOrder(node.right);
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
