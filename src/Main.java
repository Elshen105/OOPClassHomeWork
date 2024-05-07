import java.util.Scanner;

public class Main {

    static Book[] books = new Book[20];
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        bookSearchingApp();


    }

    public static void bookSearchingApp() {
        while (true) {

            System.out.println("1 - Show All Book");
            System.out.println("2 - Add Book");
            System.out.println("3 - Search BookName");
            System.out.println("4 - Search BookByPrice");

            System.out.print("Chose operation : ");
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    showBooks();
                    break;

                case 2:
                    addBook();
                    break;

                case 3:
                    getByName();
                    break;
                case 4:
                    getByPrice();
                    break;
            }

        }
    }


    public static void showBooks() {
        for (Book book : books) {
            if (book != null)
                System.out.println("Name : " + book.name + " Price : " + book.price + " Book Size : " + book.size);
        }
    }

    public static void addBook() {
        String bookName = new Scanner(System.in).nextLine();
        int bookPrice = scanner.nextInt();
        int bookSize = scanner.nextInt();

        Book book = new Book(bookName, bookPrice, bookSize);

        boolean hasEmpty = true;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                hasEmpty = false;
                break;
            }
        }

        if (hasEmpty) {
            Book[] newBook = new Book[books.length * 2];
            for (int i = 0; i < books.length; i++) {
                newBook[i] = books[i];
            }
            newBook[books.length] = book;
            books = newBook;
        }

    }

    public static void getByName() {
        System.out.print("Enter searching book name : ");
        String searchName = new Scanner(System.in).nextLine();
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (books[i].name.equals(searchName)) {
                    System.out.println("find Books : " + books[i].name);
                }
            }
        }


    }

    public static void getByPrice() {
        System.out.print("Enter the max price range : ");
        int minPrice = new Scanner(System.in).nextInt();
        System.out.print("Enter the min price range : ");
        int maxPrice = new Scanner(System.in).nextInt();

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (books[i].price >= minPrice && books[i].price <= maxPrice) {
                    System.out.println("Name found By Price : " + books[i].name);
                }
            }
        }
    }
}
