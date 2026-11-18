class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next, prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class MovieManagement {
    private MovieNode head, tail;

    // 1. Add movie at beginning, end, or specific position (1-indexed)
    public void addMovie(String title, String director, int year, double rating, int position) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        if (position <= 1) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }
        MovieNode current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next == null) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    // 2. Remove movie by Title
    public void removeMovie(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    // 3. Search by Director or Rating
    public void search(String director, Double minRating) {
        MovieNode current = head;
        while (current != null) {
            boolean matchDirector = (director != null && current.director.equalsIgnoreCase(director));
            boolean matchRating = (minRating != null && current.rating >= minRating);
            if (matchDirector || matchRating) {
                System.out.println(current.title + " (" + current.year + ") - Dir: " + current.director + ", Rating: " + current.rating);
            }
            current = current.next;
        }
    }

    // 4. Display Forward & Reverse
    public void displayForward() {
        MovieNode current = head;
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.rating);
            current = current.next;
        }
    }

    public void displayReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println(current.title + " | " + current.director + " | " + current.rating);
            current = current.prev;
        }
    }

    // 5. Update Rating based on Title
    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        MovieManagement mms = new MovieManagement();
        mms.addMovie("Inception", "Christopher Nolan", 2010, 8.8, 1);
        mms.addMovie("Interstellar", "Christopher Nolan", 2014, 8.7, 2);
        mms.addMovie("Parasite", "Bong Joon-ho", 2019, 8.5, 2);
        mms.updateRating("Interstellar", 9.0);
        System.out.println("Forward:");
        mms.displayForward();
        System.out.println("Reverse:");
        mms.displayReverse();
    }
}