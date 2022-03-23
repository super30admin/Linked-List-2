// Time Complexity : O(1)
// Space Complexity : O(1)

class DeleteWithoutHeadPointer {
    void deleteNode(Node del)
        {
             // Your code here
             int data = del.next.data;
             del.data = data;
             del.next = del.next.next;
        }
}