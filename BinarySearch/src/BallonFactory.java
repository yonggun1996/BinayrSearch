package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
가장 오래걸리는 사람이 모든 풍선을 다 불 경우를 최대 시간으로 설정
0부터 그 수 까지 이분탐색을 한다.
이분탐색을 하면서 모든 사람이 그 시간당 몇 개씩 부는지 더해
찾으려는 값보다 작으면 왼쪽으로 아니면 오른쪽으로 탐색한다.
 */

public class BallonFactory {

    static long[] second;//한 사람당 풍선 만드는데 몇 초가 걸리는지 담은 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        second = new long[n];
        long max = 0;//주어진 풍선만드는 시간중 가장 긴 시간
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            second[i] = Integer.parseInt(st.nextToken());
            max = Math.max(second[i], max);
        }

        System.out.println(binarysearch(m, max * m));//max는 가장 오래 걸리는 사람이 모든 풍선을 다 불 경우 이다.

    }

    //각 초마다 몇 개의 풍선을 만들 수 있는지 이분탐색으로 탐색하는 메서드
    public static long binarysearch(long count, long max){
        long start = 0;
        long end = max;

        while(start <= end){
            long mid = (start + end) / 2;
            long divcount = division(mid);

            if(divcount >= count){//최솟값을 구해야 하기 때문에 똑같으면 왼쪽으로 탐색한다
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return start;
    }

    public static long division(long mid){
        long num = 0;
        for(int i = 0; i < second.length; i++){
            num +=( mid / second[i]);
        }

        return num;
    }

}
