package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6064 {
	// 백준 6064 카잉 달력
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int M, N, x, y;
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int lcm = M * N / gcd(M, N);
			int n = 0;
			int ans = -1;
			while (n * M < lcm) {
				if ((n * M + x - y) % N == 0) {
					ans = n * M + x;
					break;
				}
				n++;
			}

			System.out.println(ans);
		}
	}

	static int gcd(int n1, int n2) {
		if (n2 == 0)
			return n1;
		return gcd(n2, n1 % n2);
	}

}
