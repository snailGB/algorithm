import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;

    static List<Edge> edgeList;
    static long[] costArr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.valueOf(st.nextToken());
        int edgeCnt = Integer.valueOf(st.nextToken());

        costArr = new long[nodeCnt + 1];
        Arrays.fill(costArr, Long.MAX_VALUE);

        edgeList = new ArrayList<>();
        for (int edge = 1; edge <= edgeCnt; edge++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());
            int cost = Integer.valueOf(st.nextToken());

            edgeList.add(new Edge(from, to, cost));
        }

        costArr[1] = 0; // 출발 노드의 거리 0으로 초기화

        // 벨만-포드 알고리즘
        for (int compare = 1; compare <= nodeCnt - 1; compare++) {
            for (Edge edge : edgeList) {
                if (costArr[edge.from] != Long.MAX_VALUE) { // 경로가 존재하는 경우에만 갱신
                    long compareCost = edge.cost + costArr[edge.from];
                    if (compareCost < costArr[edge.to]) {
                        costArr[edge.to] = compareCost;
                    }
                }
            }
        }

        // 음수 사이클 탐지
        boolean hasNegativeCycle = false;
        for (Edge edge : edgeList) {
            if (costArr[edge.from] != Long.MAX_VALUE && costArr[edge.from] + edge.cost < costArr[edge.to]) {
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle) {
            answer.append("-1\n");
        } else {
            for (int node = 2; node <= nodeCnt; node++) {
                if (costArr[node] == Long.MAX_VALUE) {
                    answer.append("-1\n"); // 도달할 수 없는 노드는 -1 출력
                } else {
                    answer.append(costArr[node]).append("\n");
                }
            }
        }

        // 한 번에 출력
        System.out.print(answer);
    }
}

class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
