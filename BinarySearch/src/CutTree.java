import java.util.Arrays;
import java.util.Scanner;

public class CutTree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CutTree ct  = new CutTree();
		
		int n = in.nextInt();//나무의 개수
		int m = in.nextInt();//원하는 나무의 길이
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
		
		System.out.println(ct.search(arr, m));
	}
	
	public long search(int[] arr, int m) {
		long start = 0;
		long finish = arr[arr.length - 1];
		long mid = 0;
		
		while(start <= finish) {
			mid = (start + finish) / 2;
			long cm = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] >= mid) {
					cm += (arr[i] - mid);
				}
			}
			
			if(cm >= m) {
				start = mid + 1;
			}else {
				finish = mid - 1;
			}
		}
		
		return finish;
	}

}
