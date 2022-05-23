
//Time Complexity: O(1)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes

class Solution {
    void deleteNode(Node del) {
        del.data = del.next.data;
        del.next = del.next.next;
        // Your code here
    }
}