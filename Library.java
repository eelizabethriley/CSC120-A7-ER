import java.util.Hashtable;
import java.util.Map;

/* This is a stub for the Library class */
/** A child class of class Building  that has a HashTable of book titles
 * and their availability.
*/
public class Library extends Building {

    private Hashtable<String, Boolean> collection;
    private boolean elevator;

    /**
     * Constructor for a Library
     * @param name the name of the Library
     * @param address the address of the Library
     * @param nFloors the number of floors in this Library
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      elevator = true;
      System.out.println("You have built a library: 📖");
    }
  
    public void goToFloor(int floorNum) {
      if (elevator == true) {
        super.goToFloor(floorNum);
      }
      else {
        throw new RuntimeException("Cannot go to nonadjacent floor, there is no elevator in " + this.name);
      }
    }

    /**
     * Add a book to the library's collection, which is a Hashtable containing titles and their availability.
     * @param title a string containing the title and author of the book being added
     */
    public void addTitle(String title) {
      collection.put(title, true);
      System.out.println(title + " has ben added to " + this.getName() + "'s collection.");
    }

    /* Overloaded addTitle method to add 2 books t once. */
    public void addTitle(String title1, String title2) {
      collection.put(title1, true);
      collection.put(title2, true);
      System.out.println(title1 + " and " + title2 + " have been added to " + this.getName() + "'s collection.");
    }


    /**
     * Remove a book from the library's collection, which is a Hashtable containing titles and their availability.
     * @param title a string containing the title and author of the book being added
     */
    public void removeTitle(String title) {
      collection.remove(title);
      System.out.println(title + " has been removed from " + this.getName() + "'s collection.");
    }

    public void removeTitle(String title1, String title2) {
      collection.remove(title1);
      collection.remove(title2);
      System.out.println(title1 + " and " + title2 + " have been removed from " + this.getName() + "'s collection.");
    }

    /**
     * Set the availability of this book to unavailable.
     * @param title tbe title of the book to be checked out
     */
    public void checkOut(String title) {
      collection.replace(title, true, false);
      System.out.println("Successfully checked out the title " + title + " from " + this.getName() + ". Thank you!");
    }

    public void checkOut(String title1, String title2) {
      collection.replace(title1, true, false);
      collection.replace(title2, true, false);
      System.out.println("Successfully checked out the titles " + title1 + " and " + title2 + " from " + this.getName() + ". Thank you!");
    }

    /**
     * Set the availability of this book to available.
     * @param title
     */
    public void returnBook(String title) {
      collection.replace(title, false, true);
      System.out.println("Succesfully returned the title " + title + " to " + this.getName() + ". Thank you!");
    }

    public void returnBook(String title1, String title2) {
      collection.replace(title1, false, true);
      collection.replace(title2, false, true);
      System.out.println("Successfully returned the titles " + title1 + " and " + title2 + " to " + this.getName() + ". Thank you!");
    }

    /**
     * Check the library's collection, which is a Hashtable containing titles and their availability, for the specified title. 
     * @param title the specified book's title
     * @return whether or not this book exists in the library's collection
     */
    public boolean containsTitle(String title) {
      return collection.containsKey(title);
    }

    /**
     * Check the availability of this book.
     * @param title the title of the specified book
     * @return whether or not this book is available to be checked out
     */
    public boolean isAvailable(String title) {
      return collection.get(title);
    }

    /**
     * Print out the titles and availability of all the books in the library's collection as an easily readable string.
     */
    public void printCollection() {
      // Use a for-each loop to iterate through the Hashtable as found in the following article: https://www.geeksforgeeks.org/hashtable-in-java/
      int i = 1;
      for (Map.Entry<String, Boolean> book : collection.entrySet()) {
        System.out.println(i + ". --- Title: " + book.getKey() + "\n" + "       Available?: " +  book.getValue());
        i++;
      }
    }

    public void showOptions() {
      super.showOptions();
      System.out.println(" + checkOut()" + "\n + returnBook()" + "\n + containsTitle()" + "\n + isAvailable()" + "\n + printCollection()");
    }

    public static void main(String[] args) {
      Library neilson = new Library("Neilson", "7 Neilson Drive, Northampton MA 01063", 4);
      neilson.addTitle("Pride and Prejudice by Jane Austen", "The Bell Jar by Sylvia Plath");
      neilson.checkOut("Pride and Prejudice by Jane Austen");
      neilson.removeTitle("The Bell Jar by Sylvia Plath");
      neilson.addTitle("The House on Mango Street by Sandra Cisneros");
      neilson.checkOut("The House on Mango Street by Sandra Cisneros");
      neilson.returnBook("Pride and Prejudice by Jane Austen");
      neilson.printCollection();
      neilson.showOptions();
      neilson.enter();
      neilson.goToFloor(4);
    }
  
  }