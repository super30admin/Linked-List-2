/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/*
Algorithm:
1: calculate length of both the lists 
2: bring the pointers to be be equidistant from intersection point by traversing the larger length list until len2 > len2, do curr2 = curr2.next;

3. At this step, the poitners are quidistant from intersection point. traverse both point step by step. Where they meet is the intersecton point.

time complexity: O(n)
spcace compelxity : O(1)
*/
public class IntersectionList {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        
        
        //calculate len1
        int len1 = 0;
        ListNode curr1 = head1;
        while(curr1 != null){
            len1++;
            curr1 = curr1.next;
        }
        
        //calculate len2
        int len2 = 0;
        ListNode curr2 = head2;
        while(curr2 != null){
            len2++;
            curr2 = curr2.next;
        }
        
        curr1 = head1;
        curr2 = head2;
        while(len1 > len2){
            curr1 = curr1.next;
            len1--;
        }
        
        while(len2 > len1){
            curr2 = curr2.next;
            len2--;
        }
        
        //here we have bought pointers to be equidistant from the intersection point
        while(curr1 != curr2){
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        
        return curr1;
        
    }
}