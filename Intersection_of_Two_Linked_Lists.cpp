//
//  main.cpp
//  160_Intersection_of_Two_Linked_Lists

#include <iostream>
#include <unordered_map>
using namespace std;

class ListNode {
public:
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


class Solution {
public:
    //Using hashmap. TC: O(N+M) , SC: O(N), N = size of first list, M = size of second list
     ListNode* getIntersectionNode(ListNode *headA, ListNode *headB) {
         if(headA==NULL || headB==NULL)
             return NULL;
         unordered_map<ListNode *, int> t;
         while(headA!=NULL){
             t[headA]=t[headA]+1;
             headA=headA->next;
         }
         while(headB!=NULL){
             if(t.find(headB)!=t.end())
                 return headB;
             headB=headB->next;
         }
         return NULL;
     }
    
     //Find the size of both list. move the larger list pointer until both size are equal. keep traversing both list and compare nodes iwth each other. if the nodes are same return the node.
    //TC: O(N+M) SC:O(1),  N = size of first list, M = size of second list
     ListNode* getIntersectionNode1(ListNode *headA, ListNode *headB) {
         if(headA==NULL || headB==NULL)
             return NULL;
         int sizeA=0, sizeB=0;
         ListNode *A = headA;
         ListNode *B = headB;
         //size of listA
         while(A!=NULL){
             sizeA++;
             A=A->next;
         }
         
         //size of listB
         while(B!=NULL){
             sizeB++;
             B=B->next;
         }
         
         A = headA;
         B = headB;
         
         //compare size
         if(sizeA>sizeB){
             while(sizeA!=sizeB){
                 sizeA--;
                 A=A->next;
             }
         }
         else{
             while(sizeA!=sizeB){
                 sizeB--;
                 B=B->next;
             }
         }
    
         //Traverse and compare nodes
        while(A != NULL && B != NULL){
            if(A==B) return A;
            A=A->next;
            B=B->next;
        }
        return NULL;
    }
};

int main(int argc, const char * argv[]) {
   
      ListNode* newNode;
    
      // Addition of new nodes
      ListNode* head1 = new ListNode();
      head1->val = 2;
    
      ListNode* head2 = new ListNode();
      head2->val = 3;
    
      newNode = new ListNode();
      newNode->val = 4;
      head2->next = newNode;
    
      newNode = new ListNode();
      newNode->val = 5;
      head2->next->next = newNode;
    
      newNode = new ListNode();
      newNode->val = 6;
      head1->next = newNode;
      head2->next->next->next = newNode;
    
      newNode = new ListNode();
      newNode->val = 7;
      head1->next->next = newNode;
    
      head1->next->next->next = NULL;
    
    Solution s;
    cout << "The node of intersection is " << s.getIntersectionNode(head1, head2)->val<<endl;
}
