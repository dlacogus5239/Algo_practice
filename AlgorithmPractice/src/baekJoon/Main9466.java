package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9466 {
	// 백준 9466 텀 프로젝트
	static int[] student;
	static int N;
	static boolean[] isVisited, done;
	static int result;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			result = 0;
			N = Integer.parseInt(br.readLine());
			student = new int[N + 1];
			isVisited = new boolean[N + 1];
			done = new boolean[N + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}
			// input END

			for (int i = 1; i <= N; i++) {
				dfs(i);
			}
			bw.write(String.valueOf(N - result));

			bw.write("\n");

		}
		bw.flush();
		bw.close();
	}

	public static void dfs(int n) {
		if (done[n]) {
			return;
		}
		if (isVisited[n]) {
			done[n] = true;
			result++;
		}
		isVisited[n] = true;
		dfs(student[n]);
		done[n] = true;
		isVisited[n] = false;
	}

}
