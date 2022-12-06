package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// SWEA 4012 요리사
public class Solution4012 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int[][] synerge = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synerge[i][j] = Integer.parseInt(st.nextToken());
				}

			}
			// 시너지 Input END

			int result = Integer.MAX_VALUE;
			// 조합 이용
			int[] p = new int[N];
			int cnt = 0;
			while (++cnt <= N / 2) {
				p[N - cnt] = 1;
			}
			do {
				int tasteA = 0;
				int tasteB = 0;
				for (int i = 0; i < N; i++) {
					if (p[i] == 1) {
						for (int j = 0; j < N; j++) {
							if (p[j] == 1) {
								tasteA += synerge[i][j];
							}
						}
					} else if (p[i] == 0) {
						for (int j = 0; j < N; j++) {
							if (p[j] == 0) {
								tasteB += synerge[i][j];
							}
						}
					}
				}
				result = Math.min(result, Math.abs(tasteA - tasteB));
			} while (comb(p));

			System.out.println("#" + test_case + " " + result);
		}
	}

	public static boolean comb(int[] p) {
		int L = p.length;
		int i = L - 1;

		while (i > 0 && p[i - 1] >= p[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		int j = N - 1;

		while (p[i - 1] >= p[j]) {
			j--;
		}

		swap(p, i - 1, j);

		int k = L - 1;
		while (i < k) {
			swap(p, i, k);
			i++;
			k--;
		}
		return true;
	}

	static void swap(int[] p, int i, int j) {
		int temp;
		temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
