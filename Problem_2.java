// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Finding the middle then reversing the second part of the linked list.
//At last we can merge the two created linkedlist



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //System.out.println(slow.val);
        ListNode newPointer=RevreseList(slow.next);
        slow.next=null;
        //printList(head);
        //printList(newPointer);
        ListNode temp=null;
        slow=head;
        while(newPointer!=null){
            temp=slow.next;
            slow.next=newPointer;
            newPointer=newPointer.next;
            slow.next.next=temp;
            slow=temp;
            
        }
        //return head;
    }
    
    public ListNode RevreseList(ListNode node){
        if(node==null){
            return null;
        }
        ListNode prev=null;
        ListNode curr=node;
        ListNode fast=node.next;
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
    
    public void printList(ListNode node){
        if(node==null){
            return;
        }
        ListNode temp=node;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println("");
    }
}

























// class Solution {
    // public void reorderList(ListNode head) {
        // int size=0;
        // ListNode temp=head;
        // while(temp!=null){
            // size=size+1;
            // temp=temp.next;
        // }
        // int[] arr=new int[size];
        // size=0;
        // temp=head;
        // while(temp!=null){
            // arr[size++]=temp.val;
            // temp=temp.next;
        // }
        // if(arr.length==1){
            // head=new ListNode(arr[0]);
            // return;
        // }
        // if(arr.length==2){
            // head=new ListNode(arr[0]);
            // temp=head;
            // temp.next=new ListNode(arr[1]);
            // return;
        // }
        // int i=1;
        // int j=arr.length-1;
        // while()
        // System.out.println(Arrays.toString(arr));
        
    // }
// }