package lab02.src;

public class Store {
    private static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    // Phương thức thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = disc;
            qtyInStore++;
            System.out.println("DVD \"" + disc.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    // Phương thức xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == disc) {
                found = true;
                // Dịch chuyển các phần tử để lấp khoảng trống
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                System.out.println("DVD \"" + disc.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("DVD \"" + disc.getTitle() + "\" does not exist in the store.");
        }
    }

    // In danh sách các DVD trong cửa hàng
    public void printStoreDetails() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available DVDs in Store:");
        for (int i = 0; i < qtyInStore; i++) {
            DigitalVideoDisc disc = itemsInStore[i];
            System.out.println((i + 1) + ". DVD - " + disc.getTitle() + " - " + disc.getCategory() + " - " + disc.getDirector() + " - " + disc.getLength() + " mins: " + disc.getCost() + " $");
        }
        System.out.println("**************************************************");
    }
}
