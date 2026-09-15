
public class GuessingGame {
    public static void main(String[] args) {
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
      
      //display the max num of items possible with item type and range
      prompter.showRange(userItemName, userItemNum);
      
      //while loop with counter var
      int numGuesses = 0;
      while (true) { 
        int answer = prompter.getGuess();
        if (answer == jar.getCurrentNumItems()) {
          numGuesses+=1;
          prompter.announceWin(numGuesses);
          break;
        } else if (answer < jar.getCurrentNumItems()) {
          prompter.showLowMsg();
          numGuesses+=1;
          continue;
        } else if (answer > jar.getCurrentNumItems() && answer > jar.getMaxNumItems()) {
          int maxNum = jar.getMaxNumItems();
          prompter.showOutOfBounds(maxNum);
          continue;
        } else if (answer > jar.getCurrentNumItems()) {
          prompter.showHighMsg();
          numGuesses+=1;
          continue;
        }
      }
    }
}
