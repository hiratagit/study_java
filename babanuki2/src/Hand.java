import java.util.ArrayList;

public class Hand {

	private ArrayList hand = new ArrayList();

	/*カードを加える*/
	public void addCard(Card card) {
		hand.add(card);
	}

	/*カードを引く*/
	public Card pickCard() {
		Card pickedCard = (Card) hand.remove(0);

		return pickedCard;
	}

	/*カードをシャッフルする*/
	public void shuffle() {

		int number = hand.size();
		/*カードを抜きだす位置*/
		int pos;

		/*カードをランダムに抜き取って最後に加える動作を繰り返す*/
		for(int count = 0; count < number * 2; count++) {

			pos = (int) (Math.random() * number);
			Card pickedCard = (Card) hand.remove(pos);
			hand.add(pickedCard);
		}
	}

	/*枚数を数える*/
	public int getNumberOfCards() {
		return hand.size();
	}

	/*同じ数のカードを探す。ない場合はnullを返す*/
	public Card[] findSameNumberCard() {
		int numberOfCards = hand.size();
		Card[] sameCards = null;

		if(numberOfCards > 0) {

			/*最後に追加されたカードを取得する*/
			int lastIndex = numberOfCards - 1;
			Card lastAddedCard = (Card) hand.get(lastIndex);

			//最後に追加されたカードの数字を取得する
			int lastAddedCardNum = lastAddedCard.getNumber();

			for(int index = 0; index < lastIndex; index++) {
				Card card = (Card) hand.get(index);
				if(card.getNumber() == lastAddedCardNum ) {

					//最後に追加されたカードを同じカードが見つかった場合
					//見つかった組み合わせをsameCardsに格納し、ループを抜ける

					sameCards = new Card[2];
					sameCards[0] = (Card) hand.remove(lastIndex);
					sameCards[1] = (Card) hand.remove(index);

					break;
				}
			}
		}

		return sameCards;
	}

		//手札にあるカードを文字列で表現する
		public String toString() {
			StringBuffer string = new StringBuffer();

			int size = hand.size();
			if(size > 0) {
				for(int index = 0; index < size; index++) {
					Card card = (Card) hand.get(index);
					string.append(card);
					string.append(" ");
				}
			}

			return string.toString();
		}


}