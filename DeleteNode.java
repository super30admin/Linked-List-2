package s30.linkedList.linkedList2;

import hackerEarth.Node;

// Time Complexity O(1);
// Space Complexity O(1);
public class DeleteNode {

    void deleteNode(Node del)
    {
        del.data = del.next.data;
        del.next = del.next.next;
    }
    public static void main(String[] args) {

    }
}
