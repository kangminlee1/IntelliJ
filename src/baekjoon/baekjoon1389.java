package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1389 {

    static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x= x;
            this.y = y;

        }
    }

    static int man, friend;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    //연결되어 있는 그래프 표현을 위함

    static int min = Integer.MAX_VALUE;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        man = Integer.parseInt(st.nextToken());
        //사람의 수
        friend = Integer.parseInt(st.nextToken());
        //인간관계의 수

        for(int i = 0; i <= man; i++){
            graph.add(new ArrayList<>());
            //그래프를 초기화
        }


        for(int i = 0; i < friend; i++){
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            graph.get(row).add(col);
            graph.get(col).add(row);
            //무방향 그래프로 서로 연결

        }
        
        int min_cnt = 0;
        //케빈 베이컨 수가 가장 적은 사람

        for(int i = 1; i <= man; i++){
            if( min > kevin_bacon(i)){
                min = kevin_bacon(i);
                min_cnt = i;
            }
        }

        System.out.println(min_cnt);
    }

    public static int kevin_bacon(int start){
//        Arrays.fill(map, -1);
        //방문 여부와 count 초기화 (기존 값에 영향을 받지 않기 위함)
        //Arrays.fill(배열, 초기화할 값);
        int count = 0;
        //이동 횟수
        Queue<Point> que = new LinkedList<>();
        boolean[] check = new boolean[man + +1];

        que.add(new Point(start, 0));
        check[start] = true;

        while(!que.isEmpty()){
            Point temp = que.poll();

            for(int i : graph.get(temp.x)){
                //graph[temp] 는 해당 그래프 배열에 들어있는 요소를 의미하기 위함
                if(!check[i]) {
                    //방문하지 않았을 경우
                    count += temp.y + 1;
                    //방문하지 않았던 관계 이동 횟수 갱신
                    check[i] = true;
                    que.add(new Point(i, temp.y + 1));
                }
            }
        }

        return count;
    }

}
