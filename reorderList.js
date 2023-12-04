//Problem2 (https://leetcode.com/problems/reorder-list/)
//Accepted in Leetcode
//TC is O(n) and SC is O(1)

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {

    let slow = head;
    let fast = head;

    while(fast != null && fast.next != null ){
        slow=slow.next;
        fast= fast.next.next;
    }

    let reverseSecondHalf = reverse(slow.next);
    slow.next = null;
    slow=head;

    while(reverseSecondHalf!=null){
        let temp= slow.next;
        slow.next= reverseSecondHalf;
        reverseSecondHalf = reverseSecondHalf.next;
        slow.next.next = temp;
        slow= temp;
    }
    

    function reverse(head){
        let curr = head;
        let prev= null

        while(curr!= null){
            let temp = curr.next;
            curr.next = prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

     
    
};