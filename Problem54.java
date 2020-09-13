//Time Complexity: O(n)
//Space Complexity: O(1)
//Did it run on leetcode: yes
//Problems faced any: No

public class Problem54 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //check the lengths of two list
        int a=0;
        int b=0;
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1!=null){
            a++;
            t1 = t1.next;
        }

        while(t2!=null){
            b++;
            t2 = t2.next;
        }

        t1 = headA;
        t2 = headB;

        //if L1 is longer than L2
        if(a>b){
            while(a!=b){
                t1 = t1.next;
                a--;
            }
        }else{
            //else L2 is longer than L1
            while(a!=b){
                t2 = t2.next;
                b--;
            }
        }

        //now both t1 and t2 are at the same point
        //so we can move a pointer and check if both are pointing to the same pointer
        while(t1!=null && t2!=null){
            if(t1==t2)
                return t1;
            t1 = t1.next;
            t2 = t2.next;
        }
        return null;
    }
}
