import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int city) {
        if (parent[city] != city) {
            parent[city] = find(parent[city]);
        }

        return parent[city];
    }

    static void union(int city1, int city2) {
        int root1 = find(city1);
        int root2 = find(city2);

        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCnt = Integer.parseInt(br.readLine());
        int travelCnt = Integer.parseInt(br.readLine());

        parent = new int[cityCnt + 1];
        for (int city = 1; city <= cityCnt; city++) {
            parent[city] = city;
        }

        for (int fromCity = 1; fromCity <= cityCnt; fromCity++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int toCity = 1; toCity <= cityCnt; toCity++) {
                int connection = Integer.parseInt(st.nextToken());
                if (connection == 1) {
                    union(fromCity, toCity);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstCity = Integer.parseInt(st.nextToken());
        boolean isPossible = true;
        int root = find(firstCity);
        for (int travel = 1; travel < travelCnt; travel++) {
            int city = Integer.parseInt(st.nextToken());
            if (find(city) != root) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
