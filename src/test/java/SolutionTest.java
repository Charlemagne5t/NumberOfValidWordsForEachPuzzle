import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SolutionTest {
    @Test
    public void test1() {
        String[] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};

        List<Integer> expected = new ArrayList<>(List.of(1,1,3,2,4,0));
        List<Integer> actual = new Solution().findNumOfValidWords(words, puzzles);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String[] words = {"apple","pleas","please"};
        String[] puzzles = {"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};

        List<Integer> expected = new ArrayList<>(List.of(0,1,3,2,0));
        List<Integer> actual = new Solution().findNumOfValidWords(words, puzzles);

        Assert.assertEquals(expected, actual);
    }
}
