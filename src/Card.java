/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * Taisha Newell-Nudd June 2023
 */
public class Card {
    private String ranking;
    private String suit;

    public Card(String ranking, String suit) {
        this.ranking = ranking;
        this.suit = suit;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return ranking + " of " + suit;
    }
}
