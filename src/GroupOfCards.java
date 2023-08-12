import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<BlackjackCard> cards;
    private int size;

    public GroupOfCards(int size) {
        this.size = size;
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] rankings = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String ranking : rankings) {
                int pointValue = getPointValueFromRanking(ranking);
                BlackjackCard card = new BlackjackCard(ranking, suit, pointValue);
                cards.add(card);
            }
        }
    }

    private int getPointValueFromRanking(String ranking) {
        if (ranking.equals("Ace")) {
            return 11;
        } else if (ranking.equals("King") || ranking.equals("Queen") || ranking.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(ranking);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BlackjackCard dealCard() {
        if (cards.isEmpty()) {
            System.out.println("No more cards in the deck.");
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
}
