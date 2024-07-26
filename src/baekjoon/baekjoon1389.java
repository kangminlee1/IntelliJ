package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1389 {

    static int man, friend;

    static ArrayList<Integer>[] graph;
    //연결되어 있는 그래프 표현을 위함
    static int[] map;
    //해당하는 사람의 연결된 수

    static int min = Integer.MAX_VALUE;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        man = Integer.parseInt(st.nextToken());
        //사람의 수
        friend = Integer.parseInt(st.nextToken());
        //인간관계의 수

        map = new int[man + 1];
        //1일 때, 2일 때.... 카운트하기 위함

        graph = new ArrayList[man + 1];
        //1일 때, 2일 때 .... 그래프를 표현하기 위함

        for(int i = 1; i <= man; i++){
            graph[i] = new ArrayList<>();
            //그래프를 초기화
        }


        for(int i = 1; i <= friend; i++){
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            graph[row].add(col);
            graph[col].add(row);
            //무방향 그래프로 서로 연결

        }
        
        int min_cnt = 0;
        //케빈 베이컨 수가 가장 적은 사람

        for(int i = 1; i <= man; i++){
            int temp = kevin_bacon(i);

            if(min > temp){
                min = temp;
                min_cnt = i;
            }

        }

        System.out.println(min_cnt);
    }

    public static int kevin_bacon(int start){
        Arrays.fill(map, -1);
        //방문 여부와 count 초기화 (기존 값에 영향을 받지 않기 위함)
        //Arrays.fill(배열, 초기화할 값);
        int count = 0;
        //이동 횟수
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        map[start] = 0;
        //해당하는 사람을 0으로 초기화
        //밑에 조건문에서 -1이 아니면 방문한 사람으로 간주하기 위함

        while(!que.isEmpty()){
            int temp = que.poll();

            for(int i : graph[temp]){
                //graph[temp] 는 해당 그래프 배열에 들어있는 요소를 의미하기 위함
                if(map[i] != -1) {
                    continue;
                    //만약 방문 했다면 pass
                }

                map[i] = map[temp] + 1;
                //해당 사람을 방문하지 않았다면 건너오는 경로 + 1
                count += map[i];
                //이동 횟수 갱신
                que.add(i);

            }
        }

        return count;
    }

}
