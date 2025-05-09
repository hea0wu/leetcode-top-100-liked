import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NormalArray {
    
    // 最大子数组和：https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE; // 注意答案可以是负数，不能初始化成 0
        int f = 0;
        for (int x : nums) {
            f = Math.max(f, 0) + x;
            ans = Math.max(ans, f);
        }
        return ans;
    }
    // 题解：https://leetcode.cn/problems/maximum-subarray/solutions/2533977/qian-zhui-he-zuo-fa-ben-zhi-shi-mai-mai-abu71/?envType=study-plan-v2&envId=top-100-liked



    // 56.合并区间：https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // 可以合并
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]); // 更新右端点最大值
            } else { // 不相交，无法合并
                ans.add(p); // 新的合并区间
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    // 题解：https://leetcode.cn/problems/merge-intervals/solutions/2798138/jian-dan-zuo-fa-yi-ji-wei-shi-yao-yao-zh-f2b3/?envType=study-plan-v2&envId=top-100-liked



    // 189.轮转数组：https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked
    class Solution {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n; // 轮转 k 次等于轮转 k % n 次
            reverse(nums, 0, n - 1); // 反转整个数组
            reverse(nums, 0, k - 1); // 反转前k个
            reverse(nums, k, n - 1); // 反转后n-k个
        }
        
        private void reverse(int[] nums, int i, int j) {
            while (i < j) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = temp;
            }
        }
    }
    // 题解：https://leetcode.cn/problems/rotate-array/solutions/2784427/tu-jie-yuan-di-zuo-fa-yi-tu-miao-dong-py-ryfv/?envType=study-plan-v2&envId=top-100-liked



    // 238.除自身以外数组的乘积：https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i + 1];
        }

        int pre = 1;
        for (int i = 0; i < n; i++) {
            // 此时 pre 为 nums[0] 到 nums[i-1] 的乘积，直接乘到 suf[i] 中
            suf[i] *= pre;
            pre *= nums[i];
        }

        return suf;
    }
    // 题解：https://leetcode.cn/problems/product-of-array-except-self/solutions/2783788/qian-hou-zhui-fen-jie-fu-ti-dan-pythonja-86r1/?envType=study-plan-v2&envId=top-100-liked



    // 41.缺失的第一个正数：https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 如果当前学生的学号在 [1,n] 中，但（真身）没有坐在正确的座位上
            while (1 <= nums[i] && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // 那么就交换 nums[i] 和 nums[j]，其中 j 是 i 的学号
                int j = nums[i] - 1; // 减一是因为数组下标从 0 开始
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        // 找第一个学号与座位编号不匹配的学生
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 所有学生都坐在正确的座位上
        return n + 1;
    }
    // 题解：https://leetcode.cn/problems/first-missing-positive/solutions/3655377/huan-zuo-wei-tong-guo-li-zi-li-jie-suan-qa94e/?envType=study-plan-v2&envId=top-100-liked




}
