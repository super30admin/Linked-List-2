// ## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

// For example, the following two linked lists begin to intersect at node c1:

//In this approach we are finding an length of both the lists and we are keeping 2 pointers such that pointer1 at first list and pointer2 at second list and we are moving one of the pointers to make lengths same
// Once lengths are same we are moving both the pointers by one and looking if both are equal if till end we don't find it then we will return null

Time Complexity: O(n)
Space Complexity: O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode pointer1=headA;
        ListNode pointer2=headB;
        int lengthA=0;
        while(pointer1!=null){
            lengthA++;
            pointer1=pointer1.next;
        }
        System.out.println(lengthA);
        int lengthB=0;
        while(pointer2!=null){
            lengthB++;
            pointer2=pointer2.next;
        }
         System.out.println(lengthB);
        pointer1=headA;   
        pointer2=headB; 
        while(lengthA>lengthB){
            pointer1=pointer1.next;
            lengthA--;
            
        }
        while(lengthB>lengthA){
            pointer2=pointer2.next;
            lengthB--;  
        }
        System.out.println(lengthA);
        System.out.println(lengthB);
        while(pointer1!=null){
            if(pointer1==pointer2){
                return pointer1;
            }
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }
        return null;


        }
    }
