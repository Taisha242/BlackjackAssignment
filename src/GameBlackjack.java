import java.util.Scanner;

public class GameBlackjack extends Game {

    private PlayerBlackjack dealer; // Declare the dealer variable

    public GameBlackjack(String name) {
        super(name);
        dealer = new PlayerBlackjack("Dealer");
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        GroupOfCards deck = new GroupOfCards(52);

        // Shuffle the deck before dealing
        deck.shuffle();

        // Create players and deal initial cards
        PlayerBlackjack player = new PlayerBlackjack("Player 1");
        dealer.initializeHand();
        player.initializeHand();

        // Deal initial cards
        player.addCardToHand((BlackjackCard) deck.dealCard());
        dealer.addCardToHand((BlackjackCard) deck.dealCard());
        player.addCardToHand((BlackjackCard) deck.dealCard());
        dealer.addCardToHand((BlackjackCard) deck.dealCard());

        // Player's turn
        System.out.println("Player " + player.getName() + "'s turn.");
        boolean playerDone = false;
        while (!playerDone) {
            System.out.println("Your hand: " + player.getHand());
            System.out.print("Would you like to hit or stand? ");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("hit")) {
                BlackjackCard newCard = (BlackjackCard) deck.dealCard();
                player.addCardToHand(newCard);
                int handValue = player.calculateHandValue();
                System.out.println("You drew a " + newCard);
                System.out.println("The value of your cards is: " + handValue);

                if (handValue > 21) {
                    System.out.println("Bust! You are over 21. Sorry.");
                    playerDone = true;
                }
            } else if (choice.equals("stand")) {
                playerDone = true;
            } else {
                System.out.println("Enter hit or stand, please.");
            }
        }

        // Dealer's turn
        System.out.println("Dealer's turn.");
        while (dealer.calculateHandValue() < 17) {
            dealer.addCardToHand((BlackjackCard) deck.dealCard());
        }

        // Determine and display the winner
        determineWinner(player, dealer);
    }

    @Override
    public void declareWinner() {
        // This method can be left empty for now
    }

    private void determineWinner(PlayerBlackjack player, PlayerBlackjack dealer) {
        // Implement logic to determine the winner and display the result
        int dealerHandValue = dealer.calculateHandValue();
        int playerHandValue = player.calculateHandValue();

        if (playerHandValue > 21) {
            System.out.println(player.getName() + " busts!");
        } else if (dealerHandValue > 21 || playerHandValue > dealerHandValue) {
            System.out.println(player.getName() + " wins!");
        } else if (dealerHandValue > playerHandValue) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie.");
        }
    }

    public static void main(String[] args) {
        GameBlackjack blackjackGame = new GameBlackjack("Blackjack Game");
        blackjackGame.play();
    }
}
