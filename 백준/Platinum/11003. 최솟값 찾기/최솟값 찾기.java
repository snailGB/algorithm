import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<int[]> queue = new ArrayDeque<>();

        StringBuilder answer = new StringBuilder();
        for (int idx = 0; idx < numCnt; idx++) {
            int current = Integer.parseInt(st.nextToken());

            while (!queue.isEmpty() && queue.getLast()[1] > current) {
                queue.removeLast();
            }
            queue.addLast(new int[]{idx, current});

            if (queue.getFirst()[0] <= idx - windowSize) {
                queue.removeFirst();
            }

            answer.append(queue.getFirst()[1]).append(" ");
        }

        System.out.println(answer);
    }
}