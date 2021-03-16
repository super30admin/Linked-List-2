//TC - O(1), SC - O(1)

class Solution
{
    void deleteNode(Node node)
    {
         // Your code here
         
        //  Node temp = node;
        //  Node cur = new Node(-1);
        //  cur.next = node;
        //  Node p1 = cur;
        //  while( != null){
        //      System.out.println(temp.data);
        //      temp = temp.next;
        //  }
         // Copy the data of next to current node and point current node to next.next
         node.data = node.next.data;
         node.next = node.next.next;
         
         
    }
}
