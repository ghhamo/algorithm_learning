package org.example;

public class BST<Key extends Comparable<Key>, Value extends Comparable<Value>> {

    private NodeBST root;

    public Value get(Key key) {
        if (root == null) throw new RuntimeException();
        NodeBST nodeBST = root;
        while (nodeBST != null) {
            int cmp = key.compareTo(nodeBST.key);
            if (cmp < 0) {
                nodeBST = nodeBST.left;
            } else if (cmp > 0) {
                nodeBST = nodeBST.right;
            } else {
                return nodeBST.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private NodeBST put(NodeBST node, Key key, Value value) {
        if (node == null) {
            NodeBST newNode = new NodeBST(key, value);
            newNode.size = 1;
            return newNode;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.size = 1 + getSize(node.left) + getSize(node.right);
        return node;
    }

    public void delete(Key key) {
        delete(root, key);
    }

    private NodeBST delete(NodeBST node, Key key) {
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                NodeBST minNode = getMin(node.right);
                node.key = minNode.key;
                node.value = minNode.value;
                node.right = delete(node.right, minNode.key);
            }
        }
        return node;
    }

    private NodeBST getMin(NodeBST node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private int getSize(NodeBST node) {
        return node == null ? 0 : node.size;
    }

    public Value kthSmallest(int smallest) {
        NodeBST nodeBST = kthSmallest(root, smallest);
        return nodeBST.value;
    }

    private NodeBST kthSmallest(NodeBST node, int k) {
        int leftSize = getSize(node.left);
        if (leftSize + 1 == k) return node;
        if (k <= leftSize) return kthSmallest(node.left, k);
        return kthSmallest(node.right, k - leftSize - 1);
    }

    public int findRank(Key key) {
        return findRank(root, key);
    }

    private int findRank(NodeBST node, Key key) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return findRank(node.left, key);
        } else if (cmp > 0) {
            return 1 + getSize(node.left) + findRank(node.right, key);
        } else {
            return getSize(node.left) + 1;
        }
    }

    private class NodeBST {
        private Key key;
        private Value value;
        private NodeBST left, right;
        private int size;

        public NodeBST(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }
}