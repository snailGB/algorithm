import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.valueOf(br.readLine());
        PriorityQueue<Integer> positiveQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>();
        boolean hasZero = false;

        int answer = 0;
        for (int input = 1; input <= size; input++) {
            int num = Integer.valueOf(br.readLine());

            if (num == 0) {
                hasZero = true;
            } else if (num == 1) {
                answer += num;
            } else if (num > 0) {
                positiveQ.add(num);
            } else {
                negativeQ.add(num);
            }
        }

        while (positiveQ.size() > 1) {
            int num1 = positiveQ.poll();
            int num2 = positiveQ.poll();
            answer += num1 * num2;
        }

        if (!positiveQ.isEmpty()) {
            answer += positiveQ.poll();
        }

        while (negativeQ.size() > 1) {
            int num1 = negativeQ.poll();
            int num2 = negativeQ.poll();
            answer += num1 * num2;
        }

        if (!negativeQ.isEmpty() && !hasZero) {
            answer += negativeQ.poll();
        }

        System.out.println(answer);
    }
}
