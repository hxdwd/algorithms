package doublepoint;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import sun.security.util.Length;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CheckedOutputStream;

/**
 * 双指针
 *
 * @author huangxiaodong
 * @date 2022/2/7  10:26
 */
@Slf4j
class DoublePointTest {

    @Test
    void testNo76() {
        log.info("{}", minWindow("EBBANCF", "ABC"));
        log.info("{}", minWindow2("EBBANCF", "ABC"));
    }

    @Test
    void testNo567() {
        log.info("{}", checkInclusion("ab", "ebiabooo"));
        log.info("{}", checkInclusion("ab", "ebiaobooo"));
        log.info("{}", checkInclusion("abcdxabcde", "abcdeabcdx"));

        log.info("{}", checkInclusion2("ebiabooo", "ab"));
        log.info("{}", checkInclusion2("ebiaobooo", "ab"));
        log.info("{}", checkInclusion2("abcdxabcde", "abcdeabcdx"));
    }

    @Test
    void testNo438() {
        log.info("{}", findAnagrams("cbaebabacd", "abc"));
        log.info("{}", findAnagrams2("cbcebabacd", "abc"));
    }


    /**
     * 76
     */
    public String minWindow(String s, String t) {
        // need所需的字典 windows记录当前的个数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;

        // 当right走到尽头
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;

            if (need.containsKey(cur)) {
                // 更新window
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }

            // 尽可能增大left
            while (valid == t.length()) {
                // 缩减最小覆盖str
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char move = s.charAt(left);
                left++;

                if (need.containsKey(move)) {
                    if (window.get(move).equals(need.get(move))) {
                        valid--;
                    }
                    // 更新window
                    window.put(move, window.get(move) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    /**
     * 76. leetCode 另一种解法
     */
    public String minWindow2(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }

        return minLen > s.length() ? "" : s.substring(minLeft, minLeft + minLen);
    }


    /**
     * No.567
     * s2是否包含s1的组合 字符串
     */
    public boolean checkInclusion(String s1, String s2) {
        // need所需的字典 windows记录当前的个数
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;

        while (right < s2.length()) {
            char cur = s2.charAt(right);
            right++;

            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur))) {
                    count++;
                }
            }

            // 缩减窗口
            while (right - left >= s1.length()) {
                if (count == need.size()) {
                    return true;
                }
                char move = s2.charAt(left);
                left++;

                if (need.containsKey(move)) {
                    if (window.get(move).equals(need.get(move))) {
                        count--;
                    }
                    // 更新window
                    window.put(move, window.get(move) - 1);
                }
            }

        }
        return false;
    }

    /**
     * 自己的写法
     */
    public boolean checkInclusion2(String s1, String s2) {
        // need所需的字典 windows记录当前的个数
        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : s2.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = s2.length();

        while (right < s1.length()) {
            char cur = s1.charAt(right);
            right++;

            if (countMap.containsKey(cur)) {
                countMap.put(cur, countMap.get(cur) - 1);
                count--;
            }

            while (right - left >= s2.length()) {
                if (count == 0) {
                    return true;
                }
                char move = s1.charAt(left);
                left++;

                if (countMap.containsKey(move)) {
                    countMap.put(move, countMap.get(move) + 1);
                    count++;
                }
            }

        }
        return false;
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;
        List<Integer> res = new ArrayList<>();

        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;

            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur))) {
                    count++;
                }
            }

            // 满足情况时左移窗口
            while (right - left >= p.length()) {
                if (count == need.size()) {
                    res.add(left);
                }

                char move = s.charAt(left);
                left++;

                if (need.containsKey(move)) {
                    if (window.get(move).equals(need.get(move))) {
                        count--;
                    }
                    window.put(move, window.get(move) - 1);
                }

            }
        }
        return res;
    }

    /**
     * 别人的写法
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        // 这里可以通过char-'a' 减小数组的长度
        int[] hash = new int[256]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right every time, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return list;
    }

    /**
     * No.3
     * 不重复子串的最大长度
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;

        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            while (map.get(cur) > 1) {
                char move = s.charAt(left);
                left++;
                map.put(move, map.get(move) - 1);
            }
            count = Math.max(count, right - left);
        }
        return count;
    }

    /**
     * 另一种写法
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int count = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;

            if (map.containsKey(cur)) {
                left = Math.max(left, map.get(cur) + 1);
            }

            // 这里是将索引作为value
            map.put(s.charAt(right), right);
            count = Math.max(count, right - left + 1);
        }
        return count;
    }

}
