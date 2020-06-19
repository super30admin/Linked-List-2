/*

// withour hashmap
    Space Complexity : O(1)
    time complexity :O(N+M) M = length of linkedlist 1 and N = size of linkedlist 2
    worked on leetcode : YES
// with hashmap

    space compleity : O(N)
    time complexity : O(M+N)
    worked on leetcode : YES
*/

public class IntersectionLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode>  set  =  new HashSet<ListNode>();
        
        while(headA !=  null){
            set.add(headA);
            headA =  headA.next;
        }
        
        while(headB != null){
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
        
    }
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