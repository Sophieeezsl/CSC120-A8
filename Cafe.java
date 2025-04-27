/**
 * The Cafe class represents a café building that serves coffee.
 * It tracks inventory of coffee, sugar, cream, and cups,
 * and automatically restocks if ingredients run low.
 *
 * Extends the Building class and implements CafeRequirements.
 */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining
    private int nSugarPackets; // The number of sugar packets remaining
    private int nCreams; // The number of "splashes" of cream remaining
    private int nCups; // The number of cups remaining
/**
 * Constructs a new Cafe with the given name, address, number of floors,
 * and initial inventory of coffee, sugar, cream, and cups.
 *
 * @param name the name of the café
 * @param address the address of the café
 * @param nFloors number of floors in the café
 * @param nCoffeeOunces initial ounces of coffee
 * @param nSugarPackets initial sugar packet count
 * @param nCreams initial cream count
 * @param nCups initial number of cups
 */
    public Cafe(String name, String address, int nFloors,
                int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

/**
 * Sells a coffee with the specified size, sugar, and cream.
 * Automatically restocks if any ingredient is insufficient.
 *
 * @param size the size of the coffee in ounces
 * @param nSugarPackets number of sugar packets requested
 * @param nCreams number of cream splashes requested
 */

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets ||
            this.nCreams < nCreams || this.nCups < 1) {
            System.out.println("Insufficient inventory, restocking...");
            restock(100, 100, 100, 50); 
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;

        System.out.println("Sold a coffee: " + size + "oz, " +
            nSugarPackets + " sugar, " + nCreams + " cream.");
    }


    public void sellCoffee(int size) {
        sellCoffee(size, 1, 0);
    }

    public void sellCoffee(int size, int nSugarPackets) {
        sellCoffee(size, nSugarPackets, 0);
    }

/**
 * Restocks the café with the specified amounts of coffee, sugar, cream, and cups.
 *
 * @param nCoffeeOunces ounces of coffee to add
 * @param nSugarPackets sugar packets to add
 * @param nCreams cream splashes to add
 * @param nCups cups to add
 */

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;

        System.out.println("Restocked inventory.");
    }

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(int size)");
        System.out.println(" + sellCoffee(int size, int nSugarPackets)");
        System.out.println(" + sellCoffee(int size, int nSugarPackets, int nCreams)");
    }

    @Override
    public void goToFloor(int floorNum) {
    if (floorNum != 1) {
        throw new RuntimeException("Cafes only have publicly accessible first floor!");
    }
    super.goToFloor(floorNum);
    }


    public static void main(String[] args) {
        Cafe c = new Cafe("Campus Cafe", "1 College Ave", 1, 10, 5, 5, 2);
        c.sellCoffee(8, 2, 1); 
        c.sellCoffee(6);//
        c.sellCoffee(12, 3);//
        
    }

}