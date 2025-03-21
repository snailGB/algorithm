import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    static List<int[]>[] adjList;
    static Queue<Integer>[] costArr;

    static void dijkstra(int startNode, int targetOrder) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{startNode, 0});
        costArr[startNode].add(0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if(costArr[currentNode].size() == targetOrder && currentCost > costArr[currentNode].peek()) {
                continue;
            }

            for (int[] nextInfo : adjList[currentNode]) {
                int nextNode = nextInfo[0];
                int nextCost = currentCost + nextInfo[1];

                if(costArr[nextNode].size() < targetOrder) {
                    costArr[nextNode].add(nextCost);
                    queue.add(new int[]{nextNode, nextCost});
                    continue;
                }

                if(costArr[nextNode].size() == targetOrder && nextCost < costArr[nextNode].peek()) {
                    costArr[nextNode].poll();
                    costArr[nextNode].offer(nextCost);
                    queue.add(new int[]{nextNode, nextCost});
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.valueOf(st.nextToken());
        int edgeCnt = Integer.valueOf(st.nextToken());
        int targetOrder = Integer.valueOf(st.nextToken());

        adjList = new ArrayList[nodeCnt + 1];
        for (int node = 1; node <= nodeCnt; node++) {
            adjList[node] = new ArrayList<>();
        }
        costArr = new PriorityQueue[nodeCnt + 1];
        for (int node = 1; node <= nodeCnt; node++) {
            costArr[node] = new PriorityQueue<>((o1, o2) -> o2 - o1);
        }

        for (int edge = 1; edge <= edgeCnt; edge++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());

            adjList[from].add(new int[]{to, cost});
        }

        dijkstra(1, targetOrder);

        for (int node = 1; node <= nodeCnt; node++) {
            if (costArr[node].size() < targetOrder) {
                answer.append(-1).append("\n");
                continue;
            }

            answer.append(costArr[node].peek()).append("\n");
        }

        System.out.println(answer);
    }
}
