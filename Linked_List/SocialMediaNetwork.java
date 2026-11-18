import java.util.ArrayList;
import java.util.List;

class UserNode {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}

public class SocialMediaNetwork {
    private UserNode head;

    public void addUser(int userId, String name, int age) {
        UserNode newNode = new UserNode(userId, name, age);
        newNode.next = head;
        head = newNode;
    }

    // 5. Search by Name or User ID
    public UserNode searchUser(Integer id, String name) {
        UserNode curr = head;
        while (curr != null) {
            if ((id != null && curr.userId == id) || (name != null && curr.name.equalsIgnoreCase(name))) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    // 1. Add friend connection between two users
    public void addFriend(int id1, int id2) {
        UserNode u1 = searchUser(id1, null);
        UserNode u2 = searchUser(id2, null);
        if (u1 != null && u2 != null && id1 != id2) {
            if (!u1.friendIds.contains(id2)) u1.friendIds.add(id2);
            if (!u2.friendIds.contains(id1)) u2.friendIds.add(id1);
        }
    }

    // 2. Remove friend connection
    public void removeFriend(int id1, int id2) {
        UserNode u1 = searchUser(id1, null);
        UserNode u2 = searchUser(id2, null);
        if (u1 != null && u2 != null) {
            u1.friendIds.remove(Integer.valueOf(id2));
            u2.friendIds.remove(Integer.valueOf(id1));
        }
    }

    // 3. Find mutual friends between two users
    public List<Integer> findMutualFriends(int id1, int id2) {
        UserNode u1 = searchUser(id1, null);
        UserNode u2 = searchUser(id2, null);
        List<Integer> mutual = new ArrayList<>();
        if (u1 != null && u2 != null) {
            for (int fId : u1.friendIds) {
                if (u2.friendIds.contains(fId)) mutual.add(fId);
            }
        }
        return mutual;
    }

    // 4. Display all friends of a specific user
    public void displayFriends(int userId) {
        UserNode user = searchUser(userId, null);
        if (user != null) {
            System.out.print(user.name + "'s Friends: ");
            for (int fId : user.friendIds) {
                UserNode friend = searchUser(fId, null);
                System.out.print((friend != null ? friend.name : fId) + " ");
            }
            System.out.println();
        }
    }

    // 6. Count number of friends for each user
    public void countAllFriends() {
        UserNode curr = head;
        while (curr != null) {
            System.out.println(curr.name + " has " + curr.friendIds.size() + " friend(s).");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaNetwork net = new SocialMediaNetwork();
        net.addUser(1, "Ashi", 20);
        net.addUser(2, "Aradhaya", 20);
        net.addUser(3, "Sumansh", 21);
        net.addFriend(1, 2);
        net.addFriend(2, 3);
        net.addFriend(1, 3);
        net.displayFriends(1);
        System.out.println("Mutual friends (1 & 2): " + net.findMutualFriends(1, 2));
        net.countAllFriends();
    }
}
