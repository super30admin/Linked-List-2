//Intersection of two LinkedList
// Space Complexity : O(1)
//Time  Complexity : O(n)
public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        if(headA==headB){
            return headA;
        }
        
        int s1 =0;
        int s2=0;
        ListNode tempNode=headA;
        while(tempNode.next!=null){
            s1++;
            tempNode=tempNode.next;   
        }
        tempNode=headB;
        while(tempNode.next!=null){
            s2++;
            tempNode=tempNode.next;   
        }
        System.out.println(s1);
        System.out.println(s2);
        
        while(s1>s2){
            s1--;
            headA=headA.next;
        }
        
        while(s2>s1){
            s2--;
            headB=headB.next;
        }
        
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        
        return headA;
    }
}
