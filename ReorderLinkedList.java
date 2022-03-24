// Time Complexity : O(n); where n is number of nodes in linked list
// Space Complexity : O(n)
class ReorderLinkedList {	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	
	// Time O(n)| Space O(1)
	public void reorderList(ListNode head) {
        //Null Case
        if(head==null || head.next==null) return;
        
        //Logic
        //STEP1: Find Mid Point
        ListNode slow= head;
        ListNode fast= head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;//2x speed of slow
        }
        //slow is intended mid
		
		//STEP2: Reverse second half
        fast= reverse(slow.next);
        slow.next=null;
        slow=head;//pointer to beginning of first half
		
		//STEP3: Merge two lists
        while(fast!=null){
            ListNode temp= slow.next;
            slow.next=fast;
            fast=fast.next;
            slow.next.next=temp;
            slow=temp;
        }
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode fast=head.next;
        
        while(fast!=null){
            curr.next=prev;
            prev=curr;
            curr=fast;
            fast=fast.next;
        }
        curr.next=prev;
        return curr;
    }
	
	// Driver code to test above 
    public static void main(String args[]) {
    	ReorderLinkedList ob = new ReorderLinkedList();
    	ListNode l1= new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));		
		
		System.out.print("Reordered linked list :");	
		ob.reorderList(l1);
		while(l1!=null) {
			System.out.print("\t"+l1.val);
			l1=l1.next;
		}
    } 
}
