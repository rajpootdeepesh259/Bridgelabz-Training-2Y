class StudentNode {
    int rollNo;
    String name;
    int age;
    String grade;
    StudentNode next;

    public StudentNode(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecord {
    private StudentNode head;

    // 1. Add at beginning, end, or specific position (1-indexed)
    public void addStudent(int rollNo, String name, int age, String grade, int position) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        if (position <= 1 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        StudentNode current = head;
        for (int i = 1; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // 2. Delete by Roll Number
    public void deleteByRollNo(int rollNo) {
        if (head == null) return;
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNo != rollNo) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // 3. Search by Roll Number
    public StudentNode searchByRollNo(int rollNo) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) return current;
            current = current.next;
        }
        return null;
    }

    // 4. Display all records
    public void displayAll() {
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll: " + current.rollNo + ", Name: " + current.name +
                    ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // 5. Update grade based on Roll Number
    public void updateGrade(int rollNo, String newGrade) {
        StudentNode student = searchByRollNo(rollNo);
        if (student != null) {
            student.grade = newGrade;
        }
    }

    public static void main(String[] args) {
        StudentRecord list = new StudentRecord();
        list.addStudent(101, "Aarav", 20, "A", 1);
        list.addStudent(102, "Priya", 21, "B", 2);
        list.addStudent(103, "Rohan", 19, "A+", 2);
        list.updateGrade(102, "A");
        list.displayAll();
        list.deleteByRollNo(103);
        System.out.println("After deletion:");
        list.displayAll();
    }
}