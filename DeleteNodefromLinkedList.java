public class DeleteNodefromLinkedList {


        void deleteNode(ListNode del)
        {
            ListNode temp = del;

            // temp pointer at the next
            del.next = temp;

            //overwriting current node's data with that of the next
            temp.val = del.val;

            // skip the duplicate next
            del.next = temp.next;
        }


}

/* Time Complexity = O(1)
Space Complexity = O(1)
 */