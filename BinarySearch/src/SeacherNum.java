import java.util.Arrays;
import java.util.Scanner;

public class SeacherNum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		SeacherNum sn = new SeacherNum();
		
		int n = in.nextInt();
		int[] a_arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			a_arr[i] = in.nextInt();
		}
		
		Arrays.sort(a_arr);
		int m = in.nextInt();
		for(int i = 0; i < m; i++) {
			int num = in.nextInt();
			System.out.println(sn.search(a_arr, num));
		}
	}
	
	public int search(int[] arr, int num) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(arr[mid] == num) {
				return 1;
			}else if(arr[mid] > num) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		
		return 0;
	}

}
