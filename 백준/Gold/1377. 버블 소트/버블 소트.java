import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.valueOf(br.readLine());
        
        Data[] dataArr = new Data[numCnt];
        for (int idx = 0; idx < numCnt; idx++) {
            dataArr[idx] = new Data(Integer.valueOf(br.readLine()), idx);
        }
        Arrays.sort(dataArr);

        int maxMove = 0;
        for (int idx = 0; idx < numCnt; idx++) {
            maxMove = Math.max(maxMove, dataArr[idx].idx - idx);
        }

        System.out.println(maxMove + 1);
    }
}

class Data implements Comparable<Data>{
    int value;
    int idx;

    public Data(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }


    @Override
    public int compareTo(Data data) {
        return this.value - data.value;
    }
}