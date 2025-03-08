import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int rowSize;
    static int colSize;
    static int[][] maze;
    static boolean[][] visited;
    static int[] deltaRow = {0, 0, -1, 1};
    static int[] deltaCol = {-1, 1, 0, 0};

    static void bfs(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 1});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentMove = current[2];
            if (currentRow == rowSize - 1 && currentCol == colSize - 1) {
                System.out.println(currentMove);
            }

            for (int deltaIdx = 0; deltaIdx < 4; deltaIdx++) {
                int nextRow = currentRow + deltaRow[deltaIdx];
                int nextCol = currentCol + deltaCol[deltaIdx];

                if(nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize
                        || visited[nextRow][nextCol] || maze[nextRow][nextCol] == 0)
                    continue;

                visited[nextRow][nextCol] = true;
                queue.add(new int[]{nextRow, nextCol, currentMove + 1});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.valueOf(st.nextToken());
        colSize = Integer.valueOf(st.nextToken());

        maze = new int[rowSize][colSize];
        for (int row = 0; row < rowSize; row++) {
            String str = br.readLine();
            for (int col = 0; col < colSize; col++) {
                maze[row][col] = str.charAt(col) - '0';
            }
        }

        visited = new boolean[rowSize][colSize];
        bfs(0, 0);
    }
}
