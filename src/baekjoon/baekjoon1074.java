package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1074 {

    static int N, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        find_num(r, c, (int)Math.pow(2, N));
//        //Math.pow -> 거듭제곱을 구할 때 사용

//        find_num(0, 0, (int)Math.pow(2, N));

        System.out.println(count);
    }

    public static void find_num(int row, int col, int size){
        if(size == 1){
            //사이즈가 1이면 찾은것이므로 종료
            return;
        }

        int new_size = size/2;

        //1~4 사분면 중 찾는 row, col이 어디에 위치하는지 쪼개면서 계산
        if(row < new_size && col < new_size){//2사분면
            find_num(row, col, new_size);
        } else if(row < new_size && col >= new_size){//1사분면
            count += size * size / 4;
            find_num(row, col - new_size, new_size);
        } else if(row >= new_size && col < new_size){//3사분면
            count += (size * size / 4) * 2;
            find_num(row - new_size, col, new_size);
        } else{//4사분면
//            (row >= new_size && col >= new_size)
            count += (size * size / 4) * 3;
            find_num(row-new_size, col-new_size, new_size);
        }
/* 이건 0,0을 기준으로 시작할 떄
        if(r < row + new_size && c < col + new_size){
            find_num(row, col, new_size);
        }
        if(r < row + new_size && c >= col + new_size){
            count += (size*size/4);
            find_num(row, col + new_size, new_size);
        }
        if(r >= row + new_size && c < col + new_size){
            count += (size * size /4)*2;
            find_num(row + new_size, col, new_size);
        }
        if(r >= row + new_size && c >= col + new_size){
            count += (size * size /4)*3;
            find_num(row + new_size, col + new_size, new_size);
        }
*/
    }

}
