package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon18111 {

    //땅을 평평하게 만들 떄 시간이 이전 땅 높이를 만들때보다 적게 들면
    //현재 땅 높이 저장, 높이가 같다면 높이가 더 높은 값 저장
    //블록의 개수를 체크하여 사용된 블록이 음수면, 그 땅을 만들 수 없음
    //블록이 0개 이상이면 땅을 평평하게 만들 수 있음

    //땅을 평평하게 만들때 층이 높아질 수록 시간과 블록의 개수는 낮아지고 높이는 높아짐
    //반대로 층이 낮아질수록 시간과 블록의 개수는 증가하고 높이는 낮아짐
    //따라서 위에서 말한 행위를 반복하면 블록이 0보다 낮아지기 전까지 계속 시간과 층을 저장할경우
    //제일 높은 층과 낮은 층이 저장되고 블록이 음수가 됐을 경우 반복문을 종료하면 원하는 값 얻음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int block_number = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];

        int min = 256;
        int max = 0;
        //땅에 높이는 0~256까지의 자연수 이므로


        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < col; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max)
                    max = map[i][j];
                if(map[i][j] < min)
                    min = map[i][j];
                //땅에서 가장 높은 값과 낮은 지점을 구함

            }
        }

        int time = 99999999;
        //time의 최소 시간을 저장할 변수
        //올 수 있는 시간은 6400만 정도이므로 넉넉하게 저장
        int high = 0;
        //만들 층의 높이

        for(int i = min; i <= max; i++){
            //땅의 높이는 입력한 값에서 가장 작은 값부터 가장 큰 값까지
            int count = 0;
            //걸린 시간
            int block = block_number;
            //현재 블록 수

            for(int j = 0; j < row; j++){
                for(int k = 0; k < col; k++){

                    if(i < map[j][k]){
                        //현재 칸의 높이가 구하고자하는 높이보다 클 경우
                        count += ((map[j][k] - i) * 2);
                        //현재 칸에서 낮은 높이 만큼 제거한 후 *2를 함
                        //문제에서 높이가 낮아질 때 즉, 블록을 제거할 떈 2의 시간이 걸림
                        block += (map[j][k] - i);
                        //현재 칸에서 필요한 높이만큼 제거한 블록의 수
                    } else{
                        //현재 칸과 만들고자하는 칸의 높이보다 작거나 같을 경우
                        count += (i - map[j][k]);
                        //블록을 더 쌓거나 냅둠
                        block -= (i - map[j][k]);
                        //블록을 사용한 만큼 제거(같으면 그대로 낮으면 갖고 있던 블록 소모)
                    }

                }
            }

            if(block < 0)
                break;
            //블록이 음수가 되면 종료

            if(time >= count){
                time = count;
                high = i;
            }
            //블록의 개수가 음수가 아니고 현재 시간이 같거나 적으면
            //시간을 걸린 시간으로 변경하고
            //높이를 변경한다.
            //높이가 높아질수록 시간이 덜 걸림
        }

        System.out.println(time + " " + high);

    }

}
