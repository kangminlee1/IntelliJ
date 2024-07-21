package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class baekjoon2630 {

        static int blue, white;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        dp = new int[num+1][num+1];

        StringTokenizer st;

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < num; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        partition(0, 0, num);

        System.out.println(white);
        System.out.println(blue);


    }

    public static void partition(int row, int col, int size){

        if(check(row, col, size)){
            //체크해서 현재 부분이 모두 같은 색상일 경우
            if(dp[row][col] == 0){
                white++;
            } else{
              blue++;
            }
            return;
            //전체 색상이 같을 때 파랑 or 하양을 ++해 주었으므로 해당 검사는 종료
        }

        int new_size = size/2;

        //색종이를 4등분 했을 때
        partition(row, col, new_size);//2사분면
        partition(row, col + new_size, new_size);//1사분면
        partition(row + new_size, col, new_size);//3사분면
        partition(row + new_size, col + new_size, new_size);//4사분면

    }

    public static boolean check(int row, int col, int size){

        int check_num = dp[row][col];
        //제일 첫번째 칸을 기준

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(check_num != dp[i][j]){
                    //만약 첫번째 칸과 다른 값을 갖는 다면
                    //전체가 같은 색상이 아니므로 false 리턴
                    return false;
                }
            }
        }

        return true;
        //전체가 같은 색상이므로 true 리턴
    }

}
