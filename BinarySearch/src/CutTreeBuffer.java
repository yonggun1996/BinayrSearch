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
		int n = Integer.parseInt(st1.nextToken());//������ ����
		int m = Integer.parseInt(st1.nextToken());//���ϴ� ������ ����
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
	
	//�̺�Ž��
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
			
			//�ش� ������ ������ �����ϴ� ��찡 �� �ֱ� ������ �߰����� �� �ٷ� break���� �ʴ´�
			if(cm >= m) {
				//�ִ밪�� ���϶�� �߱� ������ ������ start�� �ø���
				start = mid + 1;
			}else {
				finish = mid - 1;
			}
		}
		
		return finish;
	}

}
