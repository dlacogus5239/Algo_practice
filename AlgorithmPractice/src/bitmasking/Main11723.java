package bitmasking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11723 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int num = 0;
		final int MIN = 0;
		final int MAX = 0B11111111111111111111;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			int input;
			switch (oper) {
			case "all":
				num = num | MAX;
				break;
			case "empty":
				num = num & MIN;
				break;
			case "add":
				input = Integer.parseInt(st.nextToken());
				num |= 1 << input - 1;
				break;
			case "remove":
				input = Integer.parseInt(st.nextToken());
				num &= ~(1 << input - 1);
				break;
			case "check":
				input = Integer.parseInt(st.nextToken());
				sb.append((num & (1 << input - 1)) != 0 ? 1 : 0).append("\n");
				break;
			case "toggle":
				input = Integer.parseInt(st.nextToken());
				num ^= 1 << input - 1;
				break;
			}

		}

		System.out.println(sb.toString());
	}

}
