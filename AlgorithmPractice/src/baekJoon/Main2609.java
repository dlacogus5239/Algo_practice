package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2609 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int x = Math.min(a, b);
		int y = Math.max(a, b);

		int max = 0;
		int min = 0;
		for (int i = x; i >= 1; i--) {
			if (x % i == 0 && y % i == 0) {
				max = i;
				break;
			}
		}

		System.out.println(max);
		int INF = (int) Math.pow(10000, 2);

		while (min < INF) {
			min += max;
			if (min % x == 0 && min % y == 0) {
				break;
			}
		}
		System.out.println(min);

	}

}
