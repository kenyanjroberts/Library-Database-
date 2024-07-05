import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<BookManager> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(BookManager book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public BookManager findBookById(String id) {
        for (BookManager book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public boolean borrowBook(String bookId, String userId) {
        BookManager book = findBookById(bookId);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
            System.out.println("Book borrowed successfully by " + userId);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId) {
        BookManager book = findBookById(bookId);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
            System.out.println("Book returned successfully.");
            return true;
        }
        return false;
    }
    public void listBooks() {
        for (BookManager book : books) {
            System.out.println(book);
        }
    }

    public void listUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }
}

