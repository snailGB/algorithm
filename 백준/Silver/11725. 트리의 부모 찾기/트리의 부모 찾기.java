import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    static List<Integer>[] adjList;
    static int[] parent;
    static boolean[] visited;

    static void dfs(int currentNode) {
        visited[currentNode] = true;

        for(int nextNode : adjList[currentNode]) {
            if(visited[nextNode])
                continue;

            parent[nextNode] = currentNode;
            dfs(nextNode);
        }
    }

    public static void main(String[] args) throws IOException {
        int nodeCnt = Integer.valueOf(br.readLine());

        adjList = new List[nodeCnt + 1];
        for (int node = 1; node <= nodeCnt; node++) {
            adjList[node] = new ArrayList<>();
        }

        for (int input = 1; input < nodeCnt; input++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.valueOf(st.nextToken());
            int node2 = Integer.valueOf(st.nextToken());

            adjList[node1].add(node2);
            adjList[node2].add(node1);
        }

        parent = new int[nodeCnt + 1];
        visited = new boolean[nodeCnt + 1];
        dfs(1);

        for (int node = 2; node <= nodeCnt; node++) {
            answer.append(parent[node]).append("\n");
        }

        System.out.println(answer);
    }
}
