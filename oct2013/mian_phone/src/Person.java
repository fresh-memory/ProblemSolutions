import java.util.ArrayList;
import java.util.List;


public abstract class Person {

	public static final String DEALER = "dealer";
	public static final String PLAYER = "player";
	
	protected List<Card> cards;
	protected String name;
	
	public Person(String name) {
		this.name = name;
		this.cards = new ArrayList<Card>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void take(Card card) {
		cards.add(card);
	}
	
	/**
	 * treat A as 1;
	 * if total is smaller than 11 and there is a A, boost it to 11 (1+10)
	 * 
	 */
	public int getScore() {
		int total = 0;
		for(Card card : cards) {
			total = total + card.faceValue();
		}
		if(total < 12) {
			for(Card card : cards) {
				if(card.getRank() == Card.RANK.A){
					total = total + 10;
					break;
				}
			}
		}
		return total;
	}
	
	/*
	 * max soft score, all A will give 11.
	 * used for dealer to hit 17
	 */
	public int getSoftScore() {
		int total = 0;
		for(Card card : cards) {
			total = total + card.faceValue();
			if(card.getRank() == Card.RANK.A){
				total = total + 10;
			}
		}
		return total;
	}
	
	public boolean bust() {
		return this.getScore() > 21;
	}
	
	public void showCards() {
		System.out.println(this.name + ": ");
		for(Card card : cards) {
			System.out.println(card);
		}
	}
	
	public void clearCards() {
		this.cards = new ArrayList<Card>();
	}
	
}
