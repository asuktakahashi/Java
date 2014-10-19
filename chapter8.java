public enum Suit{
  Club(0), Diamond(1), Heart(2), Spade(3);
  private int value;
  private Suit(int v){ value = v; }
  public int getVallue() {return value; }
  public static Suit getSuitFromValue(int value){ ... }

}

publicd class Deck <T extends Card>{
  private ArrayList<T> cards;
  private int dealtIndex = 0;
  
  public void setDeckOfCards(ArrayList<T> deckOfCards) { ... }
  
  public void shuffle(){ ... }
  public int remainingCards(){
    return cards.size() - dealtIndex;
  }


}

