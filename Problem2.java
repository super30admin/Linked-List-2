//Space complexity: o(n)
//Time complexity :o(1)
class Problem2 {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
    
        //Find Middle
        ListNode slow=head;
        ListNode fast=head.next;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        //Reverse second half
        fast=reverse(slow.next);
        slow.next=null;
        //Merge
        //Logic to merge to linkedlist
        slow=head;
        ListNode dummy=slow.next;
        while(fast!=null){
            slow.next=fast;
            fast=fast.next;
            slow.next.next=dummy;
            slow=dummy;
            if(dummy==null){
                break;
            }
            dummy=dummy.next;
        }
    }
    
    private ListNode reverse(ListNode head){
        ListNode slow=head;
        ListNode prev=null;
        ListNode fast=head.next;
        while(fast!=null){
            slow.next=prev;
            prev=slow;
            slow=fast;
            fast=fast.next;
        }
        slow.next=prev;
        return slow;
    }