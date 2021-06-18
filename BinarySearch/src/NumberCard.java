import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class NumberCard {
	
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		NumberCard nc = new NumberCard();
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			int num = in.nextInt();
			arr[i] = num;
			
			if(map.containsKey(num)) {
				int change_Value = map.get(num);
				map.put(num, change_Value + 1);
			}else {
				map.put(num, 1);
			}
		}
		
		int m = in.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < m; i++) {
			int num = in.nextInt();
			
			if(map.get(num) == null) {
				sb.append(0);
				sb.append(" ");
			}else {
				sb.append(map.get(num));
				sb.append(" ");
			}
			
		}
		
		System.out.println(sb);
	}

}
