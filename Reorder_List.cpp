// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        if(head==NULL){
            return;
        }
        
        //find length
        int count = 0;
        ListNode *current = head;
        while(current!=NULL){
            current = current->next;
            count++;
        }
        
        //find midpoint
        int n;
        if(count%2==0){
            n = count/2;
        }
        else{
            n = (count+1)/2;
        }
        current = head;
        for(int i=1;i<n;i++){
            current = current->next;
        }
        
        //separate list at the midpoint
        ListNode *first = head;
        ListNode *sec = current->next;
        current->next = NULL;
        
        //reverse the second list
        sec = reverse(sec);
        
        //combine the two lists
        while(sec!=NULL){
            ListNode *temp = first->next;
            first->next = sec;
            sec = sec->next;
            first->next->next = temp;
            first = temp;
        }
    }
    
    //function to reverse
    ListNode* reverse(ListNode* sec){
        if(sec==NULL||sec->next==NULL){
            return sec;
        }
        ListNode *prev = NULL;
        ListNode *current = sec;
        ListNode *temp = NULL;
        while(current!=NULL){
            temp = current->next;
            current->next = prev;
            prev = current;
            current = temp;
        }
        sec = prev;
        
        return sec;
    }
};
