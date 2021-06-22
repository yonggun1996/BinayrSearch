import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CutTreeBuffer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		CutTreeBuffer ct  = new CutTreeBuffer();
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st1.nextToken());//나무의 개수
		int m = Integer.parseInt(st1.nextToken());//원하는 나무의 길이
		int[] arr = new int[n];
		
		StringTokenizer st2;
		for(int i = 0; i < n; i++) {
			st2 = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		Arrays.sort(arr);
		
		bw.write(String.valueOf(ct.search(arr, m)));
		bw.flush();
		bw.close();
	}
	
	//이분탐색
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
			
			//해당 높이의 나무를 벌목하는 경우가 더 있기 때문에 발견했을 때 바로 break하지 않는다
			if(cm >= m) {
				//최대값을 구하라고 했기 때문에 같으면 start를 늘린다
				start = mid + 1;
			}else {
				finish = mid - 1;
			}
		}
		
		return finish;
	}

}
