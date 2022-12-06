package baekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main5567 {
	// dfs

	static boolean[] isVisited; // 방문체크배열
	static ArrayList<Integer>[] list; // 트리

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 상근이의 동기 수
		int M = Integer.parseInt(br.readLine()); // 리스트의 길이
		list = new ArrayList[N + 1]; // 트리
		isVisited = new boolean[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		} // 트리(리스트) 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		} // input END
		isVisited[1] = true; // 처음 본인(1)부터 dfs시작

		dfs(1, 0);
		int result = 0;
		for (int i = 2; i < isVisited.length; i++) {
			if (isVisited[i]) {
				result++;
			}
		}
		System.out.println(result);
	}

	public static void dfs(int start, int cnt) {
		if (cnt == 2) { // 친구(깊이 1)와 친구의 친구(깊이 2)를 초대한다
			return;
		}
		for (int i = 0; i < list[start].size(); i++) {
			int next = list[start].get(i);
			isVisited[next] = true;
			dfs(next, cnt + 1);
		}
	}

}