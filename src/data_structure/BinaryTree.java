package data_structure;

import java.util.ArrayList;

public class BinaryTree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }
        if (isLeaf(root)) {
            return 0;
        }
        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }
        int left = min(root.leftChild);
        int right = min(root.rightChild);
        return Math.min(Math.min(left, right), root.value);
    }

    public int max() {
        return max(root);
    }

    private int max(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }
        int left = max(root.leftChild);
        int right = max(root.rightChild);
        return Math.max(Math.max(left, right), root.value);
    }

    public boolean equals(BinaryTree tree) {
        if (tree == null) {
            return false;
        }
        return equals(root, tree.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) {
            return true;
        }
        if (first != null && second != null) {
            return first.value == second.value && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }
        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.value < min || root.value > max) {
            return false;
        }
        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value = 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        if (distance == 0) {
            list.add(root.value);
            System.out.println(root.value);
        }
        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (int value : getNodesAtDistance(i)) {
                System.out.println(value);
            }
        }
    }
}
