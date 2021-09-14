class Solution {

    deleteNode(del) {
        //your code here
        del.data = del.next.data;
        del.next = del.next.next;
    }
}