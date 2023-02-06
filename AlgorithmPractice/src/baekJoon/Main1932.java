package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1932 {
	// 백준 1932 정수 삼각형
	static int N;
	static ArrayList<Integer>[] triangle;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		triangle = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			triangle[i] = new ArrayList<Integer>();
		}

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int lineLen = st.countTokens();
			for (int j = 0; j < lineLen; j++) {
				triangle[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		// input END

		// N selected -> next N or N + 1
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < triangle[i].size(); j++) {
				if (j == triangle[i].size() - 1) {
					triangle[i].set(j, triangle[i - 1].get(j - 1) + triangle[i].get(j));
				} else if (j == 0) {
					triangle[i].set(j, triangle[i - 1].get(j) + triangle[i].get(j));
				} else {
					triangle[i].set(j, Math.max(triangle[i - 1].get(j - 1) + triangle[i].get(j),
							triangle[i - 1].get(j) + triangle[i].get(j)));
				}
			}
		}
		Collections.sort(triangle[N - 1]);
		System.out.println(triangle[N - 1].get(triangle[N - 1].size() - 1));
	}

}
