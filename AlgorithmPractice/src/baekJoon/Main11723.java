package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11723 집합
public class Main11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int set = 0;

		int MIN = 0;
		int MAX = 0B11111111111111111111;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			int x = 0;
			int tmp = 0;
			switch (op) {
			case "all":
				set = set | MAX;
				break;
			case "empty":
				set = set & MIN;
				break;
			case "add":
				x = Integer.parseInt(st.nextToken());
				tmp = 1 << x - 1;
				set = set | tmp;
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				tmp = ~(1 << x - 1);
				set = set & tmp;
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				int n = (set & 1 << x - 1) != 0 ? 1 : 0;
				sb.append(n).append("\n");
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				tmp = 1 << x - 1;
				set = set ^ tmp;
				break;
			}

		}
		System.out.println(sb.toString());

	}

}
