//T.C- O(N)
//S.C- O(1)
//   Definition for singly-linked list.
  public class reorderlist {
      int val;
      reorderlist next;
      reorderlist() {}
      reorderlist(int val) { this.val = val; }
      reorderlist(int val, reorderlist next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public void reorderList(reorderlist head) {
        reorderlist slow=head;
        reorderlist fast= head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
        }
        reorderlist prev=null; 
        reorderlist curr=slow;reorderlist temp;
        while(curr!=null){
            temp= curr.next;
            curr.next=prev;
            prev= curr;
            curr=temp;
        }
        
        reorderlist first=head;
        reorderlist second=prev;
        
        while(second.next!=null){
            temp= first.next;
            first.next=second;
            first= temp;
            
            temp=second.next;
            second.next= first;
            second=temp;
        }
    }
}