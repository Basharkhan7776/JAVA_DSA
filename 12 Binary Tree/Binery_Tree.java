import java.util.*;
import java.util.LinkedList;

public class Binery_Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;
            if (idx >= nodes.length || nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Printing Binery Tree
        public static void preorder(Node root) {// Root -> Left Subtree -> Right Subtree
            if (root == null) {// O(n)
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root) {// Left Subtree -> Root -> Right Subtree
            if (root == null) {// O(n)
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

    }

    // Subtree of another tree -----> return true if their is subtree of root
    // with same structure and node values of subtree and false otherwise
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot))
                ;
            {
                return true;
            }
        }

        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }
        if (!isIdentical(root.left, subRoot.left) || !isIdentical(root.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    // Level order triversal
    public static void levelOrder(Node root) {// Triversal for ele in Level wise
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();// FIFO
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // Maximum Height
    public static int heigth(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = heigth(root.left);
        int rh = heigth(root.right);
        return Math.max(lh, rh) + 1;
    }

    // Counting Number of nodes
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int lc = count(root.left);
        int rc = count(root.right);
        return (lc + rc) + 1;
    }

    // Sum of all Nodes
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int ld = sum(root.left);
        int rd = sum(root.right);
        return (ld + rd) + root.data;
    }

    // No. nodes in the longest path b/w two nodes ------> Diameter of Tree
    public static int diameterA(Node root) {// tc -> O(n^2)
        if (root == null) {
            return 0;
        }
        int ld = diameterA(root.left);
        int rd = diameterA(root.right);
        int lh = heigth(root.left);
        int rh = heigth(root.right);
        int selfdia = lh + rh + 1;
        return Math.max(selfdia, Math.max(ld, rd));
    }

    // Second Approch of Diameter of tree
    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameterB(Node root) {// tc -> O(n)
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = diameterB(root.left);
        Info rightInfo = diameterB(root.right);
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(diam, ht);
    }

    // Print Top View of a tree
    public static void topview(Node root) {
        if (root == null) {
            return;
        }
        Queue<Info2> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new Info2(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info2 curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Info2(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info2(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    static class Info2 {
        Node node;
        int hd;

        public Info2(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Print Level wise Node data in BT

    public static void printKthLevel(Node root, int k, int level) {
        if (root == null) {
            return;
        }
        if (k == level) {
            System.out.print(root.data + " ");
            return;
        }
        printKthLevel(root.left, k, level + 1);
        printKthLevel(root.right, k, level + 1);
    }

    // Finding Lowest Common Ancestor

    public static Node lca(Node root, int n1, int n2) {// O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last common Ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i).data != path2.get(i).data) {
                break;
            }
        }

        // Last equal node ->i-1th
        Node lca = path1.get(i - 1);
        return lca;
    }

    public static boolean getPath(Node root, int n, ArrayList path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }
        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);

        if (foundleft || foundright) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    // Minimum distance between two nodes
    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    // Find kth Ancestor in given binary tree

    public static int KthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = KthAncestor(root.left, n, k);
        int rightDist = KthAncestor(root.right, n, k);
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;// return distance
    }

    // transfer of sum

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        int data = root.data;
        int newLeft = (root.left == null) ? 0 : root.left.data;
        int newRight = (root.right == null) ? 0 : root.right.data;
        root.data = leftChild + newLeft + rightChild + newRight;
        return data;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int n = transform(root);
        BinaryTree.preorder(root);
    }
}
