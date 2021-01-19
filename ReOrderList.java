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
/*
time complexity: O(n)
space complexity :O(1)
*/

class reorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return ;
        
        
        ListNode slow = head;
        ListNode fast = head;
        
        //step 1 : find mid of list
        while(fast.next != null && fast.next.next != null){ //1,2,3,4,5,6 , slow = 1, fast = 1
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        
        //step 2 : list2 = reverse list from mid+1 to end
        //mid is at slow
        //reverse list from here
        ListNode curr = slow.next;
        ListNode reversed = reverseList(curr);
        
        //step 3: merge the lists
        
        ListNode head1 = head;
        ListNode head2 = reversed;
        
        while(head2 != null){
            ListNode temp = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = temp;
            head1 = temp;
            
        }
        head1.next = null;
        
        return;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode fast = null;
        
        ListNode curr = head;
       
        
        while(curr != null){
            fast = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fast;
            //fast = curr.next;
        }
        
        return prev;
    }
}



// public void reorderList(ListNode head) {
//         if(head == null || head.next == null || head.next.next == null) return;
//         Stack<ListNode> s = new Stack<>();
//         ListNode r = head.next;
//         while(r.next != null) {
//             s.push(r);
//             r = r.next;    
//         }
//         ListNode nh = head.next;
//         while(s.peek().val != head.val){
//             ListNode top = s.pop();
//             nh = head.next;
//             head.next = top;
//             top.next = nh;
//             head = nh;
//         } 
//     }