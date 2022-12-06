package baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준 2606 바이러스 
public class Main2606 {
	static ArrayList<Integer> computer[];
	static boolean[] infection;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int computerNum = Integer.parseInt(br.readLine());
		int networkNum = Integer.parseInt(br.readLine());
		StringTokenizer st;

		computer = new ArrayList[computerNum + 1];
		infection = new boolean[computerNum + 1];
		for (int i = 0; i < computerNum + 1; i++) {
			computer[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < networkNum; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			computer[from].add(to);
			computer[to].add(from);
			// to ~ from 도 추가할 것
		}
		// input END

		// dfs
		dfs(1);
		int cnt = 0;

		for (int i = 1; i <= computerNum; i++) {
			if (infection[i]) {
				cnt++;
			}
//			System.out.print(infection[i] + " ");
		}
		System.out.println(cnt - 1);
	}

	public static void dfs(int infectCom) {
		infection[infectCom] = true;

		if (computer[infectCom].size() == 0) {
			return;
		}

		for (int c = 0; c < computer[infectCom].size(); c++) {
			if (!infection[computer[infectCom].get(c)]) {
				dfs(computer[infectCom].get(c));
			}
		}
	}

}