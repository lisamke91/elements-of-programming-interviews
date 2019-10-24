public class ArrayBootcampProblem {
    /*
     * Your input is an array of integers,and you have to reorder its entries so that the even entries appear first.
     * This is easy if you use 0(n) space,where n is the length of the array.
     *
     * You are required to solve it without allocating additional storage.
     */
    public static int [] reorderArr(int [] inputArr) {
        int frontIndex = 0, backIndex = inputArr.length -1;
        while(frontIndex <= backIndex) {
            if(inputArr[frontIndex] % 2 == 1) {
                if(inputArr[backIndex] % 2 == 0) {
                    // swap
                    int temp = inputArr[frontIndex];
                    inputArr[frontIndex] = inputArr[backIndex];
                    inputArr[backIndex] = temp;

                    frontIndex++;
                    backIndex--;
                } else {
                    backIndex--;
                }
            } else {
                frontIndex++;
            }
        }

        return inputArr;
    }
}
