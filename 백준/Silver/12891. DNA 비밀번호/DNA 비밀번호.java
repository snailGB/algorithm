import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    
    static boolean checkStd(int[] stdArr, int aCnt, int cCnt, int gCnt, int tCnt) {
        if(aCnt >= stdArr[0] && cCnt >= stdArr[1] && gCnt >= stdArr[2] && tCnt >= stdArr[3])
            return true;
        
        return false;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int strLength = Integer.parseInt(st.nextToken());
        int pwdLength = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        int[] stdArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < 4; idx++) {
            stdArr[idx] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int aCnt = 0;
        int cCnt = 0; 
        int gCnt = 0; 
        int tCnt = 0;
        for(int chIdx = 0; chIdx < pwdLength; chIdx++) {
            char ch = dna.charAt(chIdx);
            if(ch == 'A')
                aCnt++;
            else if(ch == 'C')
                cCnt++;
            else if(ch == 'G')
                gCnt++;
            else
                tCnt++;
        }
        
        if(checkStd(stdArr, aCnt, cCnt, gCnt, tCnt))
            answer++;
        
        for(int chIdx = pwdLength; chIdx < strLength; chIdx++) {
            char enter = dna.charAt(chIdx);
            char out = dna.charAt(chIdx - pwdLength);
            if(enter == 'A')
                aCnt++;
            else if(enter == 'C')
                cCnt++;
            else if(enter == 'G')
                gCnt++;
            else
                tCnt++;

            if(out == 'A')
                aCnt--;
            else if(out == 'C')
                cCnt--;
            else if(out == 'G')
                gCnt--;
            else
                tCnt--;
            
            if(checkStd(stdArr, aCnt, cCnt, gCnt, tCnt))
                answer++;
        }

        System.out.println(answer);
    }
}