import java.util.Arrays;
import java.util.Scanner;

public class CutLanLineBuffer {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		CutLanLineBuffer cll = new CutLanLineBuffer();
		
		int k = in.nextInt();
		int n = in.nextInt();
		
		int[] cm = new int[k];
		for(int i = 0; i < k; i++) {
			cm[i] = in.nextInt();
		}
		Arrays.sort(cm);
		
		System.out.println(cll.search(cm, n));
		
	}
	
	public long search(int[] cm, int n) {
		long start = 1;
		long finish = cm[cm.length - 1];
		long mid = 0;
		
		while(start <= finish) {
			long count = 0;
			mid = (start + finish) / 2;
			
			for(int i = 0; i < cm.length; i++) {
				count += cm[i] / mid;
			}
			
			if(count >= n){
				start = mid + 1;
			}else {
				finish = mid - 1;
			}
		}
		
		return finish;
	}

}
