import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static List<Info>[] adjList;
    static int maxDistance;
    static int farthestNode;

    static void dfs(int currentNode, int dist) {
        if (dist > maxDistance) {
            maxDistance = dist;
            farthestNode = currentNode;
        }

        visited[currentNode] = true;
        for (Info info : adjList[currentNode]) {
            if (!visited[info.node]) {
                dfs(info.node, dist + info.dist);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.valueOf(br.readLine());
        adjList = new ArrayList[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int input = 0; input < nodeCnt - 1; input++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            while (true) {
                int to = Integer.valueOf(st.nextToken());
                
                if (to == -1) 
                    break;
                
                int dist = Integer.valueOf(st.nextToken());
                
                adjList[from].add(new Info(to, dist));
                adjList[to].add(new Info(from, dist));
            }
        }

        visited = new boolean[nodeCnt + 1];
        maxDistance = 0;
        dfs(1, 0);

        visited = new boolean[nodeCnt + 1];
        maxDistance = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDistance);
    }
}

class Info {
    int node;
    int dist;

    public Info(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}
