public class Payment{
  private String cardNo, name;
  private int expMonth, expYear;
  
  public Payment(String cardNo, String name, int expMonth, int expYear){
    this.cardNo = cardNo;
    this.name = name;
    this.expMonth = expMonth;
    this.expYear = expYear;
  }
  
  //Accessors
  /** @return Return the credit card number of consumer. */ 
  public String getCardNo(){ return cardNo; }
  /** @return Return the name of the consumer. */ 
  public String getName(){ return name; }
  /** @return Return the expiration month. */ 
  public int getExpMonth(){ return expMonth; }
  /** @return Return the expiration year */ 
  public int getExpYear(){ return expYear; }
  
  @Override public String toString(){
    return String.format("#%s (%s), exp %d/%d", cardNo, name, expMonth, expYear);
  }
}