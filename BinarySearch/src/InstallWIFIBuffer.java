import java.util.Arrays;
import java.util.Scanner;

public class InstallWIFIBuffer {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int count = in.nextInt();
		
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[size - 1];
		int answer = 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			int installcount = search(arr, mid);
			
			if(installcount >= count) {
				answer = Math.max(mid, answer);
				start =  mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
	
	public static int search(int[] arr, int dist) {
		int cnt = 1;
		int inszone = arr[0] + dist;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] >= inszone) {
				cnt++;
				inszone = arr[i] + dist;
			}
		}
		
		return cnt;
		
	}

}
