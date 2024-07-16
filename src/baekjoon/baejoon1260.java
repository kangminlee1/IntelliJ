package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class baejoon1260 {
    static int node, line, start;

    static int[][] dp;
    static boolean[] visit;
    static StringBuffer sb = new StringBuffer();

    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        dp = new int[node+1][node+1];
        visit = new boolean[node+1];
        //+1 -> 0부터가 아닌 1부터 카운트하기 위함

        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            dp[num1][num2] = dp[num2][num1] = 1;//연결되었다는 것을 의미

        }

        dfs(start);
        sb.append("\n");//출력 값에서 한줄 띄기 위함

        visit = new boolean[node+1];
        bfs(start);

        System.out.println(sb);


    }


    public static void dfs(int start){//깊이 우선은 stack or 재귀
        visit[start] = true;//방문함
        sb.append(start + " ");//방문한 것을 받음

        for(int i = 0; i <= node; i++){
            if(dp[start][i] == 1 && !visit[i]){
                //만약 그 노드와 다른 노드 사이가 연결되어 있고  방문하지 않았다면
                dfs(i);
                //그 노드를 기준으로 다시 깊이 우선 탐색(dfs)를 실시
            }

        }

    }

    public static void bfs(int start){//넓이 우선은 queue or 연결리스트
        que.add(start);//방문
        visit[start] = true;//방문 했으니 true;

        while(!que.isEmpty()) {//que가 빌 떄 까지

            start = que.poll();
            sb.append(start + " ");

            for(int i = 1 ; i <= node ; i++) {
                if(dp[start][i] == 1 && !visit[i]) {
                    //만약 그 노드와 다른 노드 사이가 연결되어 있고  방문하지 않았다면
                    que.add(i);
                    visit[i] = true;
                }
            }
        }

    }



}
