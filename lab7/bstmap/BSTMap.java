package bstmap;

import java.util.HashSet;
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
    private V deletedVal;

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

    private void recursivePrint(Node node) {
        recursivePrint(node.left);
        System.out.println(node.key.toString() + " : " + node.value.toString());
        recursivePrint(node.right);
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        return node;
    }

    private Node recursiveRemove(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            recursiveRemove(node.left, key);
        } else if (cmp > 0) {
            recursiveRemove(node.right, key);
        } else {
            deletedVal = node.value;

            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(node.right);
            node.left = t.left;
        }

        return node;
    }

    private Node recursiveRemoveWithVal(Node node, K key, V val) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);

        if (cmp < 0) {
            recursiveRemove(node.left, key);
        } else if (cmp > 0) {
            recursiveRemove(node.right, key);
        } else {
            if (node.value != val) {
                deletedVal = null;
                return node;
            }

            deletedVal = node.value;

            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(node.right);
            node.left = t.left;
        }

        return node;
    }

    private void keySetRecursive(Node node, Set<K> keys) {
        if (node == null) {
            return;
        }

        keySetRecursive(node.left, keys);
        keys.add(node.key);
        keySetRecursive(node.right, keys);
    }

    public void printInOrder() {
        recursivePrint(root);
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        keySetRecursive(root, keys);
        return keys;
    }

    @Override
    public V remove(K key) {
        root = recursiveRemove(root, key);
        size--;
        return deletedVal;
    }

    @Override
    public V remove(K key, V value) {
        root = recursiveRemoveWithVal(root, key, value);
        return deletedVal;
    }

    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }
}
