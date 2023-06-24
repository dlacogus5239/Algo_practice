package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14426 {
	// 백준 14426 접두사 찾기 (트라이 알고리즘)

	static int N, M;
	static final int MAX = 10000 * 500 + 5;
	static final int ROOT = 1;

	static int unused = ROOT + 1;
	static int[][] nxt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nxt = new int[MAX][26];
		for (int i = 0; i < MAX; i++) {
			Arrays.fill(nxt[i], -1);

		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			insert(s);
		}
		int result = 0;
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (check(s)) {
				result++;
			}
		}

		System.out.println(result);

	}

	public static int ctoi(char c) {
		return c - 'a';
	}

	public static void insert(String s) {
		int cur = ROOT;
		char[] sArr = s.toCharArray();
		for (char c : sArr) {
			if (nxt[cur][ctoi(c)] == -1) {
				nxt[cur][ctoi(c)] = unused++;
			}
			cur = nxt[cur][ctoi(c)];
		}

		return;
	}

	public static boolean check(String s) {
		int cur = ROOT;
		char[] sArr = s.toCharArray();

		for (char c : sArr) {
			if (nxt[cur][ctoi(c)] == -1) {
				return false;
			}
			cur = nxt[cur][ctoi(c)];
		}
		return true;

	}

}
