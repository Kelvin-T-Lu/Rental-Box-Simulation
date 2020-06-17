/** A video media object */ 
public class Video extends Media{
  public static final int DVD = 0;
  public static final int BLURAY = 1;
  private String rating;
  private int runtime, format;
  
  //Constructor
  public Video(String name, int year, int runtime, String rating, int format){
    super(name, year);
    this.runtime = runtime; 
    this.rating = rating; 
    this.format = format;
  }
  //Accessors
  
  /** @return Return the run time of Video */ 
  public int getRuntime(){ return runtime; }
  /** @return Return the rating of Video */ 
  public String getRating(){ return rating;}
  /** @return Return the format of the Video */ 
  public int getFormat(){ return format;}
  
  //toString
  @Override
  public String toString(){
    String temp = "";
    if(format == DVD){
      temp += "DVD";
    }
    else if(format == BLURAY){
      temp += "BLURAY";
    }
    return String.format("%s (%d) %s [%s, %d min]", super.getName(), super.getYear(), temp, rating, runtime); 
  }
  
}