class ItemNode {
    String itemName;
    int itemId;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManagement {
    private ItemNode head;

    // 1. Add item at beginning, end, or specific position
    public void addItem(String name, int id, int qty, double price, int pos) {
        ItemNode newNode = new ItemNode(name, id, qty, price);
        if (pos <= 1 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        ItemNode curr = head;
        for (int i = 1; i < pos - 1 && curr.next != null; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
    }

    // 2. Remove item by Item ID
    public void removeItem(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        ItemNode curr = head;
        while (curr.next != null && curr.next.itemId != itemId) {
            curr = curr.next;
        }
        if (curr.next != null) curr.next = curr.next.next;
    }

    // 3. Update quantity by Item ID
    public void updateQuantity(int itemId, int newQty) {
        ItemNode curr = head;
        while (curr != null) {
            if (curr.itemId == itemId) {
                curr.quantity = newQty;
                return;
            }
            curr = curr.next;
        }
    }

    // 4. Search by Item ID or Item Name
    public ItemNode searchItem(Integer id, String name) {
        ItemNode curr = head;
        while (curr != null) {
            if ((id != null && curr.itemId == id) || (name != null && curr.itemName.equalsIgnoreCase(name))) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    // 5. Calculate total inventory value
    public double calculateTotalValue() {
        double total = 0;
        ItemNode curr = head;
        while (curr != null) {
            total += curr.quantity * curr.price;
            curr = curr.next;
        }
        return total;
    }

    // 6. Merge Sort by Item Name or Price (ascending/descending)
    public void sortInventory(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
    }

    private ItemNode mergeSort(ItemNode node, String criteria, boolean ascending) {
        if (node == null || node.next == null) return node;
        ItemNode middle = getMiddle(node);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(node, criteria, ascending);
        ItemNode right = mergeSort(nextOfMiddle, criteria, ascending);
        return sortedMerge(left, right, criteria, ascending);
    }

    private ItemNode sortedMerge(ItemNode a, ItemNode b, String criteria, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        int cmp = criteria.equalsIgnoreCase("price")
                ? Double.compare(a.price, b.price)
                : a.itemName.compareToIgnoreCase(b.itemName);

        boolean condition = ascending ? (cmp <= 0) : (cmp >= 0);
        ItemNode result;
        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, criteria, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, criteria, ascending);
        }
        return result;
    }

    private ItemNode getMiddle(ItemNode head) {
        ItemNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void display() {
        ItemNode curr = head;
        while (curr != null) {
            System.out.println(curr.itemId + " | " + curr.itemName + " | Qty: " + curr.quantity + " | Price: $" + curr.price);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        InventoryManagement inv = new InventoryManagement();
        inv.addItem("Laptop", 101, 5, 800.0, 1);
        inv.addItem("Mouse", 102, 20, 25.0, 2);
        inv.addItem("Keyboard", 103, 15, 45.0, 3);
        inv.sortInventory("price", true);
        inv.display();
        System.out.println("Total Value: $" + inv.calculateTotalValue());
    }
}
