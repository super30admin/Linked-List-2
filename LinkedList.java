public class LinkedList {
    //time complexity : N
    // space complexity : 1
    // did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/reorder-list/submissions/
    public void reorderList(ListNode head) {
     //base
     if(head == null || head.next== null) return;
     //mid
     ListNode slow = head;
     ListNode fast = head;
     while(fast.next != null && fast.next.next != null){
         fast= fast.next.next;
         slow = slow.next;
     }

     // reverse
     fast = reverse(slow.next);
     slow.next = null;
     slow = head;

     //merge
     while(fast != null){
        ListNode temp = slow.next;
     slow.next = fast;
     fast = fast.next;
     slow.next.next = temp;
     slow = temp;
     }
     

    }
    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = head.next;
        while(temp != null){
            curr.next = prev; 
            prev = curr;
            curr = temp;            
            temp= temp.next;
        }
         curr.next = prev; 
        return curr;
     }

     //https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
     // time complexity : 1
     // space complexity : 1
     // did it run on geeksforgeeks : yes
     // any doubts : no
     public  void deleteNode(ListNode del)
     {
        if(del.next == null)
        {
            del= del.next;
        }else{
            del.val = del.next.val;
          del.next = del.next.next;
        }
          
     }
//time complexity : N
// space complexity : 1
// did it run on leetcode : yes
// any doubts : no
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;
        ListNode temp = headA;
        ListNode temp1 = headB;

        while(temp != null){
            temp= temp.next;
            lengthA++;
        }
        while(temp1 != null){
            temp1 = temp1.next;
            lengthB++;
        }

        if(lengthA > lengthB){
            int count = lengthA- lengthB;
            ListNode slow = headB;
            ListNode fast = headA;
            while(count >0){
                fast = fast.next;
                count--;
            }     
            while(slow != null){
                if(slow==fast) return slow;
                slow= slow.next;
                fast= fast.next;
            }
        }else{
            int count = lengthB- lengthA;
            ListNode slow = headA;
            ListNode fast = headB;
            while(count >0){
                fast = fast.next;
                count--;
            }
            while(slow != null){
                if(slow==fast) return slow;
                slow= slow.next;
                fast= fast.next;
            }    
        }
        return null;
        
    }
 }

