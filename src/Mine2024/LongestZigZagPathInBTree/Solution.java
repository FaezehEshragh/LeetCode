package Mine2024.LongestZigZagPathInBTree;


class Solution {
    public int longestZigZag(TreeNode root) {

        // if root is null return 0
        if (root == null)
        {
            return 0;
        }
        int longestZigZagPath = 0;
        int currentZigZagPath = 0;
        TreeNode currentNode = root;
        TreeNode rightNode;

            int leftZigZagPath = longestZigZagStartingFrom(currentNode.left);
            longestZigZagPath = Math.max(longestZigZagPath, leftZigZagPath);


        rightNode = currentNode.right;

            currentZigZagPath = currentZigZagPath + longestZigZagStartingFrom(currentNode.right);
            longestZigZagPath = Math.max(longestZigZagPath, currentZigZagPath);


        return longestZigZagPath;
    }

    private int longestZigZagStartingFrom(TreeNode root)
    {
        if(root == null){
            return 0;
        }
        int longestZigZagPath = 0;
        int currentZigZagPath = 0;
        TreeNode currentNode = root;
        int longestZigZagPathLeft = getOneWayPath(currentNode, false, currentZigZagPath, longestZigZagPath);

        currentNode = root;

        int longestZigZagPathRight = getOneWayPath(currentNode, true, currentZigZagPath, longestZigZagPath);

        return Math.max(longestZigZagPathLeft,longestZigZagPathRight);
    }

    private int getOneWayPath(TreeNode currentNode, boolean isPrevLeft, int currentZigZagPath, int longestZigZagPath)
    {
        TreeNode leftNode;
        TreeNode rightNode;
        while(currentNode !=null){
            if(!isPrevLeft){
                leftNode = currentNode.left;
                if(leftNode!=null){
                    currentZigZagPath++;
                    longestZigZagPath = Math.max(longestZigZagPath, currentZigZagPath);
                    isPrevLeft = true;
                }
                currentNode = leftNode;
            } else{
                rightNode = currentNode.right;
                if(rightNode!=null){
                    currentZigZagPath =  currentZigZagPath + longestZigZagStartingFrom(rightNode);
                    longestZigZagPath = Math.max(longestZigZagPath, currentZigZagPath);
                    isPrevLeft = false;

                }
                currentNode = rightNode;

            }

        }
        return longestZigZagPath;
    }
}
