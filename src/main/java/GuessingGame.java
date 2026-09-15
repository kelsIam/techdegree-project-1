
public class GuessingGame {
    public static void main(String[] args) {
//      //Create a Scanner object wrapped around System.in to read user input.
//      Scanner scanner = new Scanner(System.in);
//      //Use System.out.println() or System.out.print() for all output to the console.      
//      
//      String userItemName;
//      int userItemNum;
//      
//      System.out.println("What type of item should fill the jar?");
//      userItemName = scanner.nextLine();
//      
//      System.out.printf("What is the maximum amount of %s?%n", userItemName); //println does not do placeholders, use printf instead
//      userItemNum = Integer.parseInt(scanner.nextLine());
      
      //I/O
      Prompter prompter = new Prompter();
      String userItemName;
      int userItemNum;
      userItemName = prompter.getItemName();
      userItemNum = prompter.getMaxNumItems();
      
      //create a new Jar object using the collected info
      Jar jar = new Jar(userItemName, userItemNum);
      
      //fill the jar
      jar.fill(userItemNum);
      
      //display the max num of items possible (that player set before) with item type and range
      //example: "How many jellybeans are in the jar? Pick a number between 1 and 1500."
      //System.out.printf("How many %s are in the jar? Pick a number between 1 and %d.%n", jar.getItem(), jar.getMaxNumItems());
      prompter.showRange(userItemName, userItemNum);
      
      //while loop
      //keep track of number of guesses -- counter variable
      int numGuesses = 0; //Java requires a variable be assigned before you can add to it
      while (true) { //what is true here? is this right?
        //prompt player for a guess
        //System.out.println("What is your guess?");
        //int answer = Integer.parseInt(scanner.nextLine());
        int answer = prompter.getGuess();
        //compare to actual number
        if (answer == jar.getCurrentNumItems()) {
          //if correct, break loop
          numGuesses+=1;
          //display number of guesses to player
          //System.out.printf("You got it in %d attempts.%n", numGuesses);
          prompter.announceWin(numGuesses);
          break;
        } else if (answer < jar.getCurrentNumItems()) {
          //if not, tell them, continue the loop
          //System.out.println("Sorry, that's too low!");
          prompter.showLowMsg();
          numGuesses+=1;
          continue;
        } else if (answer > jar.getCurrentNumItems() && answer > jar.getMaxNumItems()) {
          int maxNum = jar.getMaxNumItems();
          prompter.showOutOfBounds(maxNum);
          continue;
        } else if (answer > jar.getCurrentNumItems()) {
          //System.out.println("Sorry, that's too high!");
          prompter.showHighMsg();
          numGuesses+=1;
          continue;
        }
      }
    }
}
