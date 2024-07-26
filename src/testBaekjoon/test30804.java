package testBaekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test30804 {

    static int fruit;
    static int[] fruit_arr;
    static int[] fruit_kind = new int[10];
    //과일의 종류 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fruit = Integer.parseInt(br.readLine());
        fruit_arr = new int[fruit];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < fruit; i++){
            fruit_arr[i] = Integer.parseInt(st.nextToken());
        }

            System.out.println(two_pointer(0,0,0,0,0));

    }

    public static int two_pointer(int left, int right, int max, int kind, int count){

        if( right >= fruit ){
            return max;
        }

        if(fruit_kind[fruit_arr[right]] == 0){
            //아직 탐색하지 않은 곳이면 종류 츄가
            kind++;
        }

        count++;
        fruit_kind[fruit_arr[right]]++;
        //배열 길이 증가, 과일 종류 수 증가

        if(kind > 2){
            //종류가 2개 넘으면
            if(--fruit_kind[fruit_arr[left]] == 0){
                //왼쪽 포인터가 가리키는 값의 종류 1개 감소
                //그 때 비었다면
                kind--;
            }
            count--;
            left++;
            //배열 길이 감소, left 포인터 이동
        }

        max = Math.max(max, count);
        //가장 많은 탕호루 과일의 개수와 현재 배열 길이 비교


        return two_pointer(left, right + 1, max, kind, count);
    }




}
