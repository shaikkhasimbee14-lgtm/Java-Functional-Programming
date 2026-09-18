/*
Task Name: Java Visitor Pattern

Problem Statement:
Implement three visitors:

1. SumInLeavesVisitor:
   Return the sum of values stored in leaf nodes.

2. ProductOfRedNodesVisitor:
   Return the product of values stored in all red nodes,
   including red leaves, modulo 1000000007.

3. FancyVisitor:
   Return the absolute difference between:
   - The sum of values of non-leaf nodes at even depth.
   - The sum of values of green leaf nodes.

Sample Input:
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5

Sample Output:
24
40
15

Note:
HackerRank provides Tree, TreeNode, TreeLeaf, TreeVis and
the locked Solution code. Only the three visitor classes
need to be implemented.
*/

class SumInLeavesVisitor extends TreeVis{
    private int result=0;
    public int getResult(){
        return result;
    }
    public void visitNode(TreeNode node){
    }
    public void visitLeaf(TreeLeaf leaf){
        result+=leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis{
    private long result=1;
    private final int MOD=1000000007;
    public int getResult(){
        return(int)result;
    }
    public void visitNode(TreeNode node){
        if(node.getColor()==Color.RED){
            result=(result*node.getValue())%MOD;
        }
    }
    public void visitLeaf(TreeLeaf leaf){
        if(leaf.getColor()==Color.RED){
            result=(result*leaf.getValue())%MOD;
        }
    }
}
class FancyVisitor extends TreeVis{
    private int nodeSum=0;
    private int leafSum=0;
    public int getResult(){
        return Math.abs(nodeSum-leafSum);
    }
    public void visitNode(TreeNode node){
        if(node.getDepth()%2==0){
            nodeSum+=node.getValue();
        }
    }
    public void visitLeaf(TreeLeaf leaf){
        if(leaf.getColor()==Color.GREEN){
            leafSum+=leaf.getValue();
        }
    }
}