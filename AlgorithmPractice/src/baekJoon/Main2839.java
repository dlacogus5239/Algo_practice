package baekJoon;

import java.util.Scanner;

//백준 2839 설탕배달
public class Main2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // input END

		int five = N / 5;	// 처음 5키로의 봉지로 담을 수 있을만큼 담음
		N -= five * 5;	//남는 무게
		int three = 0;
		while (five >= 0) {	// 5키로의 봉지가 0개가 될때까지
			if (N % 3 == 0) {	// 3키로의 봉지로 나머지가 다 담기면
				three = N / 3;	// 3키로 봉지 계산0
				N -= three * 3;
				break;
			}
			N += 5;	// 5키로 봉지를 하나씩 빼가면서 3으로 나누어지는지 While문으로 계산
			five -= 1;
		}
		if (N == 0) {
			System.out.println(five + three);
		} else {
			System.out.println("-1");
		}

	}
}