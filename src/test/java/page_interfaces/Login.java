package page_interfaces;

public interface Login {
  // login Prod
  public void login(Boolean qa, String email, String password) throws InterruptedException;

  public void setQAEnv() throws InterruptedException;

  //public void setQAEnvWhile() throws InterruptedException;
  
  public void createStatement(String email, String password) throws InterruptedException;

  public void createStatementInvalidPsw(String email, String password) throws InterruptedException;

  public void loginAgain(String email, String password) throws InterruptedException;

  public void loginAgainFail(String email, String password) throws InterruptedException;
  
  public void forgotPassword(String email) throws InterruptedException;

  public void loginBlank(String email) throws InterruptedException;

  public void loginSpaces(String email, String password) throws InterruptedException;

  public void revealPassword(String email, String password) throws InterruptedException;

  public void setMoneyBagBalance() throws InterruptedException;
}
