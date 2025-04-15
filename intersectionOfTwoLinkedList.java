public class intersectionOfTwoLinkedList 
{
    public class ListNode 
    {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode dup1 = headA;
        ListNode dup2 = headB;
        int len1 = 0;
        int len2 = 0;
        while(dup1!=null)
        {
            len1++;
            dup1 = dup1.next;
        }
        while(dup2!=null)
        {
            len2++;
            dup2 = dup2.next;
        }
        dup1 = headA;
        dup2 = headB;
        if(len1>len2)
        {
            int x = len1-len2;
            while(x!=0)
            {
                dup1 = dup1.next;
                x--;
            }
        }
        else
        {
            int x = len2-len1;
            while(x!=0)
            {
                dup2 = dup2.next;
                x--;
            }
        }
        while(dup1 != dup2)
        {
            dup1 = dup1.next;
            dup2 = dup2.next;
        }
        return dup1;
    }
}
