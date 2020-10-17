/* Problem Statement:
Verified on leetcode

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

begin to intersect at node c1.

 

Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.

 

Example 2:

Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
Output: Reference of the node with value = 2
Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.

 

Example 3:

Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
Output: null
Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
Explanation: The two lists do not intersect, so return null.

 

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.


 *
 * Time Complexity : O(n) 
 * Space Complexity : O(1)
 */

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
#include<math.h>
#include<limits.h>

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    
    struct ListNode *node = NULL, *node2 = NULL;
    int headA_cnt = 0, headB_cnt = 0;
    int diff_cnt = 0;
    /* validation */
    if (!headA || !headB) {
        return NULL;
    }
    /* find length of list 1*/
    node = headA;
    while (node != NULL) {
        node = node->next;
        headA_cnt++;
    }
    /* find length of list 2*/
    node = headB;
    while (node != NULL) {
        node = node->next;
        headB_cnt++;
    }
    /* find difference */
    diff_cnt = headA_cnt - headB_cnt;
    
    /* make sure we start at same point. so longer list should have its pointers moved */
    if (diff_cnt >= 0) {
        headA_cnt = 0;
        node = headA;
        while (headA_cnt < abs(diff_cnt)) {
            node = node->next;
            headA_cnt++;
        }
        node2 = headB;
    } else {
        headB_cnt = 0;
        node2 = headB;
        while (headB_cnt < abs(diff_cnt)) {
            node2 = node2->next;
            headB_cnt++;
        }    
        node = headA;
    }
    /* just scan and return once we find the same element */
    while (node!= NULL && node2 != NULL && node != node2) {
        node = node->next;
        node2 = node2->next;
    }
    return node;  
}
/* Didn't implement a main function. Use leetcode platform to execute it.*/


