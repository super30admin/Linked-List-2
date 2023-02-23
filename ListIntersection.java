public class ListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int Alength = 0;
        int Blength = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA!=null){
            currA = currA.next;
            Alength++;
        }
        while(currB!=null){
            currB = currB.next;
            Blength++;
        }
        int diff = Math.abs(Alength-Blength);

        if(Alength>Blength){
            ListNode front = headA;
            for(int i=0;i<diff;i++){
                front = front.next;
            }
            ListNode back = headB;
            while(front!=back){
                front = front.next;
                back = back.next;
            }
            return back;
        }
        else{
            ListNode front = headB;
            for(int i=0;i<diff;i++){
                front = front.next;
            }
            ListNode back = headA;
            while(front!=back){
                front = front.next;
                back = back.next;
            }
            return front;
        }


    }
}
