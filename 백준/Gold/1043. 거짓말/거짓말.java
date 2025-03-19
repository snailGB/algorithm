import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int[] parent;

    static void union(int person1, int person2) {
        int root1 = find(person1);
        int root2 = find(person2);

        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    static int find(int person) {
        if (parent[person] != person) {
            parent[person] = find(parent[person]);
        }

        return parent[person];
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int peopleCnt = Integer.parseInt(st.nextToken());
        int partyCnt = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.valueOf(st.nextToken());
        if(knowCnt == 0) {
            System.out.println(partyCnt);
            return;
        }

        parent = new int[peopleCnt + 1];
        for (int person = 1; person <= peopleCnt; person++) {
            parent[person] = person;
        }

        int knowRoot = Integer.valueOf(st.nextToken());
        for (int know = 2; know <= knowCnt; know++) {
            int person = Integer.valueOf(st.nextToken());
            union(knowRoot, person);
        }

        List<int[]> partyInfoList = new ArrayList<>();
        for (int party = 1; party <= partyCnt; party++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.valueOf(st.nextToken());
            int[] partyInfo = new int[partySize];

            partyInfo[0] = Integer.valueOf(st.nextToken());
            for (int info = 1; info < partySize; info++) {
                partyInfo[info] = Integer.valueOf(st.nextToken());
                union(partyInfo[0], partyInfo[info]);
            }

            partyInfoList.add(partyInfo);
        }

        int answer = 0;
        for (int[] partyInfo : partyInfoList) {
            boolean canLie = true;
            for (int person : partyInfo) {
                if (find(person) == find(knowRoot)) {
                    canLie = false;
                    break;
                }
            }

            if (canLie) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
