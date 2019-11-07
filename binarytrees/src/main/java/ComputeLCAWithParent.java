public class ComputeLCAWithParent {

    /*
    10.4
    */

    public static BinaryTreeParent<Integer> LCA(BinaryTreeParent<Integer> node0, BinaryTreeParent<Integer> node1) {
        int height0 = 0, height1 = 0;
        BinaryTreeParent<Integer> currentNode = node0, LCA = null;
        while(currentNode.parent != null) {
            height0++;
            currentNode = currentNode.parent;
        }

        currentNode = node1;
        while(currentNode.parent != null) {
            height1++;
            currentNode = currentNode.parent;
        }

        BinaryTreeParent<Integer> largerHeight, smallerHeight;
        if(height0 > height1) {
            largerHeight = node0;
            smallerHeight = node1;
        } else {
            largerHeight = node1;
            smallerHeight = node0;
        }

        int heightDiff = Math.abs(height0 - height1);
        while(heightDiff-- > 0 && largerHeight != null) {
            largerHeight = largerHeight.parent;
        }

        while(largerHeight != null && smallerHeight != null) {
            if(largerHeight.data.equals(smallerHeight.data)) {
                LCA = largerHeight;
                largerHeight = null;
            } else {
                largerHeight = largerHeight.parent;
                smallerHeight = smallerHeight.parent;
            }
        }

        return LCA;
    }
}
