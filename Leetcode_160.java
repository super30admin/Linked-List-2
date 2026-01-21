//way1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //Put all nodes of one in Set 
 //Travel second ListNodes and check whether node is present in set or not
 //If present, return it
 //TC: O(m+n); SC: O(m)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();

        while(headA!=null){
            set.add(headA);
            headA=headA.next;
        }

        while(headB!=null){
            if(set.contains(headB)){
                return headB;
            }else{
                headB=headB.next;
            }
        }

        return null;
        
    }
}

//way2:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //Identify headA length, headB length 
 //Travel the one with highest length till both the lenths are equal
 //Travel them together and return the one at meeting point
 //TC: O(m+n); SC: O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        
        ListNode curr=headA;
        int countA=0;
        while(curr!=null){
            countA+=1;
            curr=curr.next;
        }

        curr=headB;
        int countB=0;
        while(curr!=null){
            countB+=1;
            curr=curr.next;
        }

        ListNode currA=headA;
        ListNode currB=headB;

        while(countA>countB){
            countA-=1;
            currA=currA.next;
        }

        while(countB>countA){
            countB-=1;
            currB=currB.next;
        }

        while(currA!=currB){
            currA=currA.next;
            currB=currB.next;
        }

        return currA;


        
    }
}
