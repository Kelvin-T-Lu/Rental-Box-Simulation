public class Game extends Media{
  private String  platform, rating;
  private int discs;
  private boolean online;
  
  public Game(String name, int year, String platform, String rating, int discs, boolean online){
    super(name, year);
    this.platform = platform;
    this.rating = rating; 
    this.discs = discs;
    this.online = online;
  }
  
  //Accessors
  /** @return Return the playing platform of the game */ 
  public String getPlatform(){ return platform;}
  /** @return Return the rating of the game */ 
  public String getRating() {return rating; }
  /** @return Return the number of discs inside the game object */ 
  public int getDiscs() { return discs; }
  /** @return Return if the game could be accessed online. */ 
  public boolean isOnline() { return online; }
  
  //toString
  @Override  public String toString(){
    if(online)      
      return String.format("%s (%d) %s [%s, %d discs, online]", getName(), getYear(), platform, rating, discs);
    else
      return String.format("%s (%d) %s [%s, %d discs]", getName(), getYear(), platform, rating, discs); 
  }
}