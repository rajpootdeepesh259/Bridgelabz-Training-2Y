class TaskNode {
    int taskId;
    String taskName;
    String priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, String priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

public class TaskScheduler {
    private TaskNode head, tail, currentTask;

    // 1. Add task at beginning, end, or specific position
    public void addTask(int id, String name, String priority, String dueDate, int position) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = currentTask = newNode;
            newNode.next = head;
            return;
        }
        if (position <= 1) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
            return;
        }
        TaskNode temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        if (temp == tail) {
            tail = newNode;
        }
    }

    // 2. Remove task by Task ID
    public void removeTask(int taskId) {
        if (head == null) return;
        TaskNode curr = head, prev = tail;
        do {
            if (curr.taskId == taskId) {
                if (curr == head && curr == tail) {
                    head = tail = currentTask = null;
                } else {
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                    if (curr == currentTask) currentTask = curr.next;
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // 3. View current task and move to next
    public void viewAndNextTask() {
        if (currentTask == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        System.out.println("Current Task: [" + currentTask.taskId + "] " + currentTask.taskName + " (" + currentTask.priority + ")");
        currentTask = currentTask.next;
    }

    // 4. Display all tasks from head
    public void displayAll() {
        if (head == null) return;
        TaskNode temp = head;
        do {
            System.out.println("ID: " + temp.taskId + " | " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // 5. Search task by Priority
    public void searchByPriority(String priority) {
        if (head == null) return;
        TaskNode temp = head;
        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                System.out.println("Match: " + temp.taskName + " (Due: " + temp.dueDate + ")");
            }
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(1, "Database Backup", "High", "2026-11-15", 1);
        scheduler.addTask(2, "Code Review", "Medium", "2026-11-16", 2);
        scheduler.addTask(3, "UI Update", "Low", "2026-11-18", 3);
        scheduler.viewAndNextTask();
        scheduler.viewAndNextTask();
        scheduler.displayAll();
    }
}
