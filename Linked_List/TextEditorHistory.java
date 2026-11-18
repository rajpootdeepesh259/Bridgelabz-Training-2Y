class TextStateNode {
    String content;
    TextStateNode prev, next;

    public TextStateNode(String content) {
        this.content = content;
    }
}

public class TextEditorHistory {
    private TextStateNode head, tail, current;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    public TextEditorHistory() {
        // Initial empty state
        addState("");
    }

    // 1 & 5. Add new text state at the end, clearing redo branch and enforcing max size
    public void addState(String content) {
        TextStateNode newNode = new TextStateNode(content);
        if (head == null) {
            head = tail = current = newNode;
            size = 1;
            return;
        }

        // Discard any redo states ahead of current
        if (current != tail) {
            TextStateNode temp = current.next;
            while (temp != null) {
                size--;
                temp = temp.next;
            }
            current.next = null;
            tail = current;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        current = newNode;
        size++;

        // Enforce fixed history size limit (e.g., 10 states)
        while (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // 2. Undo functionality
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // 3. Redo functionality
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    // 4. Display current state
    public void displayCurrent() {
        System.out.println("Current Text: \"" + (current != null ? current.content : "") + "\"");
    }

    public static void main(String[] args) {
        TextEditorHistory editor = new TextEditorHistory();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrent();
        editor.undo();
        editor.displayCurrent();
        editor.redo();
        editor.displayCurrent();
    }
}
