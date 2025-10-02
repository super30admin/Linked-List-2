// Problem - Reorder List
//  Time Complexity : O(n)
//  Space Complexity : O(1)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We start to find the middle of the list and end right before our middle
// 2. We reverse the remaining part of the list from slow->next
// 3. We take two pointers then, move them to merge the two lists and make the
// links to get the desired list

#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for singly-linked list.
 */
struct ListNode {
  int val;
  ListNode *next;
  ListNode() : val(0), next(nullptr) {}
  ListNode(int x) : val(x), next(nullptr) {}
  ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution {
public:
  void reorderList(ListNode *head) {
    // find the middle of the list
    ListNode *fast = head;
    ListNode *slow = head;
    while (fast->next && fast->next->next) {
      fast = fast->next->next;
      slow = slow->next;
    }
    // reverse the list from slow;
    ListNode *curr = slow->next;
    ListNode *prev = nullptr;
    while (curr) {
      ListNode *temp = curr->next;
      curr->next = prev;
      prev = curr;
      curr = temp;
    }

    // reordering it now, reusing the previous pointers
    slow->next = nullptr;
    slow = head;
    fast = prev;
    while (fast && slow) {
      ListNode *temp1 = slow->next;
      slow->next = fast;
      fast = fast->next;
      slow->next->next = temp1;
      slow = temp1;
    }
  }
};
