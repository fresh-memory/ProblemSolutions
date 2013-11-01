

public class Dealer extends Person {
	
	private GamingRule rule;
	
	public Dealer(String name, GamingRule rule) {
		super(name);
		this.rule = rule;
	}
	
	public Card showOneCard() { 
		return this.cards.get(0);
	}
	
	public void catchUp(CardDeck cards) {
		rule.catchUp(this, cards);
		
	}
	
}
