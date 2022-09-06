package kazuate;

import java.util.Arrays;
import java.util.Random;

public class KazuateQuiz {
	public static void main(String[] args) {
		//ゲームの説明
		System.out.println("0～9でランダムに生成される3つの数のうち、どれか1つの数字を当ててください。");
		System.out.println("5回まで挑戦できます。");
		System.out.println("では、スタート!" + "\n");
		//生成されたランダム値
		int[] numbers = comanswer();
		//answer が true になったら数あてクイズが終了する。または、ループが5回まわったらゲームを終了する。
		boolean answer = false;
		for (int i = 0; i < 5; i++) {
			int input;
			//ユーザーの入力
			while (true) {
				System.out.println((i + 1) + "回目：1桁の数字を入力してください。");
				try {
					input = new java.util.Scanner(System.in).nextInt();
					if (0 <= input && input < 10) {
						break;
					} else {
						System.err.println("0～9の範囲で入力してください。" + "\n");
					}
				} catch (Exception e) {
					System.err.println("0～9の範囲で入力してください。" + "\n");
				}
			}
			//正解判定
			for (int num : numbers) {
				if (num == input) {
					answer = true;
					System.out.println("アタリ!");
				}
			}
			//判定結果
			if (answer == true) {
				System.out.println("答え：" + Arrays.toString(numbers));
				System.out.println("また挑戦してね!");
				System.out.println("~~~ ゲーム終了 ~~~");
				break;
			} else if (i < 4) {
				System.out.println("ハズレ!もう一度挑戦!" + "\n");
			} else {
				System.out.println("~~~ ゲームオーバー ~~~");
				System.out.println("答え：" + Arrays.toString(numbers));
				System.out.println("また挑戦してね!");
			}
		}
	}

	//ランダム値 0～9 を含む、int型の配列生成メソッド
	public static int[] comanswer() {
		int[] numbers = new Random().ints(3, 0, 9).toArray();
		return numbers;
	}
}