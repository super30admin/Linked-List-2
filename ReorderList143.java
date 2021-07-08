//time complexity : O(n)
//sapce complexity : O(1)
//leet code : yes
//steps:  split the linked list at mid. and attach next of list1 to point element of list2 and next of this element to point next element of list1.
class ReorderList143{

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public void reorderList(ListNode head) {
        
        if(head==null) return;
        //find mid
        //reverse mid

        ListNode mid = findMid(head);
        ListNode reverse = findReverse(head.next);

        //1<--2<--3

        //4-->5-->6
        
        mid.next = null;
        ListNode cursorA,cursorB;
        cursorA = head;
        cursorB = reverse;

        ListNode nextA,nextB;
        while(cursorB!=null){

            nextA = cursorA.next;
            nextB = cursorB.next;
            
            cursorA.next = cursorB;
            cursorB.next = nextA;

            cursorA = nextA;
            cursorB = nextB;
        }
        
    }

    private ListNode findReverse(ListNode head) {
        ListNode R =null, cursor = head,next;

        // 1<--2  3-->4

        while(cursor!=null){
            next = cursor.next;
            cursor.next = R;
            R = cursor;
            cursor = next;
        }
        return R;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }


}