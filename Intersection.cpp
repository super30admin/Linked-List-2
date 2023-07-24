// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

/*
In this problem, we first find the length of both the linked lists and then check which link lost is shorter
we will try to node of the longer linked list from which both the linked lists are equidistant from.
from there we will check each node from both linked lists. if it equates to the same node, then we will return true
else false;
*/


// Your code here along with comments explaining your approach
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
        ListNode* currA = headA;
        ListNode* currB = headB;

        int cntA=0;
        int cntB=0;

        int count=0;
    

        while(currA != NULL){
            currA=currA->next;
            cntA++;

        }

        while(currB!= NULL){
            currB=currB->next;
            cntB++;

        }

        int diff = abs(cntA-cntB);

        if(cntA < cntB){
            currB = headB;
             currA = headA;

            while(count <  diff){

                count++;
                currB=currB->next;

            }

            while(currA != NULL && currB != NULL){

                if(currA == currB){
                    return currA;
                }

                currA=currA->next;
                currB=currB->next;



                

            }

            return NULL;




        }

        else{
            count=0;
             currB = headB;
             currA = headA;

            while(count <  diff){

                count++;
                currA=currA->next;

            }

            while(currA != NULL && currB != NULL){

                if(currA == currB){
                    return currA;
                }

                currA=currA->next;
                currB=currB->next;



                

            }

            return NULL;




        }

        return NULL;





        
    }
};