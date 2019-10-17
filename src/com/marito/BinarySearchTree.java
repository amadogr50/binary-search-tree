package com.marito;

public class BinarySearchTree<T extends Comparable<? super T>> {

    private Node root = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    private void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.key);
            print(node.right);
        }
    }

    public void print() {
        print(this.root);
        System.out.println("-------");
    }

    public boolean add(T toAdd) {
        return false;
    }

    private Node search(T toSearch, Node current) {
        if (current == null) return current;

        int comparation = current.key.compareTo(toSearch);
        if (comparation == 0) {
            return current;
        } else if (comparation > 0) {
            return search(toSearch, current.left);
        } else {
            return search(toSearch, current.right);
        }
    }

    public boolean contains(T key) {
        Node n = search(key, this.root);
        return n != null;
    }

    private Node maximum(Node node) {
        if (node == null) return null;
        if (node.right != null) return maximum(node.left);
        return node;
    }

    public T maximum() {
        Node n = maximum(this.root);
        if (n == null) return null;
        return n.key;
    }

    private Node minimum(Node node) {
        if (node == null) return null;
        if (node.left != null) return minimum(node.left);
        return node;
    }

    public T minimum() {
        Node n = minimum(this.root);
        if (n == null) return null;
        return n.key;
    }

    private Node predecessor(Node node) {
        if (node.left != null) {
            Node current = node.left;
            return maximum(current);
        } else {
            Node child = node;
            Node parent = node.parent;
            while (parent != null && parent.left == child) {
                child = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public T predecessor(T key) {
        Node n = search(key, root);
        if (n == null) return null;
        Node p = predecessor(n);
        if (p == null) return null;
        return p.key;
    }

    private Node successor(Node node) {
        if (node.right != null) {
            Node current = node.left;
            return minimum(current);
        } else {
            Node child = node;
            Node parent = node.parent;
            while (parent != null && parent.right == child) {
                child = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    public T successor(T key) {
        Node n = search(key, root);
        if (n == null) return null;
        Node p = predecessor(n);
        if (p == null) return null;
        return p.key;
    }

    private int countGreaterThan(Node node, T key) {
        if (node == null) return 0;

        int comparation = node.key.compareTo(key);
        if (comparation == 0) {
            return countGreaterThan(node.right, key);
        } else if (comparation > 0) {
            return 1 + countGreaterThan(node.left, key) + countGreaterThan(node.right, key);
        } else {
            return countGreaterThan(node.right, key);
        }
    }

    public int countGreaterThan(T key) {
        return countGreaterThan(this.root, key);
    }

    private void remove(Node node) {
    }

    public boolean remove(T key) {
        return false;
    }

    private class Node {
        public T key;
        public Node left = null, right = null, parent = null;

        public Node(T key) {
            this.key = key;
        }

        public String toString() {
            return this.key.toString();
        }
    }

}