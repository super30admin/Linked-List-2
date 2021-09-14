// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
var reorderList = function (head) {

    if (!head || !head.next) return;

    //Finding the Middle Element
    let slow = head;
    let fast = head;
    while (fast.next && fast.next.next) {
        slow = slow.next;
        fast = fast.next.next;
    }

    //Reverse the second Half
    fast = reverseList(slow.next);
    slow.next = null;
    slow = head;
    //Merge the two Halves
    let temp;
    while (fast) {
        temp = slow.next;
        slow.next = fast;
        fast = fast.next;
        slow.next.next = temp;
        slow = temp;
    }

};

var reverseList = function (head) {
    let prev = null;
    let current = head;
    let fast = head.next;
    while (fast) {
        current.next = prev;
        prev = current;
        current = fast;
        fast = fast.next;
    }
    current.next = prev;
    return current;
}

