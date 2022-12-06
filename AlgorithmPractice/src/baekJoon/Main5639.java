package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5639 {
	static class Node {
		int num;
		Node left, right;

		public Node(int num) {
			this.num = num;
		}

		public void insert(int num) {
			// 삽입하고자 하는 노드가 현재 노드보다 작으면, 왼쪽 삽입
			if (num < this.num) {
				// 삽입할 자리가 있을 때까지 탐색해준다
				if (this.left == null) {
					this.left = new Node(num);
				} else {
					this.left.insert(num);
				}
			} else { // 아니면 오른쪽 삽입
				if (this.right == null) {
					this.right = new Node(num);
				} else {
					this.right.insert(num);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node root = new Node(Integer.parseInt(br.readLine()));

		String input;
		while (true) {
			input = br.readLine();
			if (input == null || input.equals(""))
				break;

			root.insert(Integer.parseInt(input));
		}

		postOrder(root);
	}

	public static void postOrder(Node node) {
		if (node.left != null) {
			postOrder(node.left);
		}
		if (node.right != null) {
			postOrder(node.right);
		}
		System.out.println(node.num);
	}

}