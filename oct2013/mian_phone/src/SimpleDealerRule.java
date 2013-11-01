
public class SimpleDealerRule implements GamingRule {
	@Override
	public void catchUp(Dealer dealer, CardDeck cards) {
		// as long as hit soft 17, stop
		while(dealer.getSoftScore() < 17) {
			Card card = cards.getOne();
			dealer.take(card);
		}
	}

}
