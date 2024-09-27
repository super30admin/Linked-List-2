//143 Reorder List Medium JAVA
//Time Complexity: O(n);
//Space Complexity: O(1)

/**//
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        
        //user two pointer method to partition the LL in two LL
        if(head == null)
            return;
        ListNode temp1 = head;
        ListNode temp2 = head;
        
        while(temp2 != null && temp2.next != null){

            temp1 = temp1.next;
            temp2 = temp2.next;
            temp2 = temp2.next;
            
        }
        //revest the temp2 linkedList
        
        ListNode temp2Head;
        temp2 = temp1.next;
        
        temp1.next = null;
        ListNode end = null;
        while(temp2 != null){
            
            ListNode next = temp2.next;
            temp2.next = end;
            end = temp2;
            temp2 = next;
        }
        //new head of the linkedList
        temp2 = end;
        
        //construct the linkedlist by taking elements alternatively
        
        temp1 = head;
        
        ListNode finalHead = temp1;
        int count = 1;
        temp1 = temp1.next;
        while(temp1 != null && temp2 != null){
            if(count%2 == 0){
                //use list1
        
                ListNode tempNode = temp1;
                temp1 = temp1.next;
                finalHead.next = tempNode;
                finalHead = finalHead.next;
                 
            } else{
                ListNode tempNode = temp2;
                temp2 = temp2.next;
                finalHead.next = tempNode;
                
                finalHead = finalHead.next;
            }
            count++;

        }
        if(count%2 == 0){
            while(temp1 != null){
                ListNode tempNode = temp1;
                temp1 = temp1.next;
                finalHead.next = tempNode;
                finalHead = finalHead.next;

            }
        } else{
             while(temp2 != null){
                ListNode tempNode = temp2;
                temp2 = temp2.next;
                finalHead.next = tempNode;
                finalHead = finalHead.next;

            }
        }
        
        
    }
}