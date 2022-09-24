package kazuate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KazuateQuiz {
	public static void main(String[] args) {

		//ゲームの説明
		System.out.println("0～9でランダムに生成される3つの数のうち、どれか1つの数字を当ててください。");
		System.out.println("5回まで挑戦できます。");
		System.out.println("では、スタート!" + "\n");

		//ランダム値 0～9 を含む、int型の配列生成
		int[] numbers = new Random().ints(3, 0, 9).toArray();

		//int型配列をリストへ変換
		List<Integer> numbersList = new ArrayList<>(numbers.length);
		for (int i : numbers) {
			numbersList.add(i);
		}

		//numbersList に input値が含まれていたら数あてクイズが終了する。または、ループが5回まわったらゲームを終了する。
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
						System.out.println("0～9の範囲で入力してください。" + "\n");
					}
				} catch (Exception e) {
					System.out.println("0～9の範囲で入力してください。" + "\n");
				}
			}

			//正誤判定
			if (numbersList.contains(input)) {
				System.out.println("アタリ!");
				System.out.println("答え：" + numbersList);
				System.out.println("また挑戦してね!");
				System.out.println("~~~ ゲーム終了 ~~~");
				break;
			} else if (i < 4) {
				System.out.println("ハズレ!もう一度挑戦!" + "\n");
			} else {
				System.out.println("~~~ ゲームオーバー ~~~");
				System.out.println("答え：" + numbersList);
				System.out.println("また挑戦してね!");
			}
		}
	}
}
