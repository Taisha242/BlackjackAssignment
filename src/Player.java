import java.util.ArrayList;

public abstract class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    protected ArrayList<Card> getHand() {
        return hand;
    }

    public void initializeHand() {
        hand.clear();
    }

    public abstract void play();

    public int calculateHandValue() {
        int handValue = 0;
        for (Card card : hand) {
            // Add logic here to calculate hand value
        }
        return handValue;
    }
}
