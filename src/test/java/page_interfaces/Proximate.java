package page_interfaces;

public interface Proximate {
  
  public void searchLocation(Boolean qa, String location) throws InterruptedException;

  public void searchLocationWCharacters() throws InterruptedException;

  public void searchLocationbyZipcode() throws InterruptedException;

  public void selectTestLocation(String location) throws InterruptedException;

  public void recentSpots() throws InterruptedException;

  public void searchInvalidSpotCurrentLocation(String location) throws InterruptedException;

  public void searchInvalidSpotAllSpots(String location) throws InterruptedException;

  public void recentTabasGuest() throws InterruptedException;

  public void favoritesTabasGuest() throws InterruptedException;
  
}