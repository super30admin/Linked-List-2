//Time Complexity:O(N)
//Space Complexity:O(1)
//In this problem, first I'll be finding the length of the two lists. After that, I'll find the difference between the two lengths and move the pointer pointing to the longer list to move difference number of steps. Now, as long as my first pointer goes null, I'll keep on iterating through both the lists and find whether there is an intersection. If there is no intersection, I'll be returning null.
//This code was executed and got accepted in leetcode.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode cur=headA;
        ListNode cur1=headB;
        int lenA=0;
        int lenB=0;
        while(cur!=null){
            lenA++;
            cur=cur.next;
        }
        while(cur1!=null){
            lenB++;
            cur1=cur1.next;
        }
        ListNode a = headA;
        ListNode b = headB;
        if(lenA>lenB){
            int dif=lenA-lenB;
            for(int i=0;i<dif;i++){
                a=a.next;
            }
        }
         if(lenB>lenA){
            int dif=lenB-lenA;
            for(int i=0;i<dif;i++){
                b=b.next;
            }
        }
        while(a!=null){
            if(a==b){
                return a;
            }
            a=a.next;
            b=b.next;
        }
        return null;
    }
}