



// class Solution {
//        public ListNode middleNode(ListNode head) {
//         ListNode s = head;
//         ListNode f = head;

//         while (f != null && f.next != null) {
//             s = s.next;
//             f = f.next.next;
//         }
//         return s;
//     }

//     public ListNode reverseList(ListNode head) {
//         if (head == null) {
//             return head;
//         }
//         ListNode prev = null;
//         ListNode present = head;
//         ListNode next = present.next;

//         while (present != null) {
//             present.next = prev;
//             prev = present;
//             present = next;
//             if (next != null) {
//                 next = next.next;
//             }
//         }
//         return prev;
//     }
    
//     public void reorderList(ListNode head) {
//          if (head == null || head.next == null) {
//             return;
//         }

//         ListNode mid = middleNode(head);

//         ListNode hs = reverseList(mid);
//         ListNode hf = head;

//         // rearrange
//         while (hf != null && hs != null) {
//             ListNode temp = hf.next;
//             hf.next = hs;
//             hf = temp;

//             temp = hs.next;
//             hs.next = hf;
//             hs = temp;
//         }

//         // next of tail to null
//         if (hf != null) {
//             hf.next = null;
//         }
//     }
// }


//brute force TC, SC- O(n) take arraylist pute nodes in it the take 2 pointer from start and end and reorder the list
//SC-O(1) approach - reverse second half of the linkedlist then reorder 
//for even length - if(fast!=null) && for odd length (fast.next!=null) in this case slow pointer will give the mid node
// start travesing reversed list after slow pointer
//for even if(fast.NEXT.next!=null) && for odd length (fast.next!=null)-- this will also work

class Solution {
    public ListNode reorderList(ListNode head) {

     ListNode slow = head;
     ListNode fast = head;

     while(fast!=null && fast.next!=null){ //TC-O(n/2)
         slow = slow.next;
         fast = fast.next.next;
     }

      fast = reverse(slow.next);//TC-O(n/2)
      slow.next = null;//to break the connection btw list and reverse list
      slow = head;

      while(fast!=null){//TC-O(n/2)
         ListNode temp = slow.next;
         slow.next = fast;
         fast = fast.next;
         slow.next.next = temp;
         slow = temp;
      }

      return head;

 }

 private ListNode reverse(ListNode root){
     ListNode prev = null;
     ListNode curr = root;
     while(curr!=null){
         ListNode temp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = temp;
     }
     return prev;
 }
}
