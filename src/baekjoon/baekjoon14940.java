package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon14940 {
    //        static int[][] distance;
    static int row, col;
    static boolean[][] check;
    static int[][] map;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map= new int[row][col];

            int start_x = 0;
            int start_y = 0;
            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < col; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 2) {
                        map[i][j] = 0;
                        start_x = i;
                        start_y = j;
                    }

                }
            }
            check = new boolean[row][col];
            bfs(start_x, start_y);

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] == 1 && !check[i][j]) {
                        map[i][j] = -1;
                    }
                    sb.append(map[i][j]+" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);

        }

        public static void bfs(int x, int y) {
            Queue<Point> que = new LinkedList<>();
            que.add(new Point(x, y));
            //큐에 점을 저장하는 방법
            check[x][y] = true;
            //방문 완료

            while (!que.isEmpty()) {
                Point temp = que.poll();
                //해당 점을 뽑아내는 방법

                for (int i = 0; i < 4; i++) {
                    int n_row = temp.x - dx[i];
                    int n_col = temp.y - dy[i];


//                    if (n_row < 0 || n_col < 0 || n_row >= row || n_col >= col)
//                        continue;
//                    if (check[n_row][n_col] || map[n_row][n_col] == 0)
//                        continue;

                    if (n_row < 0 || n_col < 0 || n_row >= row || n_col >= col) {
                        continue;
                    }
                    //배열 범위를 벗어나면 pass

                    if (map[n_row][n_col] == 0) {
                        continue;
                    }
                    //0인 곳은 방문하지 못함

                    if (check[n_row][n_col]) {
                        continue;
                    }
                    //방문 했으면 pass

                        //방문하지 않았고 갈 수 있는 점이일 경우
                        que.add(new Point(n_row, n_col));
                        check[n_row][n_col] = true;
                        //그 점을 Queue에 저장하고 방문했으니 true로 설정
                        map[n_row][n_col] = map[temp.x][temp.y] + 1;


                }

            }//while문 끝

        }//bfs의 끝
}
class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

    /*
static int N, M;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[N][M];

        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                    x = i;
                    y = j;
                }

            }
        }
        visited = new boolean[N][M];
        BFS(x, y);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    arr[i][j] = -1;
                }
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);


    }
    public static void BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny] || arr[nx][ny] == 0)
                    continue;
                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
                arr[nx][ny] = arr[n.x][n.y] + 1;
            }
        }
    }
}
class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
*/

