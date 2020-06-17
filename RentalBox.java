import java.time.*;

/** A rental box with a storage with media and process Rental transaction */ 
public class RentalBox{
 
  private Media[] storage;
  
  //Constructors
  public RentalBox(int capacity){
    storage = new Media[capacity];
  }
  public RentalBox(){
    this(100);
  }
  
  //Getters methods
  /** @return Return the capacity of the storage */ 
  public int boxCapacity(){ return storage.length; }
  /** @param i Returns the media object at the storage index */ 
  public Media get(int i){ return storage[i]; }
  
  /** @param m Checks if m object is in storage */ 
  public boolean inStock(Media m){
    for(Media x : storage){//Finds if each Media in storage contents matches
      if(x.equals(m))
        return true;
    }
    return false; 
  }
  
  /** @param m Places Media m inside storage */ 
  public boolean put(Media m){
    for(int i = 0; i<storage.length; i++){
      if(storage[i] == null){//Searches for first empty storage index 
        storage[i] = m; //Assigns empty index with m and breaks 
        return true;
      }
    }
    return false;
  }
  
  /** @return Processes a rental transaction */ 
  public Rental rent(Media m, Payment p, LocalDate d){
    if(inStock(m)){  //If in stock, finds the stock and removes it
      for(int i = storage.length-1; i> 0; i--){
        if(storage[i].equals(m)){
          storage[i] = null; 
          return new DailyRental(get(i), p, d, getDailyFee(get(i)));
        }
      }
    }
    return null;
    
  }
  
  /** Display consumer's payment method */ 
  public void processPayment(Payment p, double amount){
    //Prints payment method
    System.out.printf("$%.2f paid by %s\n", amount, p.toString());
  }
  
  /** @return Returns a media rental object and processes payment and fee, if possible */ 
  public boolean dropoff(Rental r, LocalDate today){
    if(put(r.getMedia())){
      r.dropoff(today); 
      processPayment(r.getPayment(), r.getTotalFee(today));
      return true;
    }
    return false; 
  }
  
  /** Returns the daily fee of media */ 
  public double getDailyFee(Media m){
    if(m instanceof Video){ //Checks if m is a Video 
      Video temp = (Video) m;
      //Returns the fee for its respective format
      if(temp.getFormat()== 0){ return 1.50; } 
      else if(temp.getFormat()== 1){ return 2.00; }
    }
    else if(m instanceof Game){ return 3.00; }
    
    return 0.00; 
  }
  
  /** @return Return the contents of the rental box's storage. */ 
  @Override public String toString(){
    String f = ""; 
    
    for(Media m : storage){
      if(m == null){ continue; } 
      if(m instanceof Video){
        m = (Video) m; 
      }
      if(m instanceof Game){
        m = (Game) m;
      }
      f+= m.toString() + "\n";
    }
    return f; 
  }
  
}