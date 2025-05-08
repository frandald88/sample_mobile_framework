package page_interfaces;

public interface AddTicket {
  
  public void checkIfTicketAvailableAndAdd() throws InterruptedException;

  public void checkAndAddAdditonalTicket() throws InterruptedException;
  
  public void tokenTicketLessNumbers() throws InterruptedException;

  public void tokenTicketInvalidExpDate() throws InterruptedException;

  public void tokenTicketInvalidCCV() throws InterruptedException;

  public void tokenTicketInvalidNumbers() throws InterruptedException;

  public void tokenTicketInvalidZipCode() throws InterruptedException;

  public void tokenTicketButtonSaveDisabled() throws InterruptedException;
  
  public void switchSavedTickets() throws InterruptedException;
  

}