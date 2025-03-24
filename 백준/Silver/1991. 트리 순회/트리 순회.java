import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int nodeCnt = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < nodeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.addNode(node, left, right);
        }

        tree.preorder(tree.root);
        System.out.println();

        tree.inorder(tree.root);
        System.out.println();

        tree.postorder(tree.root);
        System.out.println();
    }
}

class TreeNode {
    char value;
    TreeNode left, right;

    public TreeNode(char value) {
        this.value = value;
    }
}

class Tree {
    Map<Character, TreeNode> treeMap = new HashMap<>();
    TreeNode root;

    void addNode(char value, char left, char right) {
        treeMap.putIfAbsent(value, new TreeNode(value));
        TreeNode current = treeMap.get(value);

        if (root == null) root = current; 

        if (left != '.') {
            treeMap.putIfAbsent(left, new TreeNode(left));
            current.left = treeMap.get(left);
        }

        if (right != '.') {
            treeMap.putIfAbsent(right, new TreeNode(right));
            current.right = treeMap.get(right);
        }
    }

    void preorder(TreeNode node) {
        if (node == null) 
            return;
        
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    void inorder(TreeNode node) {
        if (node == null) 
            return;
        
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    void postorder(TreeNode node) {
        if (node == null) 
            return;
        
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
