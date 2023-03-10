public class DelWithoutHead {
    void deleteNode(Node del)
    {
         // Your code here
         del.data = del.next.data;
         del.next = del.next.next;
    }
}

// TC - O(n)
// SC - O(1)