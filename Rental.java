import java.time.*;
/** A rental transaction */ 
public class Rental{
  private Media media;
  private Payment pay;
  private LocalDate firstDate, secondDate; //First date = day that was rented out, second = return date
  private double fee;
  private boolean isRented = true;
  
  public Rental(Media media, Payment payment, LocalDate today, double fee){
    this.media = media;
    this.pay = payment;
    this.firstDate = today;
    this.fee = fee;
  }
  
  //Getters
  /** @return Return the media being rented. */ 
  public Media getMedia(){ return media;  }
  /** @return Return the payment of the consumer */ 
  public Payment getPayment(){ return pay; } 
  /** @return Return the date of the rental object */ 
  public LocalDate getRentDate(){ return firstDate; }
  /** @return Return the rental date of the object */ 
  public LocalDate getReturnDate(){ return secondDate; }
  /** @return Return the fee of the rental transaction */ 
  public double getFee(){ return fee; }
  /** @return Return if the object is returned */ 
  public boolean isRented(){ return isRented; }
  
  /** First call - Returns media object Subsequential Call- Nothing 
    * @return Return the total transaction fee */ 
  public double dropoff(LocalDate today){
    if(isRented){ //If the rental is being returned
      isRented = false; //Signals returned
      secondDate = today; //Sets the return date
    }
      return getTotalFee(secondDate);
  }
  
  /** @return Returns the number of the days rented */ 
  public int daysRented(LocalDate today){
    //If returned, returns days between first and Second Date
    //Else returns days between the first rental date and today
    if(!isRented)
      return Period.between(firstDate, secondDate).getDays();
    else
      return Period.between(firstDate, today).getDays();
  }
  
  /** @return Return the total fee transaction */ 
  public double getTotalFee(LocalDate today){
    return fee; 
  }
  
  public String toString(){
    return String.format("%s, rented on %s using %s", media, firstDate, pay);
  }
}