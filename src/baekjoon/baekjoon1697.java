package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1697 {

    static int bro, subin;
    static int[] check = new int[100001];

    static Queue<Integer> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        bro = Integer.parseInt(st.nextToken());

        if(subin == bro){
            System.out.println(0);
        }else{
            find_bro(subin, bro);
        }


    }

    public static void find_bro(int subin, int bro){
        que.add(subin);
        check[subin] = 1;
        //시작 부분이므로 수빈이의 위치를 저장하고 시작 이므로 1을 저장해 둠

        while(!que.isEmpty()){
            int temp = que.poll();

            for(int i = 0; i < 3; i++){
                int next;
                if(i == 0){
                    next = temp - 1;
                }else if(i == 1){
                    next = temp + 1;
                }else{
                    next = 2*temp;
                }

                if(next == bro){
                    //찾았을 경우 출력 후 종료
                    System.out.println(check[temp]);
                    return;
                }

                if(next >= 0 && next < check.length && check[next] == 0){
                    //해당 케이스에서 next가 음수가 아니고
                    //전체 범위를 벗어나지 않으며
                    //아직 방문하지 않은 곳이라면
                    que.add(next);
                    check[next] = check[temp] + 1;


                }

            }

        }


    }
}
