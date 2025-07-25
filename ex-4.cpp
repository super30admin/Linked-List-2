//time complexity: O(m+n),  we are travelling the whole list atmost 
//space complexity: O(1), no extra space is created 

//Idea: take two pointers a-> starts from head A and b-> starts from head B
//Now let the passes need for a to reach intersection node is lenA and for b is lenB.
//lets assume lenA > lenB w.l.o.g. //if lenA == lenB then they both meet at intersection in roiund only
//we move pointers one node at a time . if lenA != lenB they don't meet while moving like that and as we assumed lenA > lenB then 'a' is (lenA-lenB) steps behind  'b'.
//when 'b' reaches nullptr we move it to head A and by the time 'a' reaches the nullptr. 'b' has travelled lenA - lenB . now make 'a' to head of B. 
//'b' to intersection node distance is lenA - (lenA - lenB). == lenB
// ' a' to intersection node distance is lenB

//now when those move again onestep at a time they both meet at the intersection node . so total time is like O(m+n).
//space complexity is O(1) as we are not crerating any extra nodes


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
        //base case where if it empty or only one linked list is there then
        if(!headA || !headB){
            return nullptr;
        }
        ListNode* a = headA;
        ListNode* b = headB;
        while(a != b){
            if(a == nullptr){
                a = headB;
            }
            else{
                a = a->next;
            }
            if(b == nullptr){
                b = headA;
            }
            else{
                b = b->next;
            }
            
        }
        //if there is no intersection then they both will be nullptr
        //if htey meet they meet at the intersection node
        return a;
        
    }
};
