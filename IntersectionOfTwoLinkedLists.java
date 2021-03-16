/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
//         HashSet<ListNode> visited = new HashSet<>();
        
//         while(headB != null){
//             visited.add(headB);
//             headB = headB.next;
//         }
        
//         while(headA!=null){
//             if(visited.contains(headA)){
//                 return headA;
//             }
//             headA = headA.next;
//         }
        
//         return null;
        
//     }
// }

// TC - O(n), SC - O(1)

// First, we traverse through 2 lists and find size, if they are not equal, the larger one needs to start at the same point as other list. By going one by one step, when the two nodes are equal, return that node

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null){
            sizeA++;
            tempA = tempA.next;
        }
        
        while(tempB != null){
            sizeB++;
            tempB = tempB.next;
        }
        
        tempA = headA;
        tempB = headB;
        if(sizeA > sizeB){
            while(sizeA - sizeB != 0 && tempA.next != null){
                sizeA--;
                tempA = tempA.next;
            }  
        }else{
            while(sizeB - sizeA != 0 && tempB.next != null){
                sizeB--;
                tempB = tempB.next;
            }
        }
        //System.out.println(tempA.val + " " + tempB.val);
        int ct = 0;
        while(tempA != null && tempA != tempB){
            //System.out.println();
            //System.out.println(tempA.val + " " + tempB.val);
            tempA = tempA.next;
            tempB = tempB.next;
            //System.out.println((tempA == tempB)+" "+tempA + " " + tempB + " " + tempA.val + " " + tempB.val);
            ct++;
        }
        //System.out.println();
        //System.out.println("count: "+ct);
        return tempA; //  can return tempA or tempB
        
    }
}