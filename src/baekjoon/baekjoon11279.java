package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
//import java.util.StringTokenizer;

public class baekjoon11279 {

    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        작은 수 부터 나옴 오름차순
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        //큰 수 부터 나옴 <내림차순>

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            int heap_num = Integer.parseInt(br.readLine());

            if(heap_num == 0){
                if(priorityQueue.isEmpty()){
                    sb.append(0);

                } else{
                    sb.append(priorityQueue.poll());
                }

                sb.append("\n");

            } else {
                priorityQueue.add(heap_num);
            }
        }

        System.out.println(sb);


    }

}
