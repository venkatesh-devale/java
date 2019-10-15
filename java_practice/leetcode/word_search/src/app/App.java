package app;


// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]

public class App {
    public static void main(String[] args) throws Exception {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean helper(char[][] board, String word, int i, int j, int index) {
        
        if(index == word.length())
            return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        board[i][j] = '#';
        int newIndex = index+1;
        boolean result = helper(board, word, i, j+1, newIndex) ||
                        helper(board, word, i+1, j, newIndex) ||
                        helper(board, word, i, j-1, newIndex) ||
                        helper(board, word, i-1, j, newIndex);
        
        board[i][j] = word.charAt(index);
        return result;
    }
}