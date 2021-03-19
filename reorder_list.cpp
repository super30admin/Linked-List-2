
// TC -> O(N) where N are the nodes in the ll
// SC-> O(1)

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

// MY METHOD O(N*N)
// class Solution {
// public:
//     void reorderList(ListNode* head) {
//         ListNode* j = head;
//         ListNode* i = head;
//         int count = 0;
//         while(j->next!= NULL){
//             count++;
//             j = j->next;
//         }
//         count++;
//         // some loopp
//         while(count!= 0){
//         if(i ==j){
//             i->next = NULL;
//             break;
//         }
//         count--;
//         ListNode* t = i->next;
//         i->next = j;
//         i = t;
//         j->next = i;
//         ListNode* temp = j;
//         while(j->next != temp)j = j->next;
//         }
        
        
        
//     }
// };

class Solution {
private:
    ListNode* reverse(ListNode* head){
        
        ListNode* curr = head;
        ListNode* prev = NULL;
        while(curr){
            ListNode* temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
        
    }
public:
    void reorderList(ListNode* head){
    ListNode* first = head;
    ListNode* fast = head;
    ListNode* slow = head;
    ListNode* middle = NULL;
    while(fast != NULL && fast->next != NULL){
        fast = fast->next->next;
        slow = slow->next;
    }
    middle = slow->next;
    slow->next = NULL;//separating the 2 lists
    middle = reverse(middle);//reversing the shorter second list
        
    while(middle!=NULL){
        ListNode* t1 = first->next;
        ListNode* t2 = middle->next;
        first->next = middle;
        first = t1;
        middle->next = first;
        middle = t2;
    }

    
    
    
    

        
    }
};