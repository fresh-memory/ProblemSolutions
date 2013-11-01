public class Card {
	private RANK rank;
	private SUIT suit;
	
	public Card(SUIT suit, RANK rank) {
		this.suit = suit;
		this.rank = rank;
	}
	public enum SUIT {
		SPADE(1),
		HEART(2),
		CLUB(3),
		DIAMOND(4);
		
	private final int value;

        private SUIT(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
	}
	
	public enum RANK {
		A(1),
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		J(11),
		Q(12),
		K(13);
		
	private final int value;

        private RANK(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
	}
	
	public RANK getRank() {
		return this.rank;
	}
	
	public int faceValue() {
		if(this.rank.getValue() >10) {
			return 10;
		}
		return this.rank.getValue();
	}
	
	public String toString(){
		return this.suit + " " + this.rank;
	}
	
}
