package hust.soict.dsai.aims.cart;

public class Cart {
    // Maximum number of DVDs allowed in the cart
    public static final int MAX_NUMBERS_ORDERED = 20;

    
    
    // Array to store DVDs in the cart
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // Current quantity of DVDs in the cart
    private int qtyOrdered = 0;

    // Add a DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("DVD \"" + disc.getTitle() + "\" has been added to the cart.");
        } else {
            System.out.println("The cart is full.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("DVD \"" + disc.getTitle() + "\" has been added to the cart.");
            } else {
                System.out.println("The cart is full. Could not add DVD \"" + disc.getTitle() + "\".");
                break; // Stop adding if the cart is full
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd1;
            qtyOrdered++;
            System.out.println("DVD \"" + dvd1.getTitle() + "\" has been added to the cart.");
        } else {
            System.out.println("The cart is full. Could not add DVD \"" + dvd1.getTitle() + "\".");
        }
    
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("DVD \"" + dvd2.getTitle() + "\" has been added to the cart.");
        } else {
            System.out.println("The cart is full. Could not add DVD \"" + dvd2.getTitle() + "\".");
        }
    }
    

    // Remove a DVD from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                // Shift elements to fill the gap
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("DVD \"" + disc.getTitle() + "\" has been removed from the cart.");
                break;
            }
        }
        if (!found) {
            System.out.println("DVD \"" + disc.getTitle() + "\" does not exist in the cart.");
        }
    }

    // Calculate the total cost of DVDs in the cart
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // Print information of DVDs in the cart
    public void printCartDetails() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " + disc.getTitle() + " - " + disc.getCategory() + " - " + disc.getDirector() + " - " + disc.getLength() + " mins: " + disc.getCost() + " $");
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("*****************************************************");
    }
    //day la comment bai 1
    public void printAllIds() {
        System.out.println("List of all DVD IDs with full details:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". ID: " + disc.getId() +
                               ", Title: " + disc.getTitle() +
                               ", Category: " + disc.getCategory() +
                               ", Director: " + disc.getDirector() +
                               ", Length: " + disc.getLength() +
                               " mins, Cost: " + disc.getCost());
        }
    }

    // Search DVDs by title
    public void printAllTitles() {
        System.out.println("List of all DVD Titles with full details:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". Title: " + disc.getTitle() +
                               ", Category: " + disc.getCategory() +
                               ", Director: " + disc.getDirector() +
                               ", Length: " + disc.getLength() +
                               " mins, Cost: " + disc.getCost() +
                               ", ID: " + disc.getId());
        }
    }
}