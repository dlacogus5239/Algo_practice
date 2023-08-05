package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889 {
	// 백준 14889 스타트와 링크
	static int N;
	static int[][] graph;

	static boolean[] team;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		// true : 스타트 팀, false : 링크 팀
		team = new boolean[N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		br.close();
		// input END

		BackTracking(0, 0);
		System.out.println(result);

	}

	// 한쪽 팀원 구성원 CNT
	public static void BackTracking(int cnt, int start) {
		if (cnt == N / 2) {
			// 각 팀의 점수 계산
			Calc();
			return;
		}

		for (int i = start; i < N; i++) {
			if (!team[i]) {
				team[i] = true;
				BackTracking(cnt + 1, i + 1);
				team[i] = false;
			}
		}

	}

	public static void Calc() {
		int startTeam = 0;
		int linkTeam = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (team[i] && team[j]) {
					startTeam += graph[i][j];
					startTeam += graph[j][i];
				} else if (!team[i] && !team[j]) {
					linkTeam += graph[i][j];
					linkTeam += graph[j][i];
				}
			}
		}

		int tmp = Math.abs(startTeam - linkTeam);
		result = Math.min(result, tmp);

	}

}
