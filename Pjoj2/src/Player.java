
public class Player{
	//ジャンケンの手を表す定数
	public static final int STONE = 0; //グー
	public static final int SCISSOR = 1; // チョキ
	public static final int PAPPER = 2; // パー

	private String name;
	private int winCount = 0;

	private Tactics tactics_;

	public Player(String name) {
		this.name = name;
	}

	//------------------------
	//
	//-------------------------
	void setTacics(Tactics tactics) {
		this.tactics_ = tactics;
	}

	//-----------------------
	//ジャンケンの手を出す
	//@return ジャンケンの手（int）
	//-----------------------

	public int showHand() {

		int hand = this.tactics_.readTactics();

		return hand;
	}

	//-----------------------
	//審判から勝敗を聞く
	//@param result true:勝ち false:負け
	//-----------------------

	public void notifyResult(boolean result) {
		if(result == true) {
			winCount++;
		}
	}

	//-----------------------
	//トータル勝ち数を答える
	//@return 勝った回数
	//-----------------------
	public int getWinCount() {
		return this.winCount;
	}

	public String getName() {
		return this.name;
	}



}
