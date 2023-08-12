import java.util.ArrayList;

public class PlayerBlackjack extends Player {
    private ArrayList<BlackjackCard> hand;

    public PlayerBlackjack(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    @Override
    public void play() {
        // Implement the specific logic for the player's turn in Blackjack
    }

    public void addCardToHand(BlackjackCard card) {
        hand.add(card);
    }

    @Override
    public int calculateHandValue() {
        int handValue = 0;
        int numAces = 0;

        for (BlackjackCard card : hand) {
            handValue += card.getPointValue();

            if (card.getRanking().equals("Ace")) {
                numAces++;
            }
        }

        while (numAces > 0 && handValue > 21) {
            handValue -= 10;
            numAces--;
        }

        return handValue;
    }
}
