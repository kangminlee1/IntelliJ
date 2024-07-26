package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon30804 {

    static int fruit;
    static int[] fruit_arr;
    static int[] fruit_kind;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fruit = Integer.parseInt(br.readLine());
        //탕후루에 꽂힐 과일 수
        fruit_arr = new int[fruit];
        //탕후루에 꽂힌 과일 종류(번호) 의미
        fruit_kind = new int[10];
        //1~9까지 사용(과일의 종류 의미)

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < fruit; i++){
            fruit_arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPoint(0, 0, 0, 0,0));

    }

    public static int twoPoint(int left, int right, int kind, int max, int count){
        /*
        left = 왼쪽 포인터
        right = 오른쪽 포인터
        kind = 과일 종류의 수
        max = 과일 종류가 2이하일 때 최대 개수
        count = 현재 left 포인터 ~ right 포인터 까지 개수
         */



        if(right == fruit){
            //우측 포인터가 배열의 끝에 도달했을 경우 종료
            return max;
        }


        if(fruit_kind[fruit_arr[right]] == 0){
            //오측포인터가 새로 도달한 과일이 찾았던 종류가 아닌 경우
            kind++;
            //과일 종류 수 증가
        }

        count++;
        //현재 left~right 갱신(배열의 길이 증가)
        fruit_kind[fruit_arr[right]]++;
        //해당하는 과일의 종류의 개수 증가
        //도달한 과일 수 증가

        if(kind > 2){
            //종류가 3개 이상일경우
            if(--fruit_kind[fruit_arr[left]] == 0){
                //과일의 개수를 감소 시켰을 때 0일경우
                kind--;
                //과일 종류 감소
            }
            count--;
            left++;
            //left~right 길이 감소(배열길이 감소) + 좌측 포인터 이동
        }

        /*
        if(kind > 2){
            //과일 종류가 3개 이상일 경우
            fruit_kind[fruit_arr[left]]--;
            //좌측 포인터가 가리킨 과일 수 감소
            count--;
            //배열길이 감소

            if(fruit_kind[fruit_arr[left]] == 0){
                //좌측 포인터가 가리키는 값에 종류의 개수가 0이라면
                //즉, 왼쪽 포인터가 가리킨 과일이 없다면
                kind--;
            }
            left++;
            //왼쪽 포인터 우측으로 이동
        }
         */


        max = Math.max(max, count);
        //현잭 left ~ right 까지의 개수와 max 를 비교해서 최대 값을 갱신


        return twoPoint(left, right + 1, kind, max, count);
    }

}
