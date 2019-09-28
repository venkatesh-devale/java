package app;

public class NQueenProblemCount {

    public static void main(String[] args) {
        int n = 4;
        Position[] positions = new Position[n];
        System.out.println(backtrackQueen(0,0,n,positions));
    }

    private static int backtrackQueen(int row, int count, int n, Position[] positions) {

        // Start looking for the queens placement
        for(int col=0;col<n;col++) {

            // Check if the current position is under attack
            if(isNotUnderAttack(row, col, positions)) {
                // Place the queen
                positions[row] = new Position(row, col);

                // Check whether we reached the last row if yes increment the count
                if(row+1 == n) {
                    count += 1;
                } else {
                    // Not got the complete solution hence back track again with next row
                    count = backtrackQueen(row+1, count, n, positions);
                }
            }
        }
        return count;
    }

    private static boolean isNotUnderAttack(int row, int col, Position[] positions) {
        boolean foundSafe = true;

        // Check for the queens placed until this row and see for any attack
        for(int queen = 0; queen < row; queen++) {
            if(positions[queen] == null || positions[queen].col == col ||
                    positions[queen].row == row ||
                    positions[queen].row + positions[queen].col == col + row ||
                    positions[queen].row - positions[queen].col == row - col
            ) {
                foundSafe = false;
                break;
            }
        }
        return foundSafe;
    }

}
