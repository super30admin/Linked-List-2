public class IntersectionLinkedList {
    public ListNode getIntersectionNode_using_length(ListNode headA, ListNode headB) {
        ListNode curr  =  headA;
        int countA=0;
        //  find the length of Linkedlist A
        while(curr != null){
            curr = curr.next;
            countA++;
            
        }
        
        curr =  headB;
        int countB=0;
        //  find the length of Linkedlist B
        while(curr != null){
            curr =  curr.next;
            countB++;
          
        }
        // if linkedlist A is bigger than Linkedlist B, 
        // traverse Linkedlist A till it become equals linkedlist B
        while(countA > countB){
            headA =  headA.next;
            countA--;
        }
        // if linkedlist B is bigger than Linkedlist A, 
        // traverse Linkedlist B till it become equals linkedlist A
        while(countB > countA){
            headB =  headB.next;
            countB--;
        }
        // traverse linkedlist A and Linkedlist B until they are equal
        while (headA != headB){
            headA =  headA.next; 
            headB =  headB.next;
            
        }
        
        return headA;
    }
}