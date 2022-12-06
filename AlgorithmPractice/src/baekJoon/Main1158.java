package baekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

// 백준 1158 요세푸스 문제

public class Main1158 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		// Collections.rotate
		while (!list.isEmpty()) {
			Collections.rotate(list, -(K - 1));
			result.add(list.poll());
		}
		System.out.print("<");
		for (int i = 0; i < result.size(); i++) {
			if (i == result.size() - 1) {
				System.out.print(result.get(i));
				break;
			}
			System.out.print(result.get(i) + ", ");
		}
		System.out.println(">");
	}

}