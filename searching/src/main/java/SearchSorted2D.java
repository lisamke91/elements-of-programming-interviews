import java.util.List;

public class SearchSorted2D {

    /*
    12.6
    */

    public static boolean search(List<List<Integer>> matrix, int x) {
        int [][] arr = new int[matrix.size()][matrix.get(0).size()];

        int index = 0;
        for(List<Integer> row : matrix) {
            for(int i = 0; i < row.size(); i++) {
                arr[index][i] = row.get(i);
            }
            index++;
        }

        int row = 0, col = arr[0].length - 1;

        while(row < arr.length && col >= 0) {
            if(arr[row][col] == x) {
                return true;
            } else if(arr[row][col] < x) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
