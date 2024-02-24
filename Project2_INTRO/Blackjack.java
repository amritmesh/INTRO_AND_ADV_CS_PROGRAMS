import java.util.Scanner;

/**
 * An object of type Card represents a card from a deck.The card 
 * has a suit (Spades, Hearts, Diamonds, Clubs). Each suit has one 
 * of 13 values (2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, or King).
 * The ace value can represent 1 or 11 depending on user input.
 */
class Card
{
    // Card's suit: Spades, Hearts, Diamonds, or Clubs
    private final String suit; 

    // Card's face value: value printed on card
    private final String faceValue;

    // Card's value: numeric value of card
    private int numValue;

    public Card(String suit, String faceValue, int numValue) 
    {
        this.suit = suit;
        this.faceValue = faceValue;
        this.numValue = numValue;
    }

    public String getSuit() 
    {
        return this.suit;
    }

    public String getFaceValue()
    {
        return this.faceValue;
    }

    public int getNumValue() 
    {
        return this.numValue;
    }

    public void setNumValue(int numValue)
    {
        this.numValue = numValue;
    }

    public String toString() 
    {
        return getFaceValue() + "-" + getSuit();
    }
}

class Deck 
{
    // An array representing the suits of each card
    private String[] suit = {"S", "D", "H", "C"};

    // An array of cards.
    private Card[] deck = new Card[52];

    private int cardsUsed = 0;

    public Deck()
    {
        int counter = 0;
        for(int i = 0; i < suit.length; i++)
        {
            Card two = new Card(suit[i], "2", 2);
            deck[counter] = two;
            counter++;

            Card three = new Card(suit[i], "3", 3);
            deck[counter] = three;
            counter++;

            Card four = new Card(suit[i], "4", 4);
            deck[counter] = four;
            counter++;

            Card five = new Card(suit[i], "5", 5);
            deck[counter] = five;
            counter++;

            Card six = new Card(suit[i], "6", 6);
            deck[counter] = six;
            counter++;

            Card seven = new Card(suit[i], "7", 7);
            deck[counter] = seven;
            counter++;

            Card eight = new Card(suit[i], "8", 8);
            deck[counter] = eight;
            counter++;

            Card nine = new Card(suit[i], "9", 9);
            deck[counter] = nine;
            counter++;

            Card ten = new Card(suit[i], "10", 10);
            deck[counter] = ten;
            counter++;

            Card jack = new Card(suit[i], "J", 10);
            deck[counter] = jack;
            counter++;

            Card queen = new Card(suit[i], "Q", 10);
            deck[counter] = queen;
            counter++;

            Card king = new Card(suit[i], "K", 10);
            deck[counter] = king;
            counter++;

            Card ace = new Card(suit[i], "A", 11);
            deck[counter] = ace;
            counter++;  
        }
    }

    // shuffle deck
    public void shuffle()
    {
        for ( int i = deck.length-1; i > 0; i-- ) 
        {
            int randomVal = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[randomVal];
            deck[randomVal] = temp;
        }
    }

    /**
     * get last card in the shuffled deck - if all cards in deck are used,
     * deck is once again reshuffled.
     */
    public Card getTopCard()
    {
        if(((deck.length - 1) - cardsUsed) < 0)
        {
            shuffle();
            cardsUsed = 0;
        }
        Card lastCard = deck[(deck.length - 1) - cardsUsed];
        cardsUsed++;

        return lastCard;
    }
}

