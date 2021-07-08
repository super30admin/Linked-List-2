//time complexity : O(M+N) m is size of linkedlist1 and n is size of linked list 2
//space complexity :  O(1)
//leet code : yes
// steps : traverse through list anf get their respective length inorder to find difference. now adjust cursor such a way both cursors are at same loc. now move pointers step by step once when pointers meet together return curosr.
class IntersectionofTwoLinkedLists160{

    class ListNode{

        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;

        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //getlength
        //get diff

        int lengthA = getLength(headA),lengthB = getLength(headB);
        ListNode cursorA = headA,cursorB=headB;

        if(lengthA > lengthB){
            cursorA = move(headA,lengthA-lengthB);
        }
        else {
            cursorB = move(headB,lengthB-lengthA);        
        }
        while(cursorA!=null){
            if(cursorA==cursorB){
                return cursorA;
            }
            cursorA = cursorA.next;
            cursorB = cursorB.next;
        }
        return null;
        }

    private ListNode move(ListNode head, int i) {
        while(i>0){
            head = head.next;
            i--;
        }   
        return head;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while(head!=null){
        head = head.next;
        length++;
        }
        return length;
    }

}