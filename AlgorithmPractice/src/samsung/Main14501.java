package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501 {
	// 백준 14501 퇴사
	static int N;
	// 상담 일수, 이득
	static int[] T, P;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			int day = T[i];
			int cost = P[i];
			
		}
	}

}
