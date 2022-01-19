/*
Time Complexity:
O(n) as we are iterating the list to find the mid point. Then we are reversing the lsit which gives TC of n/2.
After that we are merging two lists which again gives TC of n/2. Therefore, overall TC is O(n).
*/

/*
Space Complexity:
O(1) as we are not creating any extra space for the claculations
*/

/*
Approach:
This problem is a combination of three problems
i> find mid of the list
ii> reverse the list
iii> merge the list

So first we find the mid of the list with the  help of fast and slow pointers.
Slow pointer gives the mid of the list and next to slow acts as the head of the 
other part of the list which we have to reverse called secondHead. Then we change next to slow
to NULL as we are creating two different lists. After that we have to make slow as the
head of the first list.

So we have two heads for two different lists. With the help of sdecondHead we reverse the second 
list. AFter reversing it we merge the two lists
 */


//The code ran perfectly on leetcode



class Solution {
public:
    void reorderList(ListNode* head) {
        
        //find mid
        //reverse the list
        //merge the list
        
        ListNode* fast = head;
        ListNode* slow = head;
        ListNode* headSecond = NULL;
        
        while( fast->next != NULL && fast->next->next != NULL){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        headSecond = slow->next;
        slow->next =nullptr;
        slow = head;
        headSecond = reverse(headSecond);
        
        //ListNode* second = headSecond;
        ListNode* temp = NULL;
        
        while( headSecond != NULL){
            temp = slow->next; // t = 2
            slow->next = headSecond; // 1->5
            headSecond = headSecond->next; // 1->5->2
            slow->next->next = temp; //
            slow = temp;  
        }
    }
    
    private:
    ListNode* reverse(ListNode* head){
        ListNode* curr = head;
        ListNode* prev = NULL;
        ListNode* temp;
        
        while(curr != NULL){
            temp = curr-> next;
            curr->next =  prev;
            prev=  curr;
            curr = temp; 
        }
        
        return prev;
    }
};