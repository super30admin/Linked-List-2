// Time Complexity :  O(1)
// Space Complexity : O(1)

class Problem3 {
    void deleteNode(Node del) {
        // Your code here
        if (del == null) return;
        del.data = del.next.data;
        del.next = del.next.next;
    }
}
