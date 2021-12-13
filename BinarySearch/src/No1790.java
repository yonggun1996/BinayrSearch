package Avatar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
주어진 입력이 커서 StringBuilder를 붙이는 방법은 메모리 초과를 일으킨다.
우선 n이 1일 경우 k 가 범위내면 k 반환 그렇지 않으면 -1 반환
limit 배열을 통해서 각 숫자의 총 길이를 구할 수 있다.
이진탐색으로 k가 몇 번째 숫자에 속해있는지 판단
그 후 정답을 추출
도움이 된 블로그 : https://bgpark.tistory.com/112
 */

public class No1790 {

    //각 자리수 별로 최대 문자 길이
    static long[] limit = {9L, 180L, 2700L, 36000L, 450000L, 5400000L, 63000000L, 720000000L, 8100000000L};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        String k = st.nextToken();

        if(n.length() == 1){//n이 1의 자리수일 경우
            if(Integer.parseInt(n) < Integer.parseInt(k)){//k가 크면 범위를 벗어났기 대문에 -1을 반환
                System.out.println("-1");
            }else{//그렇지 않으면 k를 반환하면 된다
                System.out.println(k);
            }
            return;
        }

        int max = get_Max(n);//n의 최대 길이수

        if(Long.parseLong(k) > max){//k가 범위를 벗어나면 -1 반환
            System.out.println("-1");
        }else{
            if(Integer.parseInt(k) < 10){//k가 한 자리수일 경우
                if(Integer.parseInt(n) < Integer.parseInt(k)){
                    System.out.println(-1);//범위를 벗어나면 -1
                }else{
                    System.out.println(k);//그렇지 않으면 k 반환
                }
                return;
            }
            int num = binarySearch(Integer.parseInt(n), Integer.parseInt(k));//k에 속하는 수

            String num_str = "" + num;
            int len = get_Max(num_str);//k의 속하는 수의 최대 길이

            //그 중 정답을 추출
            System.out.println(num_str.charAt(num_str.length() - len + Integer.parseInt(k) - 1));
        }
    }

    //이분탐색으로 k번째 숫자가 무엇인지 반환하는 메소드
    static int binarySearch(int n, int k){
        int left = 1;
        int right = n;
        int result = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            int num = get_Max(String.valueOf(mid));

            if(k > num){
                left = mid + 1;
            }else{
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    //해당 숫자의 마지막 문자가 몇 번째인지 반환하는 메서드
    static int get_Max(String n){
        if(n.length() == 1) return Integer.parseInt(n);//길이가 1이면 그대로 환

        //n의 자리수에 따른 개수를 limit에 저장했는데 이를 n - 1번째 까지 더한다
        int max = 0;
        int unit = 1;
        for(int i = 0; i < n.length() - 1; i++){
            max += limit[i];
            unit *= 10;
        }

        max += (Integer.parseInt(n) - unit + 1) * n.length();//그리고 n과 10의 n길이 - 1승 만큼 누적해 반환
        return max;
    }
}
