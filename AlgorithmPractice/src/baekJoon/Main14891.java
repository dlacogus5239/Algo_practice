package baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14891 {
	// 백준 14891 톱니바퀴
	static int[][] gear = new int[4][8];
	static int N;
	static int[][] move;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0; j < 8; j++) {
				gear[i][j] = Integer.parseInt(input[i]);
			}
		}
		N = Integer.parseInt(br.readLine());
		move = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// input END
		
		
	}

}
