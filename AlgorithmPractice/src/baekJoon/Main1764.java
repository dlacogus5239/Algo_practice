package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1764 {
	// 백준 1764 듣보잡

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, M;
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<String> result = new ArrayList<>();
		Set<String> input = new HashSet<>();

		for (int i = 0; i < N; i++) {
			input.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String cur = br.readLine();
			if (input.contains(cur)) {
				result.add(cur);
			}
		}

		result.sort((o1, o2) -> (o1.compareTo(o2)));

		System.out.println(result.size());

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

}
