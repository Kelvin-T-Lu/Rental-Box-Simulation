import java.time.*;
/** A rental object with a daily fee */ 
public class DailyRental extends Rental{
  private double credit; 
  public DailyRental(Media media, Payment payment, LocalDate today, double fee, double credit){
    super(media, payment, today, fee);
    this.credit = credit;
  }
  public DailyRental(Media media, Payment payment, LocalDate today, double fee){
    this(media, payment, today, fee, 0.0);
  }
  /** @return Returns the number of consumer discounted credit */ 
  public double getCredit(){ return credit; }
  
  @Override public double getTotalFee(LocalDate today){
    int x = daysRented(today);
    //If return on same day, treats as one day rental 
    if(x== 0){ x++;}
    double y = getFee() * x - credit;
    if(y < 0)
      return 0;
    return y; 
  }
}