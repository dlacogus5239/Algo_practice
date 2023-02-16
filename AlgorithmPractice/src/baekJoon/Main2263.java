package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2263 {
	// 백준 2263 트리의 순회
	static int N;

	// 후위 순회(post order)의 끝 값은 항상 맨 위의 root!
	// 분할 정복!
	static int[] inTree;
	static int[] postTree;
	static int[] preTree;

	static int idx = 0;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		inTree = new int[N];
		postTree = new int[N];
		preTree = new int[N];
//		System.out.println("INORDER");
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inTree[i] = Integer.parseInt(st.nextToken());
//			System.out.print(inTree[i] + " ");
		}
//		System.out.println();
		st = new StringTokenizer(br.readLine());
//		System.out.println("POSTORDER");
		for (int i = 0; i < N; i++) {
			postTree[i] = Integer.parseInt(st.nextToken());
//			System.out.print(postTree[i] + " ");
		}
//		System.out.println();

		getPreOrder(0, N - 1, 0, N - 1);

		// input END

		for (int i = 0; i < N; i++) {
			System.out.print(preTree[i] + " ");
		}

	}

	public static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart <= inEnd && postStart <= postEnd) {
			preTree[idx++] = postTree[postEnd];

			int pos = inStart;
			for (int i = inStart; i <= inEnd; i++) {
				if (inTree[i] == postTree[postEnd]) {
					pos = i;
					break;
				}
			}

			// 찾은 root(pos) 기준으로 왼쪽, 오른쪽 나눠서 다시 실행

			// 왼쪽
			getPreOrder(inStart, pos - 1, postStart, postStart + pos - inStart - 1);
			// 오른쪽
			getPreOrder(pos + 1, inEnd, postStart + pos - inStart, postEnd - 1);
		}
	}

}
