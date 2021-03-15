//Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
// Time Complexity : O(1)
// Space Complexity : O(1)
public class deleteWithoutHeadPointer {
    void deleteNode(Node node)
    {
         node.data = node.next.data;
         node.next = node.next.next;
    }
}
