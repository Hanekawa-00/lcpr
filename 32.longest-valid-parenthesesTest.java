import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testLongestValidParentheses1() {
        Solution solution = new Solution();
        assertEquals(2, solution.longestValidParentheses("(()"));
    }

    @Test
    void testLongestValidParentheses2() {
        Solution solution = new Solution();
        assertEquals(4, solution.longestValidParentheses(")()())"));
    }

    @Test
    void testLongestValidParentheses3() {
        Solution solution = new Solution();
        assertEquals(0, solution.longestValidParentheses(""));
    }

    @Test
    void testLongestValidParentheses4() {
        Solution solution = new Solution();
        assertEquals(6, solution.longestValidParentheses("()(()))"));
    }

    @Test
    void testLongestValidParentheses5() {
        Solution solution = new Solution();
        assertEquals(4, solution.longestValidParentheses("()()"));
    }
}