public class Blackjack 
{
    public static void main(String[] args)
    {
        // this loop continues as long as the player wishes to play a round
        while(true)
        {
            System.out.println();
            System.out.println("---------- NEW GAME STARTS ----------");
            System.out.println();

            Scanner input = new Scanner(System.in);

            Card[] playerHand = new Card[52];
            Card[] dealerHand = new Card[52];
            Deck deck;                       // create a new deck

            int finalPlayerSum = 0;
            int finalDealerSum = 0;
            int playerCardCnt = 0;
            int dealerCardCnt = 0;
            
            System.out.print("Do you want to play a round of Blackjack (Y/N): ");
            char toPlay = input.next().charAt(0);

            // player does not want to continue, so exit
            if(toPlay == 'N')
            {
                break;
            }

            deck = new Deck();          // create a new "deck" object
            deck.shuffle();             // shuffle the deck

            // deal two cards to the player
            for(int i = 0; i < 2; i++)
            {
                playerHand[i] = deck.getTopCard();
                playerCardCnt++;
            }

            // deal two cards to the dealer
            for(int i = 0; i < 2; i++)
            {
                dealerHand[i] = deck.getTopCard();
                dealerCardCnt++;
            }
            
            int playerSum = 0;

            // compute player total
            for(int i = 0; i < 2; i++)
            {
                playerSum += playerHand[i].getNumValue();
                finalPlayerSum = playerSum;
            }

            // if player total is 21, he wins
            if(finalPlayerSum == 21)
            {
                System.out.println("Player has " + playerHand[0].toString() + " and " + playerHand[1].toString());
                System.out.println("Player has Blackjack. Player wins. The score is " + finalDealerSum + "-" + finalPlayerSum);
                continue;
            }
            // if player total goes over 21, he loses
            else if(finalPlayerSum > 21)
            {
                System.out.println();
                System.out.println("Player's score has gone over 21. Player loses. The score is " + finalDealerSum + "-" + finalPlayerSum);
                System.out.println("Your cards are " + playerHand[0].toString() + " and " + playerHand[1].toString());
                continue;
            }

            int dealerSum = 0;

            // compute total for dealer
            for(int i = 0; i < 2; i++)
            {
                dealerSum += dealerHand[i].getNumValue();
                finalDealerSum = dealerSum;
            }

            // if dealer total equals 21, he wins
            if(finalDealerSum == 21)
            {
                System.out.println("Dealer has " + dealerHand[0].toString() + " and " + dealerHand[1].toString());
                System.out.println("Dealer has Blackjack. Dealer wins. The score is " + finalDealerSum + "-" + finalPlayerSum);
                continue;
            }

            // if dealer total goes over 21, he loses
            else if(finalDealerSum > 21)
            {
                System.out.println();
                System.out.println("Dealer's score has gone over 21. You lose. The score is " + finalDealerSum + "-" + finalPlayerSum);
                System.out.println("The dealer's cards are " + dealerHand[0].toString() + " and " + dealerHand[1].toString());
                continue;
            }

            /**this loop continues as long as player and dealer decide to keep
             * on HIT
            */
            while(true)
            {
                // player turn
                while(true)
                {
                    System.out.println();
                    System.out.println();
                    System.out.println("Player's cards are: ");

                    // display player cards
                    for(int i = 0; i < playerCardCnt; i++)
                    {
                        System.out.println(playerHand[i].toString());
                    }

                    // display player score
                    System.out.print("Player's score is: " + finalPlayerSum);
                    System.out.println();

                    // capture player input action HIT or STAY
                    System.out.println("Dealer is showing " + dealerHand[dealerCardCnt - 1].toString());
                    System.out.println();
                    System.out.print("Hit (H) or Stay (S): ");

                    char playerAction = input.next().charAt(0);

                    // if player decides to STAY, get out of loop
                    if(playerAction == 'S')
                    {
                        break;
                    }
                    // if player decides to HIT[continue], just continue
                    else
                    {
                        // deal new card to player and update card count, list of cards in array
                        Card newCard = deck.getTopCard();
                        playerCardCnt++;
                        playerHand[playerCardCnt - 1] = newCard;
                        System.out.println();
                        System.out.println("Player hits.");
                        System.out.println("Player's card is " + newCard);

                        // update player total
                        finalPlayerSum += newCard.getNumValue();
                        System.out.println("Player's score is now " + (finalPlayerSum));

                        // if player hits 21, he wins and breaks out of loop
                        if(finalPlayerSum == 21)
                        {
                            System.out.println("Player has: ");
                            for(int i = 0; i < playerCardCnt; i++)
                            {
                                System.out.println(playerHand[i].toString() + ",");
                            }
                            System.out.println("Player has Blackjack. Player wins. The score is " + finalDealerSum + "-" + finalPlayerSum);
                            break;
                        }

                        // if player total goes over 21, he loses and breaks out of loop
                        if(finalPlayerSum > 21)
                        {
                            System.out.println();
                            System.out.println("Player has: ");
                            for(int i = 0; i < playerCardCnt; i++)
                            {
                                System.out.println(playerHand[i].toString() + ",");
                            }
                            System.out.println("Player score has gone over 21. Player loses. The score is " + finalDealerSum + "-" + finalPlayerSum);
                            break;
                        }
                    }
                }

                // if player total equals 21 or above, start fresh game from main while loop
                if(finalPlayerSum == 21 || finalPlayerSum > 21)
                {
                    break;
                }

                // dealer turn
                while(true)
                {
                    //display dealer cards
                    System.out.println();
                    System.out.println();
                    System.out.println("Player stands.");
                    System.out.println("Dealer's cards are ");

                    for(int i = 0; i < dealerCardCnt; i++)
                    {
                        System.out.println(dealerHand[i].toString());
                    }

                    System.out.print("Dealer's score before hit: " + finalDealerSum);
                    System.out.println();

                    /**
                     * if dealer total is equal to or greater than 17, break out of loop,
                     * compare player and dealer totals and decide winner and loser
                     */
                    if(finalDealerSum >= 17)
                    {
                        break;
                    }

                    /**
                     * deal a new card is dealer total is less than 17, and update dealer total,
                     * and list of dealer's cards
                     */
                    Card newCard = deck.getTopCard();
                    System.out.println("Dealer hits and gets " + newCard);
                    finalDealerSum += newCard.getNumValue();

                    System.out.print("Dealer's score after hit is: " + finalDealerSum);
                    System.out.println();
                     
                    // update dealer card count, and dealer cards
                    dealerCardCnt++;
                    dealerHand[dealerCardCnt - 1] = newCard;

                    /**
                     * if dealer total is greater than or equal to 17, get out of loop, 
                     * to decide the winner and loser
                     */
                    if(finalDealerSum >= 17)
                    {
                        break;
                    }
                }

                /**
                 * if dealer total is between 17 and 21 (17 inclusive)...
                 */
                if(finalDealerSum >= 17 && finalDealerSum < 21)
                {
                    System.out.println();
                    
                    /**
                     * if dealer total and player total are equal, the game ends as a tie
                     * and a fresh game is started
                     */
                    if(finalDealerSum == finalPlayerSum)
                    {
                        System.out.println("It's a tie. The score is " + finalDealerSum + "-" + finalPlayerSum);
                        break;
                    }

                    /** 
                     * if dealer total is greater player total, dealer wins and 
                     * a fresh game is started
                    */
                    else if(finalDealerSum > finalPlayerSum)
                    {
                        System.out.println("Dealer wins. The score is " + finalDealerSum + "-" + finalPlayerSum);
                        break;
                    }

                    /**
                     * if player total is greater than dealer total, player wins
                     * and a fresh game is started
                     */
                    else
                    {
                        System.out.println("Player wins. The score is " + finalPlayerSum + "-" + finalDealerSum);
                        break;
                    }
                }

                /**
                 * check if dealer total is equal to 21 - if so, dealer wins, 
                 * and a fresh game is started
                 */
                if(finalDealerSum == 21)
                {
                    System.out.println("Dealer wins. The score is " + finalDealerSum + "-" + finalPlayerSum);
                    break;
                }
                /**
                 * check if dealer total is greater than 21 - if so, dealer loses,
                 * and a fresh game is started
                 */
                if(finalDealerSum > 21)
                {
                    System.out.println("Dealer loses. Dealer score has gone over 21. The score is " + finalPlayerSum + "-" + finalDealerSum);
                    break;
                }
            }
        }
    }
}