import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Book 
{
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean available;

    public Book(int bookId, String title, String author, String category) 
    {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }

    public int getBookId() 
    {
        return bookId;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String getCategory() 
    {
        return category;
    }

    public boolean isAvailable() 
    {
        return available;
    }

    public void setAvailable(boolean available) 
    {
        this.available = available;
    }
}

class User 
{
    private int userId;
    private String name;
    private String email;

    public User(int userId, String name, String email) 
    {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public int getUserId() 
    {
        return userId;
    }

    public String getName() 
    {
        return name;
    }

    public String getEmail() 
    {
        return email;
    }
}

public class LibraryManagementSystem 
{
    private List<Book> books;
    private Map<Integer, User> users;
    private int nextBookId;
    private int nextUserId;

    public LibraryManagementSystem() 
    {
        books = new ArrayList<>();
        users = new HashMap<>();
        nextBookId = 1;
        nextUserId = 1;
    }

    public void addBook(String title, String author, String category) 
    {
        int bookId = nextBookId++;
        Book newBook = new Book(bookId, title, author, category);
        books.add(newBook);
        System.out.println("Book added successfully. Book ID: " + bookId);
    }

    public void addUser(String name, String email) 
    {
        int userId = nextUserId++;
        User newUser = new User(userId, name, email);
        users.put(userId, newUser);
        System.out.println("User added successfully. User ID: " + userId);
    }

    public void displayBooks() 
    {
        System.out.println("\nAvailable Books:");
        for (Book book : books) 
        {
            if (book.isAvailable()) 
            {
                System.out.println("Book ID: " + book.getBookId() + ", Title: " + book.getTitle() +
                        ", Author: " + book.getAuthor() + ", Category: " + book.getCategory());
            }
        }
    }

    public void issueBook(int bookId, int userId) 
    {
        Book book = findBookById(bookId);
        User user = users.get(userId);

        if (book != null && user != null && book.isAvailable()) 
        {
            book.setAvailable(false);
            System.out.println("Book issued successfully.");
        } 
        else 
        {
            System.out.println("Invalid Book ID or User ID, or Book is not available.");
        }
    }

    public void returnBook(int bookId) 
    {
        Book book = findBookById(bookId);
        if (book != null && !book.isAvailable()) 
        {
            book.setAvailable(true);
            System.out.println("Book returned successfully.");
        } 
        else 
        {
            System.out.println("Invalid Book ID or Book is already available.");
        }
    }

    private Book findBookById(int bookId) 
    {
        for (Book book : books) 
        {
            if (book.getBookId() == bookId) 
            {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) 
    {
        LibraryManagementSystem library = new LibraryManagementSystem();
        Scanner scanner = new Scanner(System.in);

        library.addBook("Book1", "Author1", "Category1");
        library.addBook("Book2", "Author2", "Category2");
        library.addUser("User1", "user1@example.com");
        library.addUser("User2", "user2@example.com");

        int choice;
        do 
        {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Available Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Add Book");
            System.out.println("5. Add User");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    library.issueBook(bookId, userId);
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextInt();
                    library.returnBook(bookId);
                    break;
                case 4:
                    scanner.nextLine();         // Consume newline character
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    library.addBook(title, author, category);
                    break;
                case 5:
                    scanner.nextLine();         // Consume newline character
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    library.addUser(name, email);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
}
