package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
인출할 수 있는 금액을 줄여나가면서 금액을 산출하는 방식
최소검색범위와 최대검색범위를 잘 설정해야 한다.
n번 인출한다고 하면 주어진 값 중 제일 큰 값을 꺼내면 되고 1번 인출해야 한다면 주어진 값을 모두 더한값을 인출하면 된다.
비용에 따라서 부족하면 다시 won대로 해 계산, 그렇지 않으면 그냥 빼서 부족할 때 마다 카운팅
카운팅한 값이 m보다 크면 범위를 늘리고 그렇지 않으면 범위를 줄인다
 */

public class No6236 {

    static int[] day_Cost;
    static int m;
    static int min = 0;//최소검색범위
    static int max = 0;//최대검색범위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        day_Cost = new int[n];

        for(int i = 0; i < n; i++){
            day_Cost[i] = Integer.parseInt(br.readLine());
            max += day_Cost[i];//최대 검색범위는 모든 값을 더한 값
            min = Math.max(min, day_Cost[i]);//최소 범위는 배열의 값중 가장 큰 값
        }

        System.out.println(binary_Search());
    }

    static int binary_Search(){
        int left = min;
        int right = max;

        //범위를 대상으로 이분탐색
        while(left <= right){
            int mid = (left + right) / 2;
            int count = counting(mid);//mid원씩 인출할 때 인출하는 횟수

            if(count > m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    static int counting(int won){
        int now = won;//시작은 지정한 금액부터 시작
        int count = 1;//인출 횟수
        for(int i = 0; i < day_Cost.length; i++){
            int cost = day_Cost[i];//하루에 쓰는 비용
            if(now < cost){//현재 금액이 적다면 총장에 담은 후 won대로 인출
                now = 0;
                count += cost / won;//다만 현재 금액보다 won이 작을 수 있기 때문에 나눈 만큼 카운팅한다
                now += won;
                if(cost % won > 0){//나머지가 있으면 하나더 카운팅한다
                    count++;
                }
            }

            now -= cost;//비용을 사용했으므로 현재 금액에서 뺀다
        }

        return count;
    }
}
