import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCardBuffer {
	
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			
			if(map.containsKey(num)) {
				int change_Value = map.get(num);
				map.put(num, change_Value + 1);
			}else {
				map.put(num, 1);
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st2.nextToken());
			
			if(map.get(num) == null) {
				sb.append(0);
				sb.append(" ");
			}else {
				sb.append(map.get(num));
				sb.append(" ");
			}
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
