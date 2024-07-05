package Mine2024.MergeMultiLevelDoublyLinkedList;

import java.util.Stack;

import Mine2024.linkedList.deleteMiddleElementOfLinkedList.ListNode;

public class Solution
{
    public static void main(String[] args){

    }

    public ListNode merge(ListNode doublyList){

        ListNode root = doublyList;
        ListNode currentNode = doublyList;
        Stack<ListNode> stack = new Stack<>();

        while(currentNode!=null){
            if(currentNode.child != null){
                stack.push(currentNode.next);
                currentNode.next = currentNode.child;
                currentNode.child.prev = currentNode;
                currentNode = currentNode.child;
            } else if(currentNode.next!=null){
                currentNode = currentNode.next;
            } else{
                currentNode = stack.pop();
            }
        }


        return root;
    }



    public class ListNode{
        int value;
        ListNode prev;
        ListNode next;
        ListNode child;
    }
}
