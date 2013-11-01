

public class GameStats {
	public static final String TIE = "tie";
	
	private String dealerStrategyName;
	private String playerStrategyName;
	private int cardLife;
	private Person winner;

	public Person getWinner() {
		return this.winner;
	}
	
	public GameStats(int cardLife, Person winner) {
		this.cardLife = cardLife;
		this.winner = winner;
	}
	
	public GameStats(int cardLife, Person winner, String dealerStrategyName, String playerStrategyName) {
		this.cardLife = cardLife;
		this.winner = winner;
		this.dealerStrategyName = dealerStrategyName;
		this.playerStrategyName = playerStrategyName;
	}
	
	public String getDealerStrategyName() {
		return this.dealerStrategyName;
	}
	
	public String getPlayerStrategyName() {
		return this.playerStrategyName;
	}
	
	public int getCardLife(){
		return this.cardLife;
	}
	
}
