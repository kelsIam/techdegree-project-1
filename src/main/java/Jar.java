import java.util.Random;

class Jar {
  private String item;
  private int maxNumItems;
  private int currentNumItems;
  
  public Jar(String item, int maxNumItems){
    this.item = item;
    this.maxNumItems = maxNumItems;
  }
  
  String getItem(){
    return item;
  }
  
  int getMaxNumItems() {
    return maxNumItems;
  }
  
  //fill method using Random class, 1 - max
  public void fill(int maxNumItems){
    Random random = new Random();
    int maxItems = maxNumItems;
    int randomNumber = random.nextInt(maxItems) + 1;
    currentNumItems = randomNumber;
  }
  
  //getter method for the current number of items
  int getCurrentNumItems() {
    return currentNumItems;
  }
}