import java.util.*;

public class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int m = words.length;
        int n = puzzles.length;

        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            int mask = mask(words[i]);
            int c = map.getOrDefault(mask, 0);
            c++;
            map.put(mask, c);
        }
        for(int i = 0; i < n; i++){
            int mask = 0;
            mask |= 1 << puzzles[i].charAt(0) - 'a';
            int[] count = new int[1];
            dfs(mask, count, map, puzzles[i], 0);
            res.add(count[0]);

        }


        return res;

    }

    private void dfs(int mask, int[] count, Map<Integer, Integer> map, String puzzle, int i) {
        if(i == puzzle.length()){
            return;
        }
        count[0] += map.getOrDefault(mask, 0);
        for (int j = i + 1; j < puzzle.length(); j++) {
            int temp = mask;
            mask |= 1 << puzzle.charAt(j) - 'a';
            dfs(mask, count, map, puzzle, j);
            mask = temp;

        }
    }

    private boolean isSubMask(int mask1, int firstCh, int mask2) {
        if(((mask2 >> firstCh) & 1) == 0){
            return false;
        }
        return ((mask1 ^ mask2) & mask2) == 0;
    }

    private int mask(String word) {
        int mask = 0;
        for(int i = 0; i < word.length();i++){
            mask |= 1 << (word.charAt(i) - 'a');
        }
        return mask;
    }
}