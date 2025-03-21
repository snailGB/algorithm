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

        costArr[1] = 0;
        for (int compare = 1; compare < nodeCnt; compare++) {
            for (Edge edge : edgeList) {
                if (costArr[edge.from] != Long.MAX_VALUE && costArr[edge.from] + edge.cost < costArr[edge.to]) {
                    costArr[edge.to] = costArr[edge.from] + edge.cost;
                }
            }
        }

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
                    answer.append("-1\n");
                } else {
                    answer.append(costArr[node]).append("\n");
                }
            }
        }

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
