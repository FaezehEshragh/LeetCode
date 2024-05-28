package Mine2024.linkedList.deleteMiddleElementOfLinkedList;


//Definition for singly-linked list.


class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        ListNode updated = deleteMiddle(head);
        System.out.println("done");
    }
    public static ListNode deleteMiddle(ListNode head) {

        // get the size
        int length=0; //for head
        ListNode current = head;
        while (current!= null){
            length++;
            current = current.next;
        }
        // find the middle one
        // 7 => 3
        //4 =>2
        //2 => 1
        int middle = (length/2);

        //remove it
        int currentIndex=0;
        ListNode beforeMiddle = head;
        while (currentIndex<middle-1){
            beforeMiddle = beforeMiddle.next;
            currentIndex++;
        }

        if(beforeMiddle.next!=null){
            beforeMiddle.next = beforeMiddle.next.next;
        }
        return head;
    }
}


