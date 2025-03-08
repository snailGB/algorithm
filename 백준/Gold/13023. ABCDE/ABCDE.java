import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;

    static void dfs(int currentNode, int depth) {
        if(visited[currentNode])
            return;

        if(depth == 5) {
            System.out.println(1);
            System.exit(0);
        }

        visited[currentNode] = true;
        for(int nextNode : adjList[currentNode]) {
            if(visited[nextNode])
                continue;

            dfs(nextNode, depth + 1);
        }
        visited[currentNode] = false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.valueOf(st.nextToken());
        int edgeCnt = Integer.valueOf(st.nextToken());

        adjList = new ArrayList[nodeCnt];
        for (int node = 0; node < nodeCnt; node++) {
            adjList[node] = new ArrayList<>();
        }

        for (int input = 1; input <= edgeCnt; input++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        visited = new boolean[nodeCnt];
        for (int node = 0; node < nodeCnt; node++) {
            if(visited[node])
                continue;

            dfs(node, 1);
        }

        System.out.println(0);
    }
}
