import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SeacherNumBuffer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		SeacherNumBuffer sn = new SeacherNumBuffer();
		
		int n = Integer.parseInt(br.readLine());
		int[] a_arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			a_arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a_arr);
		int m = Integer.parseInt(br.readLine());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int num = Integer.parseInt(st2.nextToken());
			bw.write(String.valueOf(sn.search(a_arr, num)));
			bw.newLine();
		}
		bw.flush();
		bw.close();
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
