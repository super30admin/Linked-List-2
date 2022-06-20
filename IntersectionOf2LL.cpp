// Brute-force solution using a set.
// Time Complexity - O(m+n) - Since we are iterating over 'm' nodes in list 'A' and 'n' nodes in List 'B'.
// Space Complexity - O(m) - Since we are using a set to store all the nodes in List 'A'.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        set<ListNode*> s;
        ListNode* temp = headA;
        while(temp){
            s.insert(temp);
            temp = temp->next;
        }
        
        ListNode* tempB = headB;
        while(tempB){
            if(!s.count(tempB))
                tempB = tempB->next;
            else break;
        }
        return tempB;
    }
};

// Brute Force Solution without using a set.
// Time Complexity - O(m+n) - Since we are iterating over 'm' nodes in list 'A' and 'n' nodes in List 'B'.
// Space Complexity - O(1) - Since we are just using a pointer and variables to maintain count for the soultion.
// Problems Faced - No!
// It runs on leetcode.
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        int countA = 0;
        int countB = 0;
        
        ListNode* temp = headA;
        while(temp){
            countA++;
            temp = temp->next;
        }
        
        temp = headB;
        while(temp){
            countB++;
            temp = temp->next;
        }
        
        while(countA > countB){
            headA = headA->next;
            countA--;
        }
        
        while(countA < countB){
            headB = headB->next;
            countB--;
        }
        
        while(headA != headB){
            headA = headA->next;
            headB = headB->next;
        }
       return headA;
    }
};


// Approach 3
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode* currA = headA;
        ListNode* currB = headB;
        
        while(currA != currB){
            if(currA)
                currA = currA->next;
            else
                currA = headB;
            
            if(currB)
                currB = currB->next;
            else
                currB = headA;
        }
        return currA;
    }
};