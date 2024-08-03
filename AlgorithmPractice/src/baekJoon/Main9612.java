package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main9612 {
	// 백준 9612 Maximum Word Frequency
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> hm = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			hm.put(input, hm.getOrDefault(input, 0) + 1);
		}
		int max = -1;
		String answer = "";
		for (String s : hm.keySet()) {
			if (max <= hm.get(s)) {
				if (s.compareTo(answer) > 0) {
					answer = s;
				}
				max = hm.get(s);
			}
		}

		System.out.print(answer + " ");
		System.out.println(max);

	}

}
