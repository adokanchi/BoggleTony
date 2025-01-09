import java.util.ArrayList;
import java.util.Arrays;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Convert dictionary to Trie
        Trie dict = new Trie();
        for (String s : dictionary) dict.add(s);

        // Search for words
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, dict, goodWords);
            }
        }

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    // Starting from startRow and startCol, search board for words in dictionary and add to goodWords
    private static void dfs(int startRow, int startCol, char[][] board, Trie dictionary, ArrayList<String> goodWords) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        dfsRecurse(startRow, startCol, "", board, visited, dictionary, goodWords);
    }

    // Recursive helper method for dfs()
    private static void dfsRecurse(int row, int col, String prefix, char[][] board, boolean[][] visited, Trie dictionary, ArrayList<String> goodWords) {
        if (row < 0 || col < 0 || row >= visited.length || col >= visited[row].length) return;
        if (visited[row][col]) return;
        prefix += board[row][col];
        if (!isValidPrefix(prefix, dictionary)) return;
        if (isValidWord(prefix, dictionary)) goodWords.add(prefix);

        visited[row][col] = true;

        dfsRecurse(row + 1, col, prefix, board, visited, dictionary, goodWords);
        dfsRecurse(row - 1, col, prefix, board, visited, dictionary, goodWords);
        dfsRecurse(row, col + 1, prefix, board, visited, dictionary, goodWords);
        dfsRecurse(row, col - 1, prefix, board, visited, dictionary, goodWords);

        visited[row][col] = false;
    }

    private static boolean isValidPrefix(String prefix, Trie dictionary) {
        // TODO
        return false;
    }

    private static boolean isValidWord(String prefix, Trie dictionary) {
        // TODO
        return false;
    }


}
