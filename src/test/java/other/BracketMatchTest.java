package other;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 括号匹配问题
 *
 * @author huangxiaodong
 * @date 2022/2/11  14:50
 */
@Slf4j
class BracketMatchTest {

    @Test
    void test() {
        log.info("{}", minAddToMakeValid("()"));
        log.info("{}", minAddToMakeValid("())"));
        log.info("{}", minAddToMakeValid("(()"));
        log.info("{}", minAddToMakeValid("((({"));

        log.info("\n");
        log.info("{}", minInsertions("())"));
        log.info("{}", minInsertions(")"));
        log.info("{}", minInsertions("))"));
        log.info("{}", minInsertions("))())("));
    }

    /**
     * 921. Minimum Add to Make Parentheses Valid
     * Input: s = "())"
     * Output: 1
     */
    public int minAddToMakeValid(String s) {
        int res = 0, need = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                need++;
            } else {
                need--;
                if (need == -1) {
                    need = 0;
                    res++;
                }
            }
        }
        return res + need;
    }

    /**
     * 1541. Minimum Insertions to Balance a Parentheses String
     * Input: s = "(()))"
     * Output: 1
     */
    public int minInsertions(String s) {
        int res = 0, need = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
                need += 2;
            } else {
                need--;
                if (need == -1) {
                    need = 1;
                    res++;
                }
            }
        }
        return res + need;
    }
}
