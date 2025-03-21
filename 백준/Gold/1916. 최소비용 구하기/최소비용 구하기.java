import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    static List<int[]>[] adjList;
    static long[] costArr;

    static void dijkstra(int startCity) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{startCity, 0});
        costArr[startCity] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentCity = current[0];
            int currentCost = current[1];

            if (currentCost > costArr[currentCity]) {
                continue;
            }

            for(int[] nextInfo : adjList[currentCity]) {
                int nextCity = nextInfo[0];
                int nextCost = currentCost + nextInfo[1];

                if (nextCost < costArr[nextCity]) {
                    costArr[nextCity] = nextCost;
                    queue.add(new int[]{nextCity, nextCost});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int cityCnt = Integer.valueOf(br.readLine());
        int busCnt = Integer.valueOf(br.readLine());

        adjList = new ArrayList[cityCnt + 1];
        for (int city = 1; city <= cityCnt; city++) {
            adjList[city] = new ArrayList<>();
        }
        costArr = new long[cityCnt + 1];
        Arrays.fill(costArr, Long.MAX_VALUE);

        for (int bus = 1; bus <= busCnt; bus++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());

            adjList[from].add(new int[]{to, cost});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.valueOf(st.nextToken());
        int dest = Integer.valueOf(st.nextToken());
        dijkstra(start);
        System.out.println(costArr[dest]);
    }
}
