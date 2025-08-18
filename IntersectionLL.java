class IntersectionLL{
       //Idea is to use make the two pointers start at the same length / distance from the end and traverse until an intersection is found
       // Time Complexity: O(m+n)
       // Space Complexity: O(1)
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        int lengthA = 0, lengthB = 0;
        while(pointerA!=null)
        {
            lengthA++;
            pointerA = pointerA.next;
        }

        while(pointerB!=null)
        {
            lengthB++;
            pointerB = pointerB.next;
        }

        pointerA = headA;
        pointerB = headB;

        if(lengthA>lengthB){
        int diff = lengthA - lengthB;
        while(diff>0)
        {
            pointerA = pointerA.next;
            diff--;
        }
        }
        else
        {
        int diff = lengthB - lengthA;
        while(diff>0)
        {
            pointerB = pointerB.next;
            diff--;
        }            
        }

        while(pointerA!=null && pointerB!=null)
        {
            if(pointerA==pointerB)
            {
                return pointerA;
            }
            else
            {
                pointerA = pointerA.next;
                pointerB = pointerB.next;
            }
        }
        return null;
    }
}