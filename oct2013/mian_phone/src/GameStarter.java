

import java.util.ArrayList;
import java.util.List;

public class GameStarter {

	/*
	 * user input constant strings
	 */
	private static final String BEGIN = "b";
	private static final String QUIT = "q";
	private static final String PRINT = "p";
	private static final String STAND = "s";
	private static final String HIT = "h";
	
	public static void main(String[] args) {
		/*
		 * init dealer, player and cards
		 */
		SimpleDealerRule rule = new SimpleDealerRule();
		
		Dealer dealer = new Dealer(Person.DEALER, rule); 
		Player player = new Player(Person.PLAYER); 
		CardDeck cards = new CardDeck(); 
		
		List<GameStats> gameStats = new ArrayList<GameStats>();
		
		while(true) {
			String userChoice = askForStartGameOption();
			if(userChoice.equals(BEGIN)) {
				gameStats.add(playOnce(dealer, player, cards));
			}
			else if(userChoice.equals(PRINT)) {
				calculateStats(gameStats);
			}
			else if(userChoice.equals(QUIT)) {
				break;
			}
			else {
				continue;
			}
		}
		calculateStats(gameStats);
	}
	
	/*
	 * check if there either dealer or player have 21 points at hand;
	 * return null if neither
	 */
	private static Person checkTwentyOne(Player player, Dealer dealer) {
		int playerScore = player.getScore();
		int dealerScore = dealer.getScore();
		if(playerScore == 21 && dealerScore != 21) {
			return player;
		}
		if(playerScore != 21 && dealerScore == 21){
			return dealer;
		}
		return null;
	}
	
	/*
	 * return the person that is the winner of this set
	 * null if tied
	 */
	private static Person checkWinner(Player player, Dealer dealer) {
		int playerScore = player.getScore();
		int dealerScore = dealer.getScore();
		if(playerScore == dealerScore) {
			return null;
		}
		if(playerScore == 21 && dealerScore != 21) {
			return player;
		}
		if(playerScore != 21 && dealerScore == 21){
			return dealer;
		}
		if(playerScore < 21) {
			if(dealerScore < 21) {
				return playerScore < dealerScore? dealer : player;
			}
			else {
				return player;
			}
		}
		else {
			if(dealerScore < 21) {
				return dealer;
			}
			else {
				return null;
			}
		}
	}
	
	/*
	 * show cards on both person
	 */
	private static void showHands(Dealer dealer, Player player) {
		System.out.println("*** ***");
		if(dealer != null) {
			dealer.showCards();
		}
		if(player != null) {
			player.showCards();
		}
	}
	
	/*
	 * show table and conclude game
	 */
	private static void printResult(Dealer dealer, Player player, Person winner) {
		showHands(dealer, player);
		System.out.println("Winner is : " + ((winner == null) ? GameStats.TIE : winner.getName()));
	}
	
	
	private static void init(Dealer dealer, Player player, CardDeck cards) {
		cards.useOnce();
		player.clearCards();
		dealer.clearCards();
		
		Card card1 = cards.getOne();
		dealer.take(card1);
		Card card2 = cards.getOne();
		player.take(card2);
		Card card3 = cards.getOne();
		dealer.take(card3);
		Card card4 = cards.getOne();
		player.take(card4);
	}
	
	private static GameStats playOnce(Dealer dealer, Player player, CardDeck cards) {
		init(dealer, player, cards);
		
		Person winner = checkTwentyOne(player, dealer);
		if(winner != null) {
			printResult(dealer, player, winner);
			return new GameStats(cards.getLife(), winner);
		}
		System.out.println("*** ***");
		System.out.println("Dealer: " + dealer.showOneCard());
		
		while(true) {
			showHands(null, player);
			String userChoice = askForHitOrStand();
			if(userChoice.equals(STAND)) {
				break;
			}
			else {
				Card moreCard = cards.getOne();
				player.take(moreCard);
				if(player.bust()) {
					break;
				}
			}
		}
	
		dealer.catchUp(cards);
		
		winner = checkWinner(player, dealer);
		
		GameStats result = new GameStats(cards.getLife(), winner);
		printResult(dealer, player, winner);
		return result;

	}
	
	private static String askForHitOrStand() {
		while(true) {
			System.out.println("Enter \"h\" to (h)it.");
			System.out.println("Enter \"s\" to (s)tand.");
			String userChoice = System.console().readLine().trim().toLowerCase();
			if(userChoice.equals(STAND) || userChoice.equals(HIT)) {
				return userChoice;
			}
			else{
				continue;
			}
		}
		
	}
	
	private static String askForStartGameOption() {
		System.out.println("Enter \"b\" to (b)egin game.");
		System.out.println("Enter \"q\" to (q)uit and check out.");
		System.out.println("Enter \"p\" to (p)rint gaming stats.");
		return System.console().readLine().trim().toLowerCase();
		
	}
	
	private static void calculateStats(List<GameStats> gameStats) {
		int playerWinningCount = 0;
		int dealerWinningCount = 0;
		int tieCount = 0;
		int totalCount = 0;
		for(GameStats stat : gameStats) {
			if(stat.getWinner() == null) {
				tieCount++;
			}
			else if(stat.getWinner().getName().equals(Person.PLAYER)) {
				playerWinningCount++;	
			}
			else{
				dealerWinningCount++;
			}
		}
		System.out.println("Total game: " + gameStats.size());
		System.out.println("Player won: " + playerWinningCount);
		System.out.println("Dealer won: " + dealerWinningCount);
		System.out.println("Tied: " + tieCount);
		totalCount = gameStats.size() - tieCount;
		if(totalCount == 0) {
			System.out.println("You haven't played any game!!!");	
		}
		else {
                	System.out.println("Player had a winning % of " + (double) playerWinningCount*100/(totalCount));
		}
	}

	

}
