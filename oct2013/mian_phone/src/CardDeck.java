import java.util.Random;

public class CardDeck {
	private static final int LIFE_CYCLE = 6;
	private int life;
	private int index;
	private static Random randomGen = new Random();
	
	private Card[] cards;
	
	public CardDeck() {
		cards = new Card[52];
		int index = 0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				cards[index] = new Card(Card.SUIT.values()[i], Card.RANK.values()[j]);
				index++;
			}
		}
		life = 0;
		shuffle();
		index = 0;
	}
	
	public int getLife() {
		return this.life;
	}
	
	/**
	 * reclaim cards and shuffle once life hits LIFE_CYCLE
	 */
	public void useOnce() {
		if(needShuffle()) {
			shuffle();
		}
		this.life++;
	}
	
	public void shuffle() {
		 for(int i=51; i>0; i--) {
			int r = randomGen.nextInt(52);
			Card tmp = cards[r];
			cards[r] = cards[i];
			cards[i] = tmp;
		}
		life = 0;
		index = 0;
	}
	
	private boolean needShuffle() {
		return this.life == CardDeck.LIFE_CYCLE;
	}
	
	public Card getOne() {
		Card card = cards[index];
		index++;
		return card;
	}
	
	public void showCards() {
		for(Card card : cards) {
			System.out.print(card + "\t");
		}
		System.out.println("");
	}
	
}
