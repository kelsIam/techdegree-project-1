import java.util.Scanner;

class Prompter {
  private Scanner scanner;
  
  public Prompter(){
    //build the new Scanner object here!
    scanner = new Scanner(System.in);
  }
  
  String getItemName(){
    System.out.print("What type of item should fill the jar? ");
    return scanner.nextLine();
  }
  
  int getMaxNumItems() {
    System.out.print("What is the maximum amount of items? ");
    String input = scanner.nextLine();
    return Integer.parseInt(input);
  }
  
  //showRange before asking their guess
  void showRange(String itemName, int maxNum) {
     System.out.printf("How many %s are in the jar? Pick a number between 1 and %d.%n", itemName, maxNum);
  }
  
  int getGuess() {
    System.out.print("What is your guess? ");
    return Integer.parseInt(scanner.nextLine());
  }
  
  void announceWin(int numGuesses) {
    System.out.printf("You got it in %d attempts.%n", numGuesses);
  }
  
   void showLowMsg() {
    System.out.println("Sorry, that's too low!");
  }
  
   void showHighMsg() {
    System.out.println("Sorry, that's too high!");
  }
  
  void showOutOfBounds(int maxNum) {
    System.out.printf("Your guess must be less than %d.%n", maxNum);
  }
}