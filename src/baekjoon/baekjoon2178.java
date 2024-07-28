package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon2178 {

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int row, col;
    static int[][] map;
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new int[row][col];
        check = new boolean[row][col];

        for(int i = 0; i < row; i++){
            String str = br.readLine();
            for(int j = 0; j < col; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        miro(0, 0);

        System.out.println(map[row-1][col-1]);

    }

    public static void miro(int r, int c){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c));
        check[r][c] = true;

        while (!que.isEmpty()){
            Point temp = que.poll();

            for(int i = 0; i < 4; i++){
                int next_row = temp.x + dx[i];
                int next_col = temp.y + dy[i];

                if(next_row < 0 || next_col < 0 || next_row >= row || next_col >= col){
                    //지도의 범위를 벗어날 경우
                    continue;
                }
                if(check[next_row][next_col] || map[next_row][next_col] == 0){
                    //방문했거나
                    //지도에서 못지나가는 곳(0인) 일경우
                    continue;
                }

                //지도의 범위를 벗어나지 않고 방문하지 않았고 지나갈 수 있는 경우

                que.add(new Point(next_row, next_col));
                check[next_row][next_col] = true;
                //방문 실시

                map[next_row][next_col] = map [temp.x][temp.y] + 1;
                //방문할 때 기존 루트에 +1을 하여 새로운 루트까지의 경로 길이 표현
            }

        }
    }

}
