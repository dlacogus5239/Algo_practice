package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2143 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < M + 1; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		// input END
		int AS = 0, BS = 0;
		int BE = M, AE = N;
		
		
	}

}
