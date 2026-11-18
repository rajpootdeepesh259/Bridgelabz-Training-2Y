class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnaroundTime = 0;
    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobinScheduler {
    private ProcessNode head, tail;

    // 1. Add process at the end
    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // 2. Remove process by Process ID
    public void removeProcess(int pid) {
        if (head == null) return;
        ProcessNode curr = head, prev = tail;
        do {
            if (curr.pid == pid) {
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

    // 4. Display active processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("Queue empty.");
            return;
        }
        ProcessNode temp = head;
        do {
            System.out.print("[P" + temp.pid + ": Rem=" + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    // 3 & 5. Simulate Round-Robin & Calculate Avg WT & TAT
    public void simulate(int quantum) {
        if (head == null) return;
        int currentTime = 0;
        int totalProcesses = 0;
        double totalWT = 0, totalTAT = 0;

        ProcessNode temp = head;
        do {
            totalProcesses++;
            temp = temp.next;
        } while (temp != head);

        ProcessNode curr = head;
        while (head != null) {
            ProcessNode nextNode = curr.next;
            if (curr.remainingTime > quantum) {
                currentTime += quantum;
                curr.remainingTime -= quantum;
            } else {
                currentTime += curr.remainingTime;
                curr.remainingTime = 0;
                curr.turnaroundTime = currentTime; // Assuming arrival time = 0 for all
                curr.waitingTime = curr.turnaroundTime - curr.burstTime;
                totalWT += curr.waitingTime;
                totalTAT += curr.turnaroundTime;

                int completedPid = curr.pid;
                removeProcess(completedPid);
                if (head == null) break;
            }
            displayProcesses();
            curr = (head != null) ? nextNode : null;
        }

        System.out.printf("Average Waiting Time: %.2f\n", (totalWT / totalProcesses));
        System.out.printf("Average Turnaround Time: %.2f\n", (totalTAT / totalProcesses));
    }

    public static void main(String[] args) {
        RoundRobinScheduler rr = new RoundRobinScheduler();
        rr.addProcess(1, 10, 1);
        rr.addProcess(2, 4, 2);
        rr.addProcess(3, 6, 1);
        rr.simulate(3);
    }
}