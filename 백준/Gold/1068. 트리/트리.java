import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    static List<Integer>[] adjList;
    static boolean[] visited;
    static int answer;
    static void remove(int currentNode) {
        visited[currentNode] = true;

        for (int childNode : adjList[currentNode]) {
            if (!visited[childNode]) {
                remove(childNode);
            }
        }
    }

    static void count(int currentNode) {
        visited[currentNode] = true;
        boolean isLeaf = true;

        for (int childNode : adjList[currentNode]) {
            if (!visited[childNode]) {
                isLeaf = false;
                count(childNode);
            }
        }

        if (isLeaf) {
            answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        int nodeCnt = Integer.valueOf(br.readLine());

        adjList = new ArrayList[nodeCnt];
        for (int node = 0; node < nodeCnt; node++) {
            adjList[node] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for (int node = 0; node < nodeCnt; node++) {
            int parent = Integer.valueOf(st.nextToken());

            if (parent == -1) {
                root = node;
                continue;
            }

            adjList[parent].add(node);
        }

        int deletNode = Integer.valueOf(br.readLine());

        if(deletNode == root) {
            System.out.println(0);
            return;
        }

        visited = new boolean[nodeCnt];
        remove(deletNode);
        count(root);
        System.out.println(answer);
    }
}
