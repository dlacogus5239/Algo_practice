package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1620 {
	// 백준 1620 나는야 포켓몬 마스터 이다솜
	static int N, M;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap<String, String> hp = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String cur = br.readLine();
			hp.put(cur, Integer.toString(i));
			hp.put(Integer.toString(i), cur);
		}

		for (int i = 0; i < M; i++) {
			sb.append(hp.get(br.readLine()));
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
