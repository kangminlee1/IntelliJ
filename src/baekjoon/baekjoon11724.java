package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon11724 {

    static int node, line;
    static int[][] dp;
    static boolean[] check;

    static int count = 0;

    //bfs는 queue + linkedList
    static Queue<Integer> que = new LinkedList<>();



    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        dp = new int[node+1][node+1];
        check = new boolean[node+1];
        //+1 -> 0부터가 아닌 1부터 카운트하기 위함


        for(int i = 1; i <= line; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            dp[u][v] = dp[v][u] = 1;//연결된 선을 의미
        }


        for(int i= 1; i <= node; i++){
            if(!check[i]) {
                //노드를 검사하여 아직 노드를 방문하지 않았다면
                dfs(i);
                //깊이 우선 탐색을 실시
                count++;
                //쭉 돌려서 탐색을 실시 한 후 연결 요소 개수 증가
            }
        }


        sb.append(count);
        System.out.println(sb);


        count = 0;
        sb = new StringBuffer();
        check = new boolean[node+1];

        for(int i = 1; i <= node; i++){
            if(!check[i]){
                //아직 방문하지 않은 노드면
                bfs(i);
                count++;
            }

        }

        sb.append(count);
        System.out.println(sb);

    }

    public static void dfs(int start){
        check[start] = true;
        //그 노드(정점)을 방문 했음

        for(int i = 0; i <= node; i++){
            if(dp[start][i] == 1 && !check[i] ) {
                //정점을 아직 방문하지 않았고 연결된 선이라면
                dfs(i);
                //깊이 우선 탐색
            }
        }

    }

    public static void bfs(int start){
        que.add(start);
        check[start] = true;
        //먼저 방문한 노드 체크 및 큐에 넣음

        while(!que.isEmpty()){
            start = que.poll();
            //시작점이 Queue에 있던 값

            for(int i = 0; i <= node; i++){
                if(dp[start][i] == 1 && !check[i]){
                    //아직 방문하지 않았고 연결되어 있다면
                    que.add(i);
                    check[i] = true;
                    //방문 했으니 노드를 Queue에 집어넣고 체크
                }
            }


        }

    }

}
