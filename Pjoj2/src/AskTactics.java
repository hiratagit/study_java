
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class AskTactics implements Tactics {



	public AskTactics() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public int readTactics() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\nジャンケンの手を入力してください。");
		System.out.println("0: グー");
		System.out.println("1: チョキ");
		System.out.print("2: パー");
		System.out.println("？");

		int hand = 0;

		while(true) {

			try {
				String inputStr = br.readLine();
				hand = Integer.parseInt(inputStr);

				if(   hand == Player.STONE
				   || hand == Player.SCISSOR
				   || hand == Player.PAPPER
				) {
					break;
				}else {
					System.out.println("入力が正しくありません。再度入力してください。");
					System.out.print("？");
				}

			}catch(Exception ex){
				System.out.println("入力が正しくありません。再度入力してください。");
				System.out.print("？");
			}

		}

		return hand;
	}

}
