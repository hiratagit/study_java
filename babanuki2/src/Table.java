import java.util.ArrayList;

public class Table {

	private ArrayList<Card[]> disposedCards = new ArrayList<Card[]>();

	public void disposeCard(Card card[]) {
		for(int index = 0; index < card.length; index++) {
			System.out.println(card[index] + " ");
		}

		System.out.println("を捨てました");

		disposedCards.add(card);
	}
}