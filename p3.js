// ## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)


1 -> 2 -> 3 -> 4
     d

node.val = node.next.val;
node.next = node.next.next;
