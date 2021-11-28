package Greedy;

import java.util.Scanner;

public class getCoinCnt {
	private static final int coinType [] = {500, 100, 50, 10};

	
	public static void main(String [] arg){
		getLeastCoinCnt();
	}
		
	public static void  getLeastCoinCnt() {
		//int n = 1260;
		int cnt = 0;
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("가격을 입력하세요.");
		n = sc.nextInt();

		for (int coin : coinType) {
			cnt += n / coin;
			n %= coin;
		}
		System.out.println("필요한 동전의 최소 갯수" + cnt + "개");
	}
}
