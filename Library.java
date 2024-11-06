import java.util.Hashtable;

/**
 * Represents the Library class
 */
public class Library extends Building {

  // Attributes

  private Hashtable<String, Boolean> collection;
  boolean hasElevator;

  // Constructors

  /**
   * Constructor for the Library class
   * @param name a Library's name
   * @param address a Library's address
   * @param nFloors the number of stories inside a Library
   * @param collection a Library's collection in which
   *                   each item has a name and whether it is available for check out
   * @param hasElevator whether or not a Library has an elevator
   */
  public Library(String name, String address, int nFloors, Hashtable<String, Boolean> collection, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = collection;
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * Constructor for the Library class with an empty collection by default
   * @param name a Library's name
   * @param address a Library's address
   * @param nFloors the number of stories inside a Library
   * @param hasElevator whether or not a Library has an elevator
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library with an empty collection: 📖");
  }

  // Accessors

  /**
   * Returns a boolean based on whether a Library has an elevator
   * @return true if a Library has an elevator
   */
  public boolean hasElevator() {
    return hasElevator;
  }

  /**
   * Returns a boolean based on whether an item is in a Library's collection
   * @param title the desired item's title
   * @return true if the item is in the collection
   */
  public boolean containsTitle(String title) {
    return (collection.containsKey(title));
  }

  /**
   * Returns a boolean based on whether an item in a Library's collection is available for check out
   * @param title the desired item's title
   * @return true if the item is in the collection and available
   */
  public boolean isAvailable(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException(title + " isn't in the library's collection.");
    }
    return (collection.get(title)).equals(true);
  }

  // Methods

  /**
   * Adds a title to a Library's collection, provided it is not already there
   * @param title the title to be added
   */
  public void addTitle(String title) {
    if (containsTitle(title)) {
      System.out.println(title + " is already in the library's collection.");
    } else {
      System.out.println(title + " has been added to the library's collection.");
      collection.put(title, true);
    }
  }

  /**
   * Adds a title to a Library's collection, provided it is not already there, and sets its availability as either true or false
   * @param title the title to be added
   * @param isAvailable whether or not the title is available
   */
  public void addTitle(String title, boolean isAvailable) {
    if (containsTitle(title)) {
      System.out.println(title + " is already in the library's collection.");
    } else {
      System.out.println(title + " has been added to the library's collection. " + title + "'s availability has been set to: " + isAvailable);
      collection.put(title, isAvailable);
    }
  }

  /**
   * Removes a title from a Library's collection, provided it is currently there
   * @param title the title to be removed
   * @return the title that was removed
   */
  public String removeTitle(String title) {
    if (!containsTitle(title)) {
      throw new RuntimeException(title + " isn't in the library's collection.");
    }
    collection.remove(title);
    return (title);
  }

  /**
   * Checks out an item, provided it is there and available, 
   * by changing its availablity status to false
   * @param title the item to be checked out
   */
  public void checkOut(String title) {
    if (!isAvailable(title)) {
      System.out.println(title + " isn't available.");
    } else {
      collection.replace(title, true, false);
    }
  }

  /**
   * Returns an item, provided it has not already been returned,
   * by changing its availability status to true
   * @param title the item to be returned
   */
  public void returnBook(String title) {
    if (isAvailable(title)) {
      System.out.println(title + " has already been returned.");
    } else {
      collection.replace(title, false, true);
    }
  }

  /**
   * Moves you to the desired floor, provided you are inside the Library and the desired floor is a valid level of the Library.
   * If the Library has an elevator, allows for travel to non-adjacent floors.
   * @param floorNum the intended floor number
   */
  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (!hasElevator()) {
      if (floorNum != activeFloor + 1 && floorNum != activeFloor - 1) {
        throw new RuntimeException("As this building doesn't have an elevator, you can't travel to non-adjacent floors to reach floor " + floorNum + ". You are currently on floor " + activeFloor + ".");
      }
    }
    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }

  /**
   * Prints an organized list of methods for the Library class
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + checkOut()\n + returnBook()");
  }

  /**
   * Prints an organized record of a Library's collection,
   * with each item's title and availability status
   */
  public void printCollection() {
    for (String key : collection.keySet()) {
      System.out.println("Title: " + key + ". Available for checkout: " + collection.get(key));
    }
  }
  
  /**
     * A main function for creating an example Library
     * @param args an empty Array of Strings for storing command line arguments
     */
  public static void main(String[] args) {
    Library forbesLib = new Library("Forbes Library", "20 West St", 7, true);
    forbesLib.addTitle("David Copperfield");
    forbesLib.addTitle("Animal Farm", false);
    forbesLib.printCollection();
    forbesLib.showOptions();
    forbesLib.enter();
    forbesLib.goToFloor(5);
  }
}