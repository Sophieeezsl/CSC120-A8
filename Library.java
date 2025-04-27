import java.util.Hashtable;
import java.util.Enumeration;

/**
 * The Library class represents a library with a collection of books.
 * It allows adding, removing, checking out, and returning books,
 * and keeps track of their availability.
 * 
 * Extends the Building class and implements LibraryRequirements.
 */

public class Library extends Building {

    private Hashtable <String, Boolean> collection;

    /**
     * Constructs a new Library with the given name, address, and number of floors.
     *
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the number of floors in the library
     */

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
        System.out.println("You have built a library: 📖");
    }
  

    /** 
     * Adds a title to the collection and marks it as available 
     * @param title the title to add
    */

    public void addTitle(String title) {
        this.collection.put(title, true);
        System.out.println("\"" + title + "\" has been added to the collection.");
    }
    
    public void addTitle(String title, boolean isAvailable) {
        this.collection.put(title, isAvailable);
        System.out.println("\"" + title + "\" has been added with availability: " + isAvailable);
    }


    /**
     * Removes a title from the collection.
     *
     * @param title the title to remove
     * @return the removed title, or null if not found
     */

    public String removeTitle(String title) {
        if (this.collection.containsKey(title)) {
            this.collection.remove(title);
            System.out.println("\"" + title + "\" has been removed from the collection.");
            return title;
        } else {
            System.out.println("Title not found.");
            return null;
        }
    }

  
    /**
     * Checks out a book by marking it as unavailable.
     *
     * @param title the title to check out
     */
    public void checkOut(String title) {
        if (this.collection.containsKey(title) && this.collection.get(title)) {
            this.collection.replace(title, false);
            System.out.println("You have checked out \"" + title + "\".");
        } else {
            System.out.println("This book is either not in the collection or already checked out.");
        }
    }

    public void checkOut(String title, int days) {
        if (this.collection.containsKey(title) && this.collection.get(title)) {
            this.collection.replace(title, false);
            System.out.println("You have checked out \"" + title + "\" for " + days + " days.");
        } else {
            System.out.println("Cannot check out \"" + title + "\".");
        }
    }

    /**
     * Returns a book by marking it as available.
     *
     * @param title the title to return
     */

    public void returnBook(String title) {
        if (this.collection.containsKey(title) && !this.collection.get(title)) {
            this.collection.replace(title, true);
            System.out.println("You have returned \"" + title + "\".");
        } else {
            System.out.println("This book is either not in the collection or wasn't checked out.");
        }
    }

    /**
     * Checks if the collection contains a given title.
     *
     * @param title the title to check
     * @return true if the title exists, false otherwise
     */

    public boolean containsTitle(String title) {
        return this.collection.containsKey(title);
    }

    /**
     * Checks if a title is available.
     *
     * @param title the title to check
     * @return true if the title is available, false if checked out or not in collection
     */

    public boolean isAvailable(String title) {
        return this.collection.containsKey(title) && this.collection.get(title);
    }

    /**
     * Prints all titles in the collection with their availability status.
     */

    public void printCollection() {
        Enumeration<String> keys = this.collection.keys();
        System.out.println("Library Collection:");
        while (keys.hasMoreElements()) {
            String title = keys.nextElement();
            String status = this.collection.get(title) ? "Available" : "Checked out";
            System.out.println(" - \"" + title + "\" [" + status + "]");
        }
    }
    
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(String title)");
        System.out.println(" + removeTitle(String title)");
        System.out.println(" + checkOut(String title)");
        System.out.println(" + returnBook(String title)");
        System.out.println(" + printCollection()");
    }

    @Override
    public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You must enter the building first.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number.");
    }
    super.goToFloor(floorNum); // Library有电梯，直接跳楼层
    }




    public static void main(String[] args) {
        Library lib = new Library("Neilson Library", "7 Neilson Drive", 4);
        lib.addTitle("The Hobbit by J.R.R. Tolkien");
        lib.addTitle("The Dispossessed by Ursula K. Le Guin");
        lib.printCollection();

        lib.checkOut("The Hobbit by J.R.R. Tolkien");
        lib.printCollection();

        lib.returnBook("The Hobbit by J.R.R. Tolkien");
        lib.printCollection();

        System.out.println("Contains The Hobbit? " + lib.containsTitle("The Hobbit by J.R.R. Tolkien"));
        System.out.println("Is The Hobbit available? " + lib.isAvailable("The Hobbit by J.R.R. Tolkien"));

        lib.removeTitle("The Hobbit by J.R.R. Tolkien");
        lib.printCollection();

        lib.addTitle("Dune by Frank Herbert", false); //
        lib.printCollection();

        lib.checkOut("The Dispossessed by Ursula K. Le Guin", 30); //
        lib.printCollection();
    }
  
  }