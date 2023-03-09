package baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2098 {
	// 백준 2098 외판원 순회
	// DP, TSP, 비트마스크
	// TSP(외판원 순회 문제) : 모든 노드 간에 이동비용이 주어졌을 때,
	// 각 노드를 한번만 방문하고 처음 시작점으로 돌아오는 최소 비용을
	// 구하는 문제
	// 반복되는 부분을 제거해서 시간복잡도를 줄이는 것이 제일 중요

	// dp[Node][visit] = min(dp[node][visit], dp[i][visit | (1<<i)] + arr[node][i])
	static int N;
	static int[][] graph;
	static int[][] dp;
	static final int INF = 16000000;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		dp = new int[N][(1 << N) - 1]; // ex) 1 << 5 = 100000(2) = 32 -> 최대값 : 11111(2)이므로 1 빼기?
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken()); // 비용 저장
			}
		}
		br.close();

		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1); // MAX 값 : 11,000,000
		}

		bw.write(TSP(0, 1) + "\n");
		bw.flush();
		bw.close();
	}

	public static int TSP(int node, int visit) {
		if (visit == (1 << N) - 1) { // 모든 도시 방문 (최대값일 경우)
			if (graph[node][0] == 0) { // 혹시 발생하는 예외
				return INF;
			}
			return graph[node][0]; // 현재 도시-> 0번째(시작)도시 이동 거리
		}

		if (dp[node][visit] != -1) { // dp값이 존재하는 경우
			return dp[node][visit];
		}

		dp[node][visit] = INF;

		for (int i = 0; i < N; i++) { // 현재 도시(node)에서 각 i번째 노드(도시)로 이동한 경우의 dfs 수행
			if ((visit & (1 << i)) == 0 && graph[node][i] != 0) { // 한번이라도 그 도시 방문했는데, 다시 그 도시 방문하는 경우 예외
				// dp[i][j] = 현재 도시 i, 방문한 도시 집합(비트마스킹)j..
				// 방문하지 않은 나머지 도시 들을 모두 방문한 뒤 출발 도시로 돌아올 때 드는 최소 비용
				// 즉, 방문해야 하는 도시(시작지점으로 돌아오는 것 포함) 들까지 가는 최소 비용

				// TSP(다음 도시, 다음도시 방문처리) + 여기서 다음 도시까지 거리, 최소거리 비교
				dp[node][visit] = Math.min(dp[node][visit], TSP(i, visit | (1 << i)) + graph[node][i]);
			}

		}

		return dp[node][visit];
	}

}
