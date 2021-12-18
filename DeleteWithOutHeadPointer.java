
//Timecomplexity: O(N)
//Space complexity:O(1)

public class DeleteWithOutHeadPointer {
    class Node
{
	int data ;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

 void deleteNode(Node del)
    {
         // Your code here
         if(del==null) return;
         if(del.next==null) return;
         else{
             Node temp=del.next;
             del.data=temp.data;
             del.next=temp.next;
             temp=null;
         }
    }
}
