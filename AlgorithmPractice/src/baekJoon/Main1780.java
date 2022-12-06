package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1780 {
	static int N;
	static int[][] paper;
	static int[] result = new int[3]; // -1, 0, 1

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Paper(N, 0, 0);
		for (int i = 0; i < 3; i++) {
			System.out.println(result[i]);
		}
	}

	public static void Paper(int wh, int w, int h) { // 검색할 너비, 시작좌표
		/*
		 * if (wh == 1) { return; }
		 */
		int tmp = paper[h][w];
		boolean Same = true;
		for (int i = h; i < h + wh; i++) {
			for (int j = w; j < w + wh; j++) {
				if (tmp != paper[i][j]) {
					Same = false;
					break;
				}
			}
		} // 같은지 판단
		if (Same) {
			result[tmp + 1]++;
			return;
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) { // 좌표를 넘겨줄 시에, 9등분을 한 정보를넘겨줘야 한다. 9등분을 하려면 각각 가로, 세로 3등분씩
					Paper(wh / 3, w + j * wh / 3, h + i * wh / 3);
				}
			}
		}

	}
}