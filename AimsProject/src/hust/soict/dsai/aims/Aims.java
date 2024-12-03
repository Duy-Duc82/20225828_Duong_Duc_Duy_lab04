package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
import hust.soict.dsai.aims.media.CD;
import hust.soict.dsai.aims.media.DVD;


public class Aims {
    public static void main(String[] args) {
        // Create a new store and cart
        Store store = new Store();
        Cart cart = new Cart();

        // Add some initial media items to the store
        store.addMedia(new CD("Thriller", "Michael Jackson"));
        store.addMedia(new DVD("The Godfather", "Francis Ford Coppola"));
        store.addMedia(new Book(1, "1984", "George Orwell", 15.99f));

        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    storeMenu(scanner, store, cart);
                    break;
                case 2:
                    updateStore(scanner, store);
                    break;
                case 3:
                    seeCart(scanner, cart);
                    break;
                case 0:
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 0);

        scanner.close();
    }

    // Main menu
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    // Store menu
    public static void storeMenu(Scanner scanner, Store store, Cart cart) {
        int option;
        do {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    seeMediaDetails(scanner, store);
                    break;
                case 2:
                    addMediaToCart(scanner, store, cart);
                    break;
                case 3:
                    playMedia(scanner, store);
                    break;
                case 4:
                    seeCart(scanner, cart);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 0);
    }

    // See media details
    public static void seeMediaDetails(Scanner scanner, Store store) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            System.out.println("Media details: " + media);
            mediaDetailsMenu(scanner, media);
        } else {
            System.out.println("Media not found.");
        }
    }

    // Media details menu (add to cart or play)
    public static void mediaDetailsMenu(Scanner scanner, Media media) {
        int option;
        do {
            System.out.println("\nOptions: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    // Add to cart
                    System.out.println(media.getTitle() + " added to the cart.");
                    break;
                case 2:
                    // Play media (only CD/DVD)
                    if (media instanceof CD || media instanceof DVD) {
                        System.out.println("Playing " + media.getTitle() + "...");
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    System.out.println("Returning to store menu...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 0);
    }

    // Add media to cart
    public static void addMediaToCart(Scanner scanner, Store store, Cart cart) {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println(media.getTitle() + " added to the cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    // Play media
    public static void playMedia(Scanner scanner, Store store) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.getMediaByTitle(title);
        if (media != null) {
            if (media instanceof CD || media instanceof DVD) {
                System.out.println("Playing " + media.getTitle() + "...");
            } else {
                System.out.println("This media cannot be played.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    // Update store (add/remove media)
    public static void updateStore(Scanner scanner, Store store) {
        System.out.println("\n1. Add media");
        System.out.println("2. Remove media");
        System.out.print("Choose an option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (option == 1) {
            // Add media logic
        } else if (option == 2) {
            // Remove media logic
        } else {
            System.out.println("Invalid option.");
        }
    }

    // See current cart
    public static void seeCart(Scanner scanner, Cart cart) {
        // Print cart details and display cart menu
    }
}