class BookNode {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    BookNode next, prev;

    public BookNode(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}

public class LibraryManagement {
    private BookNode head, tail;

    // 1. Add book at beginning, end, or specific position
    public void addBook(String title, String author, String genre, int id, boolean available, int pos) {
        BookNode newNode = new BookNode(title, author, genre, id, available);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        if (pos <= 1) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }
        BookNode curr = head;
        for (int i = 1; i < pos - 1 && curr.next != null; i++) {
            curr = curr.next;
        }
        if (curr.next == null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            newNode.next = curr.next;
            newNode.prev = curr;
            curr.next.prev = newNode;
            curr.next = newNode;
        }
    }

    // 2. Remove book by Book ID
    public void removeBook(int bookId) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.bookId == bookId) {
                if (curr == head && curr == tail) head = tail = null;
                else if (curr == head) { head = head.next; head.prev = null; }
                else if (curr == tail) { tail = tail.prev; tail.next = null; }
                else { curr.prev.next = curr.next; curr.next.prev = curr.prev; }
                return;
            }
            curr = curr.next;
        }
    }

    // 3. Search by Book Title or Author
    public void searchBook(String query) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.title.equalsIgnoreCase(query) || curr.author.equalsIgnoreCase(query)) {
                System.out.println("Found: [" + curr.bookId + "] " + curr.title + " by " + curr.author + " (Available: " + curr.isAvailable + ")");
            }
            curr = curr.next;
        }
    }

    // 4. Update Availability Status
    public void updateAvailability(int bookId, boolean status) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.bookId == bookId) {
                curr.isAvailable = status;
                return;
            }
            curr = curr.next;
        }
    }

    // 5. Display Forward & Reverse
    public void displayForward() {
        BookNode curr = head;
        while (curr != null) {
            System.out.println(curr.bookId + ": " + curr.title + " (" + curr.author + ") - " + (curr.isAvailable ? "Available" : "Checked Out"));
            curr = curr.next;
        }
    }

    public void displayReverse() {
        BookNode curr = tail;
        while (curr != null) {
            System.out.println(curr.bookId + ": " + curr.title + " (" + curr.author + ") - " + (curr.isAvailable ? "Available" : "Checked Out"));
            curr = curr.prev;
        }
    }

    // 6. Count total books
    public int countBooks() {
        int count = 0;
        BookNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LibraryManagement lib = new LibraryManagement();
        lib.addBook("Clean Code", "Robert Martin", "Programming", 1, true, 1);
        lib.addBook("1984", "George Orwell", "Dystopian", 2, true, 2);
        lib.updateAvailability(2, false);
        lib.displayForward();
        System.out.println("Total books: " + lib.countBooks());
    }
}
