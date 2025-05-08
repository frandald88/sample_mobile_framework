package page_interfaces;

public interface Spot {

  public void homePageUI() throws InterruptedException;

  public void homePageTabsUI() throws InterruptedException;

  public void addTrack(String type) throws InterruptedException;

  public void removeTrack() throws InterruptedException;

  public void searchTrack(String track, String location) throws InterruptedException;
  
  public void playTrackPriorityTokens(String track) throws InterruptedException;

  public void playTrackPriorityNoTokens(String track) throws InterruptedException;

  public void playTrack(String track) throws InterruptedException;

  //public void playSameTrack(String track) throws InterruptedException;

  public void playTrackFromSpotHomeScreen(String track) throws InterruptedException;

  public void play2Tracks(String track) throws InterruptedException;

  public void play5Tracks(String track) throws InterruptedException;

  public void favoriteSpot(Boolean logged) throws InterruptedException;

  public void addTokens(Boolean recharge) throws InterruptedException;

  public void autoReload(Boolean toggle) throws InterruptedException;

  public void viewArtist(String artirst) throws InterruptedException;

  public void addCashTokenTicketSixDollars() throws InterruptedException;

  public void addCashTokenTicket24Dollars() throws InterruptedException;

  public void addCashTokenTicket12Dollars() throws InterruptedException;

  public void tokensCleanUp() throws InterruptedException;

  public void tokensCleanUpRateDialog() throws InterruptedException;

  public void deleteTracklist() throws InterruptedException;

  public void createTracklist() throws InterruptedException;

  public void Add3TracksToMyTracks(String track) throws InterruptedException;

  public void removeFirstMyTracks() throws InterruptedException;

  public void myTracksSortByArtist() throws InterruptedException;

  public void myTracksSortByTrack() throws InterruptedException;

  public void myTracksSortByPopularity() throws InterruptedException;

  public void myTracksSortByDate() throws InterruptedException;

  public void myTracksMultiTrackSelection() throws InterruptedException;

  public void myTracksMultiTrackAllTracks() throws InterruptedException;

  public void myTracksMultiTrackDeselectAllTracks() throws InterruptedException;

  public void myTracksMultiTrackSelectionNumbered() throws InterruptedException;

  public void Add3TracksToTracklist(String track) throws InterruptedException;

  public void tracklistSortByArtist() throws InterruptedException;

  public void tracklistSortByTrack() throws InterruptedException;

  public void tracklistSortByPopularity() throws InterruptedException;

  public void tracklistSortByTrackOrder() throws InterruptedException;

  public void myMusicRenameTracklist() throws InterruptedException;

  public void tracklistMultiTrackSelection() throws InterruptedException;

  public void tracklistMultiTrackDeselection() throws InterruptedException;

  public void tracklistMultiTrackAllTracks() throws InterruptedException;

  public void tracklistMultiTrackDeselectAllTracks() throws InterruptedException;

  public void noFavorites() throws InterruptedException;

  public void favoriteSpotListedinHome() throws InterruptedException;

  public void emptyTracklist() throws InterruptedException;

  public void spotsDropDownList() throws InterruptedException;

  public void NowPlayingAddTracktoTracklist() throws InterruptedException;

  public void NowPlayingAddTracktoMyMusic() throws InterruptedException;

  public void NowPlayingViewThisArtist() throws InterruptedException;

  public void allMusicSelectSpot() throws InterruptedException;

  public void myMusicSelectSpot() throws InterruptedException;

  public void addCashSelectSpot() throws InterruptedException;

  public void myMusicTracklistSelectSpot() throws InterruptedException;

  public void addToTracklistFromTracklist() throws InterruptedException;

  public void searchTrackAsGuest(String track) throws InterruptedException;

  public void playTrackAsGuest(String track) throws InterruptedException;

  public void playTrackAsGuestFromArtists_Album(String track) throws InterruptedException;

  public void playTrackAsGuestFromArtists_Tracks(String track) throws InterruptedException;

  public void playTrackAsGuestFromAlbum_Track(String track) throws InterruptedException;

  public void playTrackAsGuestHotTrack() throws InterruptedException;

  public void playTrackAsGuestHotArtists() throws InterruptedException;

  public void playTrackAsGuestHotArtistsAlbum_Track() throws InterruptedException;

  public void guestNotAccessToMyMusic() throws InterruptedException;

  public void guestNotAccessToAddCash() throws InterruptedException;

  public void searchNonExistingArtistWSpecialCharacters(String artist) throws InterruptedException;

  public void addCashInvalidCvc() throws InterruptedException;

  public void addCashSaveforFutureButton() throws InterruptedException;

  public void addCashExceedBalance() throws InterruptedException;

  public void addCashButtonReloadCheck() throws InterruptedException;

  public void tracklistNameError() throws InterruptedException;

  public void tracklistwithSpecialCharacter() throws InterruptedException;

  public void successfulTracklist() throws InterruptedException;

  public void removeAllMyTracks() throws InterruptedException;
  
  public void deleteAllTracklist() throws InterruptedException;

  public void backToHomeSpot() throws InterruptedException;  
}