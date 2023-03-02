package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static int[][] position = { { 1, 1 }, { 1, 0 }, { 0, 1 }, { 1, 2 }, { 2, 1 } };
	static int[][] dp;
	public static void main(String[] args) throws IOException, NumberFormatException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = st.countTokens();
		movement = new int[length - 1];
		for (int i = 0; i < length - 1; i++) {
			movement[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		// input END
		
	}

}
