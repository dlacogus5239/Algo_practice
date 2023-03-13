package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15686 {
	// 백준 15686 치킨 배달
	static ArrayList<int[]> house = new ArrayList<>();
	static ArrayList<int[]> chicken = new ArrayList<>();
	static boolean[] isVisited;
	static int N, M;
	static int[][] map;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken.add(new int[] { j, i });
				} else if (map[i][j] == 1) {
					house.add(new int[] { j, i });
				}
			}
		}
		br.close();
		// input END
		isVisited = new boolean[chicken.size()];
		closeChicken(0, 0);

		System.out.println(result);
	}

	public static void closeChicken(int cnt, int start) {
		// 최소 폐업값 M을 만족시키면
		if (cnt == M) {
			int tmp = 0;
			for (int[] curHouse : house) {
				int curDistance = Integer.MAX_VALUE;
				for (int i = 0; i < chicken.size(); i++) {
					if (!isVisited[i]) {
						continue;
					}
					int[] choosen = chicken.get(i);
					int d = Math.abs(curHouse[0] - choosen[0]) + Math.abs(curHouse[1] - choosen[1]);
					curDistance = Math.min(d, curDistance);
				}
				tmp += curDistance;
			}
			result = Math.min(tmp, result);
			return;
		}

		for (int i = start; i < chicken.size(); i++) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				closeChicken(cnt + 1, start + 1);
				isVisited[i] = false;
			}
		}

	}

}
