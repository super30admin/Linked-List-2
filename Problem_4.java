// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,ListNode> hash=new HashMap<ListNode,ListNode>();
        ListNode temp=headA;
        while(temp!=null){
            hash.put(temp,temp);
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            if(hash.containsKey(temp)){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
}



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
 
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode temp=headA;
        while(temp!=null){
            lenA=lenA+1;
            temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
            lenB=lenB+1;
            temp=temp.next;
        }
        //System.out.println(lenA+","+lenB);
        int diff=0;
        if(lenA>lenB){
            diff=lenA-lenB;
            temp=headA;
            while(diff>0){
                temp=temp.next;
                diff=diff-1;
            }
            headA=temp;
            while(headA!=headB){
                headA=headA.next;
                headB=headB.next;
            }
            return headA;
        }else{
            diff=lenB-lenA;
            temp=headB;
            while(diff>0){
                temp=temp.next;
                diff=diff-1;
            }
            headB=temp;
            while(headA!=headB){
                headA=headA.next;
                headB=headB.next;
            }
            return headA;
            //System.out.println(temp.val);
        }
        //return headA;
        
    }
}