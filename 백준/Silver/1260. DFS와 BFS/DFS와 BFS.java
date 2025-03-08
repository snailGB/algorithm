import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder answer = new StringBuilder();

    static void dfs(int currentNode) {
        answer.append(currentNode).append(" ");

        visited[currentNode] = true;
        for(int nextNode : adjList[currentNode]) {
            if(visited[nextNode])
                continue;

            dfs(nextNode);
        }
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            answer.append(currentNode).append(" ");

            for (int nextNode : adjList[currentNode]) {
                if(visited[nextNode])
                    continue;

                visited[nextNode] = true;
                queue.add(nextNode);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.valueOf(st.nextToken());
        int edgeCnt = Integer.valueOf(st.nextToken());
        int startNode = Integer.valueOf(st.nextToken());

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

        for (int node = 1; node <= nodeCnt; node++) {
            Collections.sort(adjList[node]);
        }

        visited = new boolean[nodeCnt + 1];
        dfs(startNode);

        answer.append("\n");

        visited = new boolean[nodeCnt + 1];
        bfs(startNode);

        System.out.println(answer);
    }
}
