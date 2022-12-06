package baekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2644 {
	static ArrayList<Integer>[] fam;
	static int N;
	static int[] distance;

	static int A;
	static int B;

	static int result = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		distance = new int[N + 1];
		Arrays.fill(distance, -1);

		int M = Integer.parseInt(br.readLine()); // 관계 수

		fam = new ArrayList[N + 1]; // 0은 버린다
		for (int i = 1; i <= N; i++) {
			fam[i] = new ArrayList<Integer>(); // 초기화
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
//			System.out.println("From : " + from + " To : " + to);
//			System.out.println(i);
			fam[from].add(to);
			fam[to].add(from);
		}

//		for (int i = 1; i <= N; i++) {
//
//			System.out.println(fam[i].toString());
//		}
		distance[A] = 0;
		Queue<Integer> q = new LinkedList<Integer>();

		q.offer(A);
		while (!q.isEmpty()) {
			int tmp = q.poll();
			if (tmp == B) {
				result = distance[tmp];
			}
			for (int i = 0; i < fam[tmp].size(); i++) {
				int cur = fam[tmp].get(i);
				if (cur == B) {
					result = distance[tmp] + 1;
					break;
				}
				if (distance[cur] != -1) {
					continue;
				}
				distance[cur] = distance[tmp] + 1;
				q.add(cur);
			}
		}

		System.out.println(result);
//		for (int n : distance) {
//			System.out.print(n + " ");
//		}
	}

}