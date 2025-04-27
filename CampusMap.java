import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
    
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court", 4));
        
        myMap.addBuilding(new House("Chase House", "123 College Lane", 3, true, true));
        myMap.addBuilding(new House("Morrow House", "456 Elm Street", 2, false, false));
    
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive", 4));
        myMap.addBuilding(new Library("Josten Library", "10 Green Street", 2));
    
        myMap.addBuilding(new Cafe("Campus Cafe", "1 College Ave", 1, 500, 300, 200, 100));
        myMap.addBuilding(new Cafe("Compass Cafe", "Campus Center", 1, 300, 200, 150, 80));
        
        myMap.addBuilding(new Building("Burton Hall", "5 Burton Drive", 3));
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Road", 3));
    
        System.out.println(myMap);
    }
}    