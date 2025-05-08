package page_interfaces;

public interface Statement {
  
  public void logout() throws InterruptedException;

  public void darkMode() throws InterruptedException;

  public void help() throws InterruptedException;

  public void termsOfService() throws InterruptedException;

  public void privacyPolicy() throws InterruptedException;

  public void settingsMenu() throws InterruptedException;

  public void settingsMenuDarkMode() throws InterruptedException;

  public void settingsMenuConfirmPurchase() throws InterruptedException;

  public void settingsMenuPurchaseRecash() throws InterruptedException;
  
  public void settingsMenuLocationWelcome() throws InterruptedException;

  public void settingsMenuAvailableCashTokens() throws InterruptedException;

  public void settingsMenuAutoReloadFailure() throws InterruptedException;

  public void settingsMenuReferAFriendReferrer() throws InterruptedException;

  public void settingsMenuReferAFriendReferred() throws InterruptedException;

  public void settingsMenuConfirmPurchaseToggle() throws InterruptedException;

  public void settingsMenuPurchaseRecashToggle() throws InterruptedException;
  
  public void settingsMenuLocationWelcomeToggle() throws InterruptedException;

  public void settingsMenuAvailableCashTokensToggle() throws InterruptedException;

  public void settingsMenuAutoReloadFailureToggle() throws InterruptedException;

  public void settingsMenuReferAFriendReferrerToggle() throws InterruptedException;

  public void settingsMenuReferAFriendReferredToggle() throws InterruptedException;

  public void referAFriend() throws InterruptedException;

  public void referAFriendQRCodeGenerated() throws InterruptedException;

  public void referAFriendNewTab() throws InterruptedException;

  public void referAFriendPendingTab() throws InterruptedException;

  public void referAFriendSuccessfulTab() throws InterruptedException;

  public void referAFriendShareLink() throws InterruptedException;

  public void confirmPurchaseON() throws InterruptedException;

  public void transactionHistoryUpdateAddCashSixDollars() throws InterruptedException;

  public void transactionHistoryUpdateAddCash24Dollars() throws InterruptedException;

  public void transactionHistoryUpdateAddCash12Dollars() throws InterruptedException;

  public void ManageStatement() throws InterruptedException;

  public void updateEmail(String password) throws InterruptedException;

  public void updateEmailCancel(String password) throws InterruptedException;

  public void restoreEmail(String password) throws InterruptedException;

  public void changeUsername(String password, String username) throws InterruptedException;

  public void changePassword(String password, String username) throws InterruptedException;

  public void changePasswordCancel(String password, String username) throws InterruptedException;

  public void changePasswordShowPassword(String password, String username) throws InterruptedException;

  public void restorePassword(String password, String username) throws InterruptedException;

  public void changePasswordBlank() throws InterruptedException;

  public void changePasswordMore20(String password, String username) throws InterruptedException;

  public void changePassword20(String password, String username) throws InterruptedException;

  public void transactionHistoryUpdateAddTrack() throws InterruptedException;

  public void transactionHistoryUpdateAddTrackMenu() throws InterruptedException;

  public void transactionHistoryAddTracktoMyTracks() throws InterruptedException;

  public void transactionHistoryRemoveTracktoMyTracks() throws InterruptedException;

  public void transactionHistoryAddTracktoMyTracklist() throws InterruptedException;

  public void transactionHistoryAddTracktoExistingTracklist() throws InterruptedException;

  public void transactionHistoryPlayTrackPriority() throws InterruptedException;

  public void transactionHistoryPlayTrackPriorityCancel() throws InterruptedException;

  public void transactionHistoryPlayTrack() throws InterruptedException;

  public void transactionHistoryPlayTrackCancel() throws InterruptedException;

  public void transactionHistoryPlayingTrackStatusPlaying() throws InterruptedException;

  public void transactionHistoryPlayingTrackStatusPlayed() throws InterruptedException;

  public void transactionHistoryPlayingTrackStatusQueued() throws InterruptedException;

  public void myStatementasGuest() throws InterruptedException;

  public void redeemTapHere() throws InterruptedException;

  public void redeemInvalidPromotion() throws InterruptedException;

  public void redeemEmptyPromotion() throws InterruptedException;

  public void redeemPub() throws InterruptedException;

  public void swtchOffAutoReload() throws InterruptedException;

  public void swtchOnAutoReload() throws InterruptedException;

}