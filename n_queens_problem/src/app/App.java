package app;


public class App {

    public static void main(String[] args) throws Exception {
        int n = 4;
        Position[] positions = new Position[n];
        boolean hasSolution = nQueenProblemHelper(n, 0, positions);
        System.out.println(hasSolution);
        for(Position position: positions) {
            System.out.println(position.row + ", " + position.col);
        }
    }

    private static boolean nQueenProblemHelper(int n, int row, Position[] positions) {
        if(n == row) {
            return true;
        }

        int col = 0;
        for(col = 0; col < n; col++) {
            boolean foundSafe = true;
            for(int queen = 0; queen < row; queen++) {
                if(positions[queen].col == col ||
                    positions[queen].row == row ||
                    positions[queen].row + positions[queen].col == col + row ||
                    positions[queen].row - positions[queen].col == row - col
                ) {
                    foundSafe = false;
                    break;
                }
            }

            if(foundSafe) {
                positions[row] = new Position(row, col);
                if(nQueenProblemHelper(n, row+1, positions)) {
                    return true;
                }

            }
        }
        return false;
    }

    
}