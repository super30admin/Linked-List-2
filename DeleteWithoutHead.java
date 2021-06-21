class Solution
{
    void deleteNode(Node del)
    {
         
         Node temp = del;
		 
		 //copy content of next node		 
		 temp.val = temp.next.val;
		 
		 //delete next node
		 temp.next = temp.next.next;
         
    }
}