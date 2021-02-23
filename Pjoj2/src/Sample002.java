/**
 *
 */

/**
 * @author dzdq8
 *
 */

public class Sample002 {

	/**
	 * @param args
	 */

	//ジャンケンの手を表す定数
	public static final int STONE = 0; //グー
	public static final int SCISSOR = 1; // チョキ
	public static final int PAPPER = 2; // パー

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//■■■■■■■■■■■■■■■■■■■■
		//①プログラムが開始したことを表示する
		//■■■■■■■■■■■■■■■■■■■■

		System.out.println("【ジャンケン開始】\n");

		double randomNum = 0;
		//プレイヤー１の勝ち数
		int player1WinCount = 0;
		//プレイヤー2の勝ち数
		int player2WinCount = 0;

		for(int i = 0; i < 3; i++) {

			System.out.println( "【" + (i + 1) + "回戦目】");


			//■■■■■■■■■■■■■■■■■■■■
			//②プレイヤー1が何を出すか決める
			//■■■■■■■■■■■■■■■■■■■■

			int player1Hand = 0;

			randomNum = Math.random() * 3;

			if(randomNum < 1) {
				player1Hand = STONE;
				System.out.print("グー");
			}else if(randomNum < 2) {
				player1Hand = SCISSOR;
				System.out.print("チョキ");
			}else if(randomNum < 3) {
				player1Hand = PAPPER;
				System.out.print("パー");
			}

			System.out.print(" vs ");

			//■■■■■■■■■■■■■■■■■■■■
			//③プレイヤー2が何を出すか決める
			//■■■■■■■■■■■■■■■■■■■■

			int player2Hand = 0;

			randomNum = Math.random() * 3;

			if(randomNum < 1) {
				player2Hand = STONE;
				System.out.print("グー");
			}else if(randomNum < 2) {
				player2Hand = SCISSOR;
				System.out.print("チョキ");
			}else if(randomNum < 3) {
				player2Hand = PAPPER;
				System.out.print("パー");
			}

			System.out.println();


			//■■■■■■■■■■■■■■■■■■■■
			//④どちらが勝ちかを判定し、結果を表示する
			//■■■■■■■■■■■■■■■■■■■■

			if(    (player1Hand == STONE && player2Hand == SCISSOR)
				|| (player1Hand == SCISSOR && player2Hand == PAPPER)
				|| (player1Hand == PAPPER && player2Hand == STONE)
			) {
				player1WinCount ++;
				System.out.println("\nプレイヤー1が勝ちました\n");

			}else if ( (player1Hand == SCISSOR && player2Hand == STONE)
					|| (player1Hand == PAPPER && player2Hand == SCISSOR)
					|| (player1Hand == STONE && player2Hand == PAPPER )
			) {
				player2WinCount ++;
				System.out.println("\nプレイヤー2が勝ちました\n");
			}else {
				System.out.println("\n引き分けです\n");
			}
		}


		System.out.println("【ジャンケン終了】\n");

		if(player1WinCount > player2WinCount) {
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー1の勝ちです\n");
		}else if(player1WinCount < player2WinCount) {
			System.out.println(player1WinCount + "対" + player2WinCount + "でプレイヤー2の勝ちです\n");
		}else if(player1WinCount == player2WinCount) {
			System.out.println(player1WinCount + "対" + player2WinCount + "で引き分けです\n");
		}
	}

}
