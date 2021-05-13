package mid;

import java.util.LinkedList;
import java.util.List;

/**
 * 17 mid 组合字符
 *
 * @author huangxiaodong
 * @date 2021/5/13  23:03
 */
public class LetterCombination {

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // 初始化
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            // 获取单个字符，类型为 int
            int x = Character.getNumericValue(digits.charAt(i));
            while (res.peek().length() == i) {
                String temp = res.remove();
                for (char c : mapping[x].toCharArray()) {
                    res.add(temp + c);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
