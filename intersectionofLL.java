
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class intersectionofLL<ListNode> {
    
    //   Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }
     
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            int m = getSize(headA);
            int n = getSize(headB);
            int diff = 0;
            if(m > n){
                diff = m - n;
                while(diff > 0){
                    headA = headA.next;
                    diff--;
                }
            }
            if(m < n){
                diff = n - m;
                while(diff > 0){
                    headB = headB.next;
                    diff--;
                }
            }

            while(headA != headB){
                headA = headA.next;
                headB = headB.next;
            }

            return headA;
        }

        private int getSize(ListNode node){

            int length = 0 ;
            while(node != null){
                length++;
                node = node.next;
            }
            return length;
        }
    }