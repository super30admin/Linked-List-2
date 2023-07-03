// Time Complexity: O(n)
// Space Complexity: O(n)

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
        vector<ListNode*> v; 
        ListNode* ptr = head; 
        int count = 0; 
        while(ptr != nullptr) {
            v.push_back(ptr);
            count++; 
            ptr = ptr->next; 
        }

        int middle_index = count/2; 
        int li = count-1; 

        //For beginning Nodes:
        for(int i = 0; i < middle_index; i++) {
            ListNode* node = v[i];
            ListNode* nextNode = v[li];
            node->next = nextNode;
            li--; 
        }
    
        //For End Nodes: 
        int bi = 1; 
        for(int i = count-1; i > middle_index; i--) {
            ListNode* node = v[i];
            ListNode* nextNode = v[bi];
            node->next = nextNode; 
            bi++;  
        }

        v[middle_index]->next = nullptr; 

    }
};