// https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1

// Time Complexity : O(1)
// Space Complexity : O(1)

class DeleteNodeWithoutPointer{
    void deleteNode(Node del)
    {
        del.data = del.next.data;
        del.next = del.next.next;
    }
}