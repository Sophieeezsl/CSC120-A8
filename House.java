import java.util.ArrayList;

/**
 * The House class represents a residential building that can house students.
 * It tracks residents and whether the house includes a dining room.
 *
 * Extends the Building class and implements HouseRequirements.
 */

public class House extends Building{

    private ArrayList<Student> residents;
    private boolean hasDiningRoom;
    private boolean hasElevator;

/**
 * Constructs a new House with the given name, address, number of floors,
 * and whether it has a dining room.
 *
 * @param name the name of the house
 * @param address the address of the house
 * @param nFloors the number of floors
 * @param hasDiningRoom true if the house has a dining room
 */

 public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
}

/**
 * Checks if the house has a dining room.
 *
 * @return true if it has a dining room, false otherwise
 */

    public boolean hasDiningRoom() {
        return this.hasDiningRoom;
    }
/**
 * Returns the number of current residents in the house.
 *
 * @return number of residents
 */
    public int nResidents() {
        return this.residents.size();
    }

    public int nResidents(boolean showNames) {
        if (showNames) {
            System.out.println("Residents:");
            for (Student s : this.residents) {
                System.out.println("- " + s.getName());
            }
        }
        return this.residents.size();
    }
/**
 * Moves a student into the house if they are not already a resident.
 *
 * @param s the student to move in
 */

    public void moveIn(Student s) {
        if (!this.residents.contains(s)) {
            this.residents.add(s);
            System.out.println(s.getName() + " has moved into " + this.name + ".");
        } else {
            System.out.println(s.getName() + " is already a resident.");
        }
    }
    
    public void moveIn(String name) {
        Student s = new Student(name, "unknown", 2025);
        moveIn(s);
    }

/**
 * Moves a student out of the house if they are a resident.
 *
 * @param s the student to move out
 * @return the student who moved out, or null if not found
 */

    public Student moveOut(Student s) {
        if (this.residents.contains(s)) {
            this.residents.remove(s);
            System.out.println(s.getName() + " has moved out of " + this.name + ".");
            return s;
        } else {
            System.out.println(s.getName() + " is not a resident.");
            return null;
        }
    }

/**
 * Checks whether a student is a resident of the house.
 *
 * @param s the student to check
 * @return true if the student is a resident, false otherwise
 */

    public boolean isResident(Student s) {
        return this.residents.contains(s);
    }

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + moveIn(Student s)");
        System.out.println(" + moveIn(String name)");
        System.out.println(" + moveOut(Student s)");
        System.out.println(" + isResident(Student s)");
        System.out.println(" + nResidents()");
        System.out.println(" + nResidents(boolean showNames)");
    }

    @Override
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You must enter the building before navigating floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number for this House.");
        }
        if (this.hasElevator) {
            super.goToFloor(floorNum);
        } else {
            if (Math.abs(floorNum - this.activeFloor) != 1) {
                throw new RuntimeException("This House has no elevator; you must move one floor at a time!");
            }
            super.goToFloor(floorNum);
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Ab", "9909abc", 2014);
        House h = new House("Chase House", "123 College Lane", 3, true, true); //
        h.moveIn(s);
        System.out.println("Residents: " + h.nResidents());
        System.out.println("Has dining room? " + h.hasDiningRoom());
        h.moveOut(s);
        System.out.println("Is still resident? " + h.isResident(s));
        
        h.moveIn("Betty"); //
        System.out.println("Residents after adding Betty: " + h.nResidents(true)); //
        h.showOptions();
    }
}