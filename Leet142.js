/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var detectCycle = function(head) {
    let fast = head;
    let slow = head;
    while(fast && fast.next)
    {   
        slow = slow.next;
        fast = fast.next.next;
        if(slow===fast)
        {
            while(slow!==head)
            {
                head = head.next;
                slow = slow.next;
            }
            return slow;
        }
         
    }
    return null;
};
