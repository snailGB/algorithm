import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> answer;
    static List<Integer>[] adjList;
    static boolean[] visited;

    static void bfs(int startNode, int targetDist) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startNode, 0});
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int[] currentInfo = queue.poll();
            int currentNode = currentInfo[0];
            int currentDist = currentInfo[1];

            if (currentDist == targetDist) {
                answer.add(currentNode);
            }

            for (int nextNode : adjList[currentNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(new int[]{nextNode, currentDist + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        int targetDist = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[nodeCnt + 1];
        for (int node = 1; node <= nodeCnt; node++) {
            adjList[node] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
        }

        for (int node = 1; node <= nodeCnt; node++) {
            Collections.sort(adjList[node]);
        }

        visited = new boolean[nodeCnt + 1];
        answer = new ArrayList<>();
        bfs(startNode, targetDist);
        
        if(answer.size() == 0) {
            System.out.println(-1);
            System.exit(0);
        }
        
        Collections.sort(answer);
        for(int node : answer) {
            System.out.println(node);
        }
    }
}
