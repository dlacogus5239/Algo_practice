package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2342 {
	// 백준 2342 Dance Dance Revolution
	static int[] movement;
	// (x, y)꼴
	// 0 : Center
	// 1 : Up
	// 2 : Left
	// 3 : Down
	// 4 : Right
	static int[][][] dp;
	// (left, right)
	static int[] foot = { 0, 0 };
	static int length;

	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		length = st.countTokens();
		movement = new int[length - 1];
		dp = new int[length + 1][5][5];
		for (int i = 0; i < length - 1; i++) {
			movement[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// input END
		int answer = DDR(0, 0, 0);
		System.out.println(answer);
	}

	public static int DDR(int step, int left, int right) {
		if (step == length - 1) {
			return 0;
		}
		if (dp[step][left][right] != 0) {
			return dp[step][left][right];
		}

		int leftCost = Cost(left, movement[step]) + DDR(step + 1, movement[step], right);
		int rightCost = Cost(right, movement[step]) + DDR(step + 1, left, movement[step]);

		dp[step][left][right] = Math.min(leftCost, rightCost);

		return dp[step][left][right];
	}

	public static int Cost(int cur, int next) {
		if (cur == next) {
			return 1;
		}
		if (cur == 0) {
			return 2;
		}
		if (Math.abs(cur - next) == 2) {
			return 4;
		}
		return 3;

	}

}
