import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder answer = new StringBuilder();
    static int[] setArr;
    static void union(int set1, int set2) {
        int root1 = find(set1);
        int root2 = find(set2);

        if (root1 != root2) {
            setArr[root2] = root1; 
        }
    }

    static int find(int set) {
        if (setArr[set] != set) {
            setArr[set] = find(setArr[set]); // 경로 압축
        }
        
        return setArr[set];
    }

    static void check(int set1, int set2) {
        if (find(set1) != find(set2)) {
            answer.append("NO").append("\n");
        } else {
            answer.append("YES").append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.valueOf(st.nextToken()); // 집합의 개수
        int operationCnt = Integer.valueOf(st.nextToken()); // 연산의 개수

        setArr = new int[size + 1];
        for (int set = 1; set <= size; set++) {
            setArr[set] = set; // 초기 부모는 자기 자신
        }

        for (int input = 1; input <= operationCnt; input++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.valueOf(st.nextToken());
            int set1 = Integer.valueOf(st.nextToken());
            int set2 = Integer.valueOf(st.nextToken());

            if (type == 0) {
                union(set1, set2); 
            } else {
                check(set1, set2); 
            }
        }

        System.out.println(answer);
    }
}
