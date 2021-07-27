public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummyA = headA;
        ListNode dummyB = headB;
        
        int sizeA = 0;
        int sizeB = 0;
        
        while(dummyA != null){
            sizeA += 1;
            dummyA = dummyA.next;
        }
        
        while(dummyB != null){
            sizeB += 1;
            dummyB = dummyB.next;
        }
        
        dummyA = headA;
        dummyB = headB;
        
        while(sizeA != sizeB){
            if(sizeA > sizeB){
                dummyA = dummyA.next;
                sizeA -= 1;
            } else{
                dummyB = dummyB.next;
                sizeB -= 1;
            }
        }
        
        while(dummyA != null && dummyB != null){
            if(dummyA == dummyB){
                return dummyA;
            }
            dummyA = dummyA.next;
            dummyB = dummyB.next;
        }
        return null;
    }
}

//Time complexity: O(n)
//Space Complexity: O(1)