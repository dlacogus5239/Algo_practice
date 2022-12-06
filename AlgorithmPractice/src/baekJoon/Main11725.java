package baekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11725 {

	static ArrayList<Integer>[] tree; // 트리
	static int[] p; // 각 노드 (1 ~ N)의 부모를 저장할 배열
	static boolean[] isVisited; // 방문체크

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		isVisited = new boolean[N + 1];
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Integer>();
		} // 변수 선언과 tree 초기화 END

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		} // 트리 생성(양방향)

		for (int i = 1; i <= N; i++) {
			if (!isVisited[i]) {
				dfs(i);
			}
		} // 각 노드별로 dfs를 수행해 준다

		for (int i = 2; i <= N; i++) {
			System.out.println(p[i]);
		} // 결과 출력

	}

	public static void dfs(int start) {
		if (isVisited[start]) {
			return;
		} // 방문했던 곳이면 반환
		isVisited[start] = true; // 현재 노드 방문체크
		for (int i = 0; i < tree[start].size(); i++) {
			if (!isVisited[tree[start].get(i)]) {
				p[tree[start].get(i)] = start; // 지금 방문하고 있는 노드의 자식들을 dfs시키고 있다. 즉 지금 더 깊게 나아갈 노드들의 부모는 지금 현재 방문중인 노드.
				dfs(tree[start].get(i)); // 자식 방문
			}
		}
	}
}
