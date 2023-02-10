package programmers;

import java.util.Arrays;

public class Solution0210_2 {

	int solution(int[][] land) {
		int answer = 0;
		for (int i = 1; i < land.length; i++) {
			land[i][0] = Math.max(Math.max(land[i][0] + land[i - 1][1], land[i][0] + land[i - 1][2]),
					land[i][0] + land[i - 1][3]);
			land[i][1] = Math.max(Math.max(land[i][1] + land[i - 1][0], land[i][1] + land[i - 1][2]),
					land[i][1] + land[i - 1][3]);
			land[i][2] = Math.max(Math.max(land[i][2] + land[i - 1][0], land[i][2] + land[i - 1][1]),
					land[i][2] + land[i - 1][3]);
			land[i][3] = Math.max(Math.max(land[i][3] + land[i - 1][0], land[i][3] + land[i - 1][1]),
					land[i][3] + land[i - 1][2]);
		}

		Arrays.sort(land[land.length - 1]);

		return land[land.length - 1][3];
	}
}
