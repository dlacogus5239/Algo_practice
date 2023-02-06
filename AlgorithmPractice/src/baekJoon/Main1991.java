package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1991 {
	// 백준 1991 트리 순회
	static class Node {
		char ch;
		Node right;
		Node left;

		public Node(char ch) {
			this.ch = ch;
		}

	}

	static int N;
	static Node[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new Node[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = new Node((char) (i + 'A'));// arr[0]='A'로 채워짐.
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int N = s.charAt(0) - 'A';
			int L = s.charAt(2) - 'A';
			int R = s.charAt(4) - 'A';

			if (L != -19) {
				arr[N].left = arr[L];// N이 1일 경우 L은 3이고, R은 .(-19) 그러면 arr[1].right은 공백
			}
			if (R != -19) {
				arr[N].right = arr[R];
			}
		}

		preOrder(arr[0]);
		sb.append('\n');
		inOrder(arr[0]);
		sb.append('\n');
		postOrder(arr[0]);
		sb.append('\n');
		System.out.println(sb.toString());

	}

	public static void preOrder(Node node) {
		sb.append(node.ch);
		if (node.left != null) {// 예를 들어 arr[1].right은 공백이기에 이런 경우 지나갈 수 있음
			preOrder(node.left);

		}
		if (node.right != null) {
			preOrder(node.right);
		}
	}

	public static void inOrder(Node node) {
		if (node.left != null) {
			inOrder(node.left);
		}
		sb.append(node.ch);
		if (node.right != null) {
			inOrder(node.right);
		}

	}

	public static void postOrder(Node node) {
		if (node.left != null)
			postOrder(node.left);
		if (node.right != null) {
			postOrder(node.right);

		}
		sb.append(node.ch);
	}

}
