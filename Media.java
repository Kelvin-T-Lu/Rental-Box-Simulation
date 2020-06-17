/** A media object */ 
public class Media{
  private String name;
  private int year;
  
  public Media(String name, int year){
    setName(name);
    setYear(year);
  }
  /** @return Return the name of the media */ 
  public String getName(){ return name; }
  /** @return Return the publishing year of media */ 
  public int getYear(){ return year;  }
  
  /** @param name Sets the name of media object */ 
  public void setName(String name){ this.name = name; }
  /** @param year Sets the publishing year of the media object */ 
  public void setYear(int year){ this.year = year; }
  
  /** @param other Returns if the media object is equal */ 
  @Override public boolean equals(Object other){
    Media temp; 
    if(other instanceof Media){
      temp = (Media) other;
    }
    else 
      return false; 
 
    return (temp.getName().equals(name) && temp.getYear()==year);
  }
  @Override  public int hashCode(){
    return getName().hashCode();
  }
  @Override  public String toString(){
    return String.format("%s (%d)", name, year);
  }
}