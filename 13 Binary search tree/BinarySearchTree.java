import java.util.*;

public class BinarySearchTree {
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

    public static void inorder(Node root) {// Left Subtree -> Root -> Right Subtree
        if (root == null) {// O(n)
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Bulding BST

    public static Node insert(int val, Node root) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // insert in left subtree
            root.left = insert(val, root.left);
        } else {
            // insert in right subtree
            root.right = insert(val, root.right);
        }
        return root;
    }

    // Searching in BST

    public static boolean search(Node root, int key) {// O(H), where H is height of BST
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    // deleting Node in BST

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {// root.data==val
                // case 1 - leaf node (single node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 - single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3 - both childern
            Node IS = findInorderSuccesser(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);// IS in rigth sub tree of left down most node
        }
        return root;
    }

    public static Node findInorderSuccesser(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Print BST in Range

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }

    }

    // Print all possible path from root to leaf

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            System.out.println(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size() - 1);
    }

    // Check valid Binary Search Tree

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    // Mirror up the BST
    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }
        Node leftSubtree = mirror(root.left);
        Node rightSubtree = mirror(root.right);
        root.left = rightSubtree;
        root.right = leftSubtree;
        return root;
    }

    // Build sorted array to BST

    public static Node createBST(int[] arr, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid - 1);
        root.right = createBST(arr, mid + 1, ed);
        return root;
    }

    // convert normal BST to balanced BST

    public static Node balanceBST(Node root) {// O(n)
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        // sorted inorder ->balance BST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static Node createBST(ArrayList<Integer> list, int st, int ed) {
        if (st > ed) {
            return null;
        }
        int mid = (st + ed) / 2;
        Node root = new Node(list.get(mid));
        root.left = createBST(list, st, mid - 1);
        root.right = createBST(list, mid + 1, ed);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    // Merge 2 BST
    public static Node mergeBST(Node root1, Node root2) {
        //inorder for root 1
        ArrayList<Integer> inorder1 = new ArrayList<>();
        getInorder(root1, inorder1);
        //inorder for root 2
        ArrayList<Integer> inorder2 = new ArrayList<>();
        getInorder(root2, inorder2);
        //merger
        int i=0,j=0;
        ArrayList<Integer> final = new ArrayList<>();
        while(i<inorder1.size() && j<inorder2.size()){
            if(inorder1.get(i)<=inorder2.get(j)){
                final.add(inorder1.get(i));
                i++;
            }else {
                final.add(inorder2.get(j));
                j++;
            }
        }
        while (i<inorder1.size()) {
            final.add(inorder1.get(i));
            i++;
        }
        while (j<inorder2.size()) {
            final.add(inorder2.get(j));
            j++;
        }
        //sorted AL to balance BST
        Node root = createBST(final, 0, final.size() - 1);
        return root;
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);

    }
}