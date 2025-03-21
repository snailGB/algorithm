import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    static List<int[]>[] adjList;
    static int[] costArr;
    static void dijkstra(int startNode) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{startNode, 0});
        costArr[startNode] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (costArr[currentNode] < currentCost) {
                continue;
            }

            for (int[] nextInfo : adjList[currentNode]) {
                int nextNode = nextInfo[0];
                int nextCost = currentCost + nextInfo[1];
                if (nextCost < costArr[nextNode]) {
                    costArr[nextNode] = nextCost;
                    queue.add(new int[]{nextNode, nextCost});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.valueOf(st.nextToken());
        int edgeCnt = Integer.valueOf(st.nextToken());
        int startNode = Integer.valueOf(br.readLine());

        adjList = new ArrayList[nodeCnt + 1];
        for (int node = 1; node <= nodeCnt; node++) {
            adjList[node] = new ArrayList<>();
        }
        costArr = new int[nodeCnt + 1];
        Arrays.fill(costArr, Integer.MAX_VALUE);

        for (int edge = 1; edge <= edgeCnt; edge++) {
            st = new StringTokenizer(br.readLine());
            int fromNode = Integer.valueOf(st.nextToken());
            int toNode = Integer.valueOf(st.nextToken());
            int weight = Integer.valueOf(st.nextToken());

            adjList[fromNode].add(new int[]{toNode, weight});
        }

        dijkstra(startNode);

        for (int node = 1; node <= nodeCnt; node++) {
            int cost = costArr[node];
            if (cost == Integer.MAX_VALUE) {
                answer.append("INF").append("\n");
                continue;
            }

            answer.append(cost).append("\n");
        }

        System.out.println(answer);
    }
}
