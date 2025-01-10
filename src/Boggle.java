import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Boggle {
    private static ArrayList<String> goodWords;
    public static String[] findWords(char[][] board, String[] dictionary) {

        goodWords = new ArrayList<String>();

        // Convert dictionary to Trie
        Trie dict = new Trie();
        for (String s : dictionary) dict.add(s);

        // Search for words
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, dict);
            }
        }

        // Remove duplicates from goodWords
        Set<String> set = new HashSet<String>(goodWords);
        goodWords = new ArrayList<>(set);

        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }

    // Starting from startRow and startCol, search board for words in dictionary and add to goodWords
    private static void dfs(int startRow, int startCol, char[][] board, Trie dictionary) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        dfsRecurse(startRow, startCol, "", board, visited, dictionary);
    }

    // Recursive helper method for dfs()
    private static void dfsRecurse(int row, int col, String prefix, char[][] board, boolean[][] visited, Trie dictionary) {
        if (row < 0 || col < 0 || row >= visited.length || col >= visited[row].length) return;
        if (visited[row][col]) return;
        prefix += board[row][col];
        if (!dictionary.isValidPrefix(prefix)) return;
        if (dictionary.search(prefix)) goodWords.add(prefix);

        visited[row][col] = true;

        dfsRecurse(row + 1, col, prefix, board, visited, dictionary);
        dfsRecurse(row - 1, col, prefix, board, visited, dictionary);
        dfsRecurse(row, col + 1, prefix, board, visited, dictionary);
        dfsRecurse(row, col - 1, prefix, board, visited, dictionary);

        visited[row][col] = false;
    }
}
