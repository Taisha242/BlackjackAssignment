public class BlackjackCard extends Card {
    private int pointValue;

    public BlackjackCard(String ranking, String suit, int pointValue) {
        super(ranking, suit);
        this.pointValue = pointValue;
    }

    public int getPointValue() {
        return pointValue;
    }
}
