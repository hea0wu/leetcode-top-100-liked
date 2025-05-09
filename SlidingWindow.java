import java.util.ArrayList;
import java.util.List;

public class SlidingWindow {
    
    // 3.无重复字符的最长字串：https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray(); // 转换成 char[] 加快效率（忽略带来的空间消耗）
        int n = s.length;
        int ans = 0;
        int left = 0;
        boolean[] has = new boolean[128]; // 也可以用 HashSet<Character>，这里为了效率用的数组
        for (int right = 0; right < n; right++) {
            char c = s[right];
            // 如果窗口内已经包含 c，那么再加入一个 c 会导致窗口内有重复元素
            // 所以要在加入 c 之前，先缩小窗口直到窗口内的 c 被移出
            while (has[c]) { // 窗口内有 c
                has[s[left]] = false;
                left++; // 缩小窗口
            }
            has[c] = true; // 加入 c
            ans = Math.max(ans, right - left + 1); // 更新窗口长度最大值
        }
        return ans;
    }
    // 题解：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/1959540/xia-biao-zong-suan-cuo-qing-kan-zhe-by-e-iaks/?envType=study-plan-v2&envId=top-100-liked
    // 滑动窗口讲解视频：https://www.bilibili.com/video/BV1hd4y1r7Gq?vd_source=f42bf25a3f3373fb412a6bdda2c93f4e&spm_id_from=333.788.videopod.sections



    // 438.找到字符串中所有字母异位词：https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cnt = new int[26]; // 统计 p 的每种字母的出现次数
        for (char c : p.toCharArray()) {
            cnt[c - 'a']++;
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int c = s.charAt(right) - 'a';
            cnt[c]--; // 右端点字母进入窗口
            while (cnt[c] < 0) { // 字母 c 太多了
                cnt[s.charAt(left) - 'a']++; // 左端点字母离开窗口
                left++;
            }
            if (right - left + 1 == p.length()) { // s' 和 p 的每种字母的出现次数都相同
                ans.add(left); // s' 左端点下标加入答案
            }
        }
        return ans;
    }
    // 题解：https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/2969498/liang-chong-fang-fa-ding-chang-hua-chuan-14pd/?envType=study-plan-v2&envId=top-100-liked


}