//time complexity: O(n) we are traveling the whole link
//space complexity: O(1) no extra nodes are created
//idea: 1. first we find the mid of the linked list using fast and slow 
    // 2. reverse the second part of the linked list using two pointers prev and curr 
    // 3. now we join the first half and the reversed second half by taking two pointers named first and second. make first as head and second as the last of the initial linked list and change the next of the nodes and move forward.


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        //base case zero nodes, one node, two nodes there is nothing to change
        if(!head || !head->next || !head->next->next){
            return;
        }
        //lets find the mid point 
        ListNode* slow = head;
        ListNode* fast = head;
        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        //slow pointer is the mid of the linked list now.

        //now reverse the second half from slow->next the linked list by using prev and curr pointers

        
        ListNode* curr = slow-> next;
        ListNode* prev = nullptr;
        slow->next = nullptr; //cut the link

        while(curr){
            ListNode* revTemp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = revTemp;
        }// prev pointer reached the end of the original linked list 

        //now as we reveresed the second half of the linked list lets merge the first half and reveresed second half.
        //take two pointers first and second pointers and assign first to head and second to end of the original linked list that means prev 

        ListNode* first = head;
        ListNode* second = prev;

        while(second){
            ListNode* temp1 = first->next;
            ListNode* temp2 = second->next;

            first->next = second;
            second->next = temp1;

            first = temp1;
            second = temp2;
        }
        // now we have merged the both lists 


    }
};
