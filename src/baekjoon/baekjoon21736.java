package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon21736 {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //좌표를 위한 클래스

    static int row, col, count = 0;
    static boolean[][] check;
    static char[][] campus;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        campus = new char[row][col];
        check = new boolean[row][col];

        int start_row = 0;
        int start_col = 0;

        for (int i = 0; i < row; i++) {
            String str = br.readLine();
            for (int j = 0; j < col; j++) {
                campus[i][j] = str.charAt(j);

                if (campus[i][j] == 'I') {
                    start_row = i;
                    start_col = j;
                }//I에서 부터 주변을 찾을 것
            }
        }

//        find_friend(start_row, start_col);

        dfs(start_row, start_col);

        if(count == 0){//주변에 친구가 없으면
            System.out.println("TT");
        }else{//친구가 1명이라도 발견 되면
            System.out.println(count);
        }

    }

    public static void find_friend(int r, int c) {
        Queue<Point> que = new LinkedList<>();

        que.add(new Point(r, c));
        check[r][c] = true;

        while (!que.isEmpty()) {
            Point temp = que.poll();

            for (int i = 0; i < 4; i++) {
                int next_row = temp.x + dx[i];
                int next_col = temp.y + dy[i];

                if (next_row < 0 || next_col < 0 || row <= next_row || col <= next_col) {
                    //상하좌우로 움직일 때 배열 범위를 벗어날 경우
                    continue;
                }
                if (check[next_row][next_col] || campus[next_row][next_col] == 'X') {
                    //지나갈 수 없는 X나 이미 방문한 곳일 경우
                    continue;
                }

                if (campus[next_row][next_col] == 'P') {
                    //친구를 만났을 경우
                    count++;
                }

                que.add(new Point(next_row, next_col));
                check[next_row][next_col] = true;
                //위 조건들을 걸쳐 방문을 하였음을 의미
            }
        }

    }

    public static void dfs(int r, int c){
        check[r][c] = true;

        if(campus[r][c] == 'P')
            count++;

        for(int i = 0; i < 4; i++){
            int next_row = r + dx[i];
            int next_col = c + dy[i];

            if(next_row < 0 || next_col < 0 || row <= next_row || col <= next_col )
                continue;

            if(campus[next_row][next_col] == 'X' || check[next_row][next_col])
                continue;

            dfs(next_row, next_col);
        }
    }

}


