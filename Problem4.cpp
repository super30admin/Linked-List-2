// Problem - Intersection of two lists
//  Time Complexity : O(m+n) m and n length of two lists
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We start with two pointers for both the lists
// 2. If one of pointers reaches null, we move it to the other list's head, this
// way both list cover same length
// 3. if at any point both pointers are null, that means we have reached the end
// of both list without intersectiion
#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for singly-linked list.
 */
struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
  ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
    ListNode *currA = headA;
    ListNode *currB = headB;
    while (currA != currB) {
      currA = currA->next;
      currB = currB->next;
      if (currA == nullptr && currB == nullptr)
        return nullptr;
      if (currA == nullptr) {
        currA = headB;
      }
      if (currB == nullptr) {
        currB = headA;
      }
    }

    return currA;
  }
};
