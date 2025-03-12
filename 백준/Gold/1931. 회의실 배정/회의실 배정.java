import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int meetingCnt = Integer.valueOf(br.readLine());

        int[][] timeArr = new int[meetingCnt][2];
        for (int input = 0; input < meetingCnt; input++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.valueOf(st.nextToken());
            int to = Integer.valueOf(st.nextToken());
            
            timeArr[input][0] = from;
            timeArr[input][1] = to;
        }
        Arrays.sort(timeArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                
                return o1[1] - o2[1];
            }
        });
        
        int answer = 0;
        int endTime = -1;
        for (int row = 0; row < meetingCnt; row++) {
            if(timeArr[row][0] >= endTime) {
                answer++;
                endTime = timeArr[row][1];
            }
        }

        System.out.println(answer);
    }
}
