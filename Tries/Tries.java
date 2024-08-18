
public class Tries {
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    // insertion of words
    public static void insert(String word) {// O(L) L is length of word
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
                curr.freq = 1;
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Searching of word
    public static boolean search(String word) {// O(L)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    // Word break Problem -> Given a arr of string and key string
    // find out words in key without space are present in an array

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            if (search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }

    // Prefix problem-> Find shortest unique
    // prefix for every word in a given list

    public static void findPefix(Node root, String ans) {// Hard problem
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findPefix(root.children[i], ans + (char) ((char) i - 'a'));
            }
        }
    }

    // startWith Problem -> Given an array
    // if string find the prefix of a word

    public static boolean startWith(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return true;
    }

    // Count Unique Substring -> Given a string count
    // the total number of unique substrings
    // hint - substring = all prefix of all suffix
    // =all suffix of all prefix

    public static int countUnique(String word) {// in Tries, no of nodes=unique prefix
        // find all suffix
        for (int i = 0; i < word.length(); i++) {
            // create trie
            insert(word.substring(i));
        }
        // count nodes
        return countNodes(root);
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    // Longest word with all prefix : Find the longest string in
    // word arr such that every prefix it also present

    public static String longestWord(String[] word) {
        // insert words in tries
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        String ans = "";
        recForLong(root, new StringBuilder(), ans);
        return ans;
    }

    public static void recForLong(Node root, StringBuilder temp, String ans) {
        if (root == null) {
            return;
        }
        // string of max no of eow
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                recForLong(root.children[i], temp, ans);
                temp.deleteCharAt(temp.length() - 1);// backtracking
            }
        }
    }

    public static void main(String[] args) {
        String word[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(longestWord(word));
    }
}
