
public class Judge {

	public void startJanken(Player player1, Player player2) {

		System.out.println("\n【ジャンケン開始】\n");

		for(int i = 0; i < 3; i++) {


			System.out.println( "【" + (i + 1) + "回戦目】\n");


			Player winner = judgeJanken(player1, player2);


			if(winner != null) {
				System.out.println("\n" + winner.getName() + "が勝ちました\n" );
				winner.notifyResult(true);
			}else {
				System.out.println("引き分けです\n");
			}

		}

		System.out.println("ジャンケン終了\n");

		Player winner = finalJudgeWinner(player1, player2);

		System.out.println(player1.getWinCount() + " vs " + player2.getWinCount() + "で");

		if(winner != null) {
			System.out.println("総合勝者は" + winner.getName() + "です");
		}else {
			System.out.println("引き分けです");
		}

	}

	private Player judgeJanken(Player player1, Player player2) {

		Player winner = null;

		int player1Hand = player1.showHand();
		int player2Hand = player2.showHand();

		printHand(player1Hand);
		System.out.println(" vs " );
		printHand(player2Hand);

		if((player1Hand == Player.STONE && player2Hand == Player.SCISSOR)
		 || (player1Hand == Player.SCISSOR && player2Hand == Player.PAPPER)
		 || (player1Hand == Player.PAPPER&& player2Hand == Player.STONE))
		{
			winner = player1;
		}else if( (player2Hand == Player.STONE && player1Hand == Player.SCISSOR)
				 || (player2Hand == Player.SCISSOR && player1Hand == Player.PAPPER)
				 || (player2Hand == Player.PAPPER&& player1Hand == Player.STONE) ) {
			winner = player2;
		}


		return winner;
	}


	public Player finalJudgeWinner(Player player1, Player player2) {

		Player winner = null;

		if(player1.getWinCount() > player2.getWinCount()) {
			winner = player1;
		}else if(player1.getWinCount() < player2.getWinCount()){
			winner = player2;
		}

		return winner;
	}


	private void printHand(int hand) {

		switch(hand) {
		case Player.STONE:
			System.out.println("グー");
			break;
		case Player.SCISSOR:
			System.out.println("チョキ");
			break;
		case Player.PAPPER:
			System.out.println("パー");
			break;
		default :
			break;
		}

	}

}
