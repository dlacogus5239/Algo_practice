package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11050 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int top = 1;
		for (int i = 1; i <= N; i++) {
			top *= i;
		}
		int bottom = 1;
		for (int i = 1; i <= K; i++) {
			bottom *= i;
		}

		for (int i = 1; i <= N - K; i++) {
			bottom *= i;
		}

		int answer = top / bottom;

		System.out.println(answer);
	}

}
