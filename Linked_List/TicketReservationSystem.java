class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

public class TicketReservationSystem {
    private TicketNode head, tail;

    // 1. Add new ticket at the end of the circular list
    public void bookTicket(int id, String customer, String movie, String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // 2. Remove ticket by Ticket ID
    public void cancelTicket(int ticketId) {
        if (head == null) return;
        TicketNode curr = head, prev = tail;
        do {
            if (curr.ticketId == ticketId) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // 3. Display current tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        TicketNode temp = head;
        do {
            System.out.println("Ticket #" + temp.ticketId + " | " + temp.customerName +
                    " | Movie: " + temp.movieName + " | Seat: " + temp.seatNumber +
                    " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // 4. Search ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) return;
        TicketNode temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found: Ticket #" + temp.ticketId + " (" + temp.customerName + " - " + temp.movieName + ")");
            }
            temp = temp.next;
        } while (temp != head);
    }

    // 5. Calculate total number of booked tickets
    public int getTotalBookedTickets() {
        if (head == null) return 0;
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    public static void main(String[] args) {
        TicketReservationSystem trs = new TicketReservationSystem();
        trs.bookTicket(501, "Ananya", "Dune: Part Two", "A12", "18:30");
        trs.bookTicket(502, "Vikram", "Oppenheimer", "C04", "21:00");
        trs.displayTickets();
        trs.searchTicket("Ananya");
        System.out.println("Total Booked: " + trs.getTotalBookedTickets());
        trs.cancelTicket(501);
        System.out.println("After cancellation, Total Booked: " + trs.getTotalBookedTickets());
    }
}
