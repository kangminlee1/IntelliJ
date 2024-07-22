package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon1931 {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int meeting = Integer.parseInt(br.readLine());
        arr = new int[meeting][2];

        StringTokenizer st;
        for(int i = 0; i < meeting; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }

        //종료 시간을 기준으로 정렬을 위한 compare 재정의
        Arrays.sort(arr, new Comparator<int[]>() {
            //종료시간이 같을 경우 시작시간이 빠른 순으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];

            }
        });

        System.out.println(find_max(meeting));

    }

    public static int find_max(int meeting){
        int temp = 0;
        int count = 0;

        for(int i = 0; i < meeting; i++){

            if(temp <= arr[i][0]){
                System.out.println(arr[i][0] + " " + arr[i][1]);
                //종료 시간이 다음 회의 시작 시간보다 적가나 같으면
                temp = arr[i][1];
                //갱신
                count++;
            }

        }
        return count;
    }

}