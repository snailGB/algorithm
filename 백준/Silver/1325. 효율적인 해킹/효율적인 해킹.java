import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] countArr;

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : adjList[currentNode]) {
                if (visited[nextNode])
                    continue;

                visited[nextNode] = true;
                queue.add(nextNode);
                countArr[nextNode]++;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCnt = Integer.parseInt(st.nextToken());  
        int edgeCnt = Integer.parseInt(st.nextToken());  

        adjList = new ArrayList[nodeCnt + 1];  
        for (int node = 1; node <= nodeCnt; node++) {
            adjList[node] = new ArrayList<>();
        }

        for (int edge = 0; edge < edgeCnt; edge++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
        }

        countArr = new int[nodeCnt + 1];
        for (int node = 1; node <= nodeCnt; node++) {
            visited = new boolean[nodeCnt + 1];
            bfs(node);
        }

        int max = 0;
        for (int count : countArr) {
            max = Math.max(count, max);
        }

        StringBuilder answer = new StringBuilder();
        for (int node = 1; node <= nodeCnt; node++) {
            if(countArr[node] == max)
                answer.append(node).append(" ");
        }

        System.out.println(answer);
    }
}
