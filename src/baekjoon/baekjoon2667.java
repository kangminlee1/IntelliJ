package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon2667 {

    static int row_col;
    static int[][] map;
    static boolean[][] check;
    static int count = 0;
    static ArrayList<Integer> list = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        row_col = Integer.parseInt(br.readLine());

        map = new int[row_col][row_col];
        check = new boolean[row_col][row_col];

        for(int i = 0; i < row_col; i++){
            String str = br.readLine();
            for(int j = 0; j < row_col; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < row_col; i++){
            for(int j = 0; j < row_col; j++){
                if(map[i][j] == 1 && !check[i][j]){
                    //집이 있는 곳이고, 방문하지 않았다면
//                    bfs(i, j);
                    dfs(i,j);
                    list.add(count);
                    count = 0;
                }

            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i : list){
            System.out.println(i);
        }

    }
    public static void bfs(int r, int c){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(r, c));
        check[r][c] = true;

        while(!que.isEmpty()){
            Point temp = que.poll();
            count++;

            for(int i = 0; i < 4; i++){
                int next_row = temp.x + dx[i];
                int next_col = temp.y + dy[i];

                if(next_row < 0 || next_col < 0 || next_row >= row_col || next_col >= row_col ){
                    continue;
                }
                if(check[next_row][next_col] || map[next_row][next_col] == 0){
                    continue;
                }

                check[next_row][next_col] = true;
                que.add(new Point(next_row, next_col));


            }

        }


    }

    public static void dfs (int r, int c){
        check[r][c] = true;

        count++;
        for(int i = 0; i < 4; i++){
            int next_row = r + dx[i];
            int next_col = c + dy[i];

            if(next_row < 0 || next_col < 0 || next_row >= row_col || next_col >= row_col ){
                continue;
            }
            if(check[next_row][next_col] || map[next_row][next_col] == 0){
                continue;
            }

            dfs(next_row, next_col);

        }


    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
