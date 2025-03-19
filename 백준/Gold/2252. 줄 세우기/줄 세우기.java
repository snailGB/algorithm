import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder answer = new StringBuilder();
    static StringTokenizer st;
    static List<Integer>[] adjList;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.valueOf(st.nextToken());
        int compareCnt = Integer.valueOf(st.nextToken());

        adjList = new ArrayList[studentCnt + 1];
        for (int student = 1; student <= studentCnt; student++) {
            adjList[student] = new ArrayList<>();
        }
        indegree = new int[studentCnt + 1];

        for (int compare = 1; compare <= compareCnt; compare++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.valueOf(st.nextToken());
            int back = Integer.valueOf(st.nextToken());

            adjList[front].add(back);
            indegree[back]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int student = 1; student <= studentCnt; student++) {
            if (indegree[student] == 0) {
                queue.offer(student);
            }
        }

        while(!queue.isEmpty()) {
            int current = queue.poll();
            answer.append(current).append(" ");

            for(int next : adjList[current]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(answer);
    }
}
