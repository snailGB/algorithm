import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;

    static void dfs(int currentNode) {
        if(visited[currentNode])
            return;

        visited[currentNode] = true;

        for(int node : adjList[currentNode]) {
            if (visited[node])
                continue;

            dfs(node);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.valueOf(st.nextToken());
        int edgeCnt = Integer.valueOf(st.nextToken());

        adjList = new ArrayList[nodeCnt + 1];
        for (int node = 1; node <= nodeCnt; node++) {
            adjList[node] = new ArrayList<>();
        }

        for (int input = 1; input <= edgeCnt; input++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        visited = new boolean[nodeCnt + 1];
        int answer = 0;
        for (int node = 1; node <= nodeCnt; node++) {
            if(visited[node])
                continue;

            dfs(node);
            answer++;
        }

        System.out.println(answer);
    }
}
