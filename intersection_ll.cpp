//Time Complexity O(N)
//Space Complexity O(1)

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *nodeA = new ListNode() ; 
        ListNode *nodeB = new ListNode() ;

        nodeA = headA ; 
        nodeB = headB ;  
        
        int length_a = 0 ;  
        int length_b = 0 ; 

        while(nodeA != NULL){
            nodeA = nodeA -> next ; 
            length_a ++ ; 
        }

        while(nodeB != NULL){
            nodeB = nodeB -> next ; 
            length_b ++ ; 
        }

        // cout << length_a ; 
        // cout << length_b ; 
        while(length_a > length_b){
            headA = headA -> next ; 
            length_a -- ; 
        }

        while(length_b > length_a){
            headB = headB -> next ; 
            length_b -- ;   
        }

        while(headA != headB){
            headA = headA -> next ; 
            headB = headB -> next ;
        }


        return headA ; 
            
    }

};
