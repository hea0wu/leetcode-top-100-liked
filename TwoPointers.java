import java.util.*;

public class TwoPointers {

    // 283.移动零：https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
    public void moveZeroes(int[] nums) {
        int i0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交换 nums[i] 和 nums[i0]
                int tmp = nums[i];
                nums[i] = nums[i0];
                nums[i0] = tmp;
                i0++;
            }
        }
    }
    // 题解：https://leetcode.cn/problems/move-zeroes/solutions/2969353/kuai-man-zhi-zhen-wei-shi-yao-ke-yi-ba-s-1h8x/?envType=study-plan-v2&envId=top-100-liked



    // 11.盛最多水的容器：https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                // height[left] 与右边的任意线段都无法组成一个比 ans 更大的面积
                left++;
            } else {
                // height[right] 与左边的任意线段都无法组成一个比 ans 更大的面积
                right--;
            }
        }
        return ans;
    }
    // 题解：https://leetcode.cn/problems/container-with-most-water/solutions/1974355/by-endlesscheng-f0xz/?envType=study-plan-v2&envId=top-100-liked
    // 盛最多水的容器 接雨水视频讲解：https://www.bilibili.com/video/BV1Qg411q7ia/?vd_source=f42bf25a3f3373fb412a6bdda2c93f4e



    // 42.接雨水：https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int preMax = 0; // 前缀最大值，随着左指针 left 的移动而更新
        int sufMax = 0; // 后缀最大值，随着右指针 right 的移动而更新
        while (left < right) { // while 循环可以不加等号，因为在「谁小移动谁」的规则下，相遇的位置一定是最高的柱子，这个柱子是无法接水的
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            ans += preMax < sufMax ? preMax - height[left++] : sufMax - height[right--];
        }
        return ans;
    }
    // 题解：https://leetcode.cn/problems/trapping-rain-water/solutions/1974340/zuo-liao-nbian-huan-bu-hui-yi-ge-shi-pin-ukwm/?envType=study-plan-v2&envId=top-100-liked
    // 盛最多水的容器 接雨水视频讲解：https://www.bilibili.com/video/BV1Qg411q7ia/?vd_source=f42bf25a3f3373fb412a6bdda2c93f4e


    
    // 15.三数之和：https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue; // 跳过重复数字
            if (x + nums[i + 1] + nums[i + 2] > 0) break; // 优化一：若目前最小三数之和>0，就不可能有三数之和=0
            if (x + nums[n - 2] + nums[n - 1] < 0) continue; // 优化二：若当前i与最大的2数之和都<0，则当前i不可能使得三数和为0
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) {
                    k--;
                } else if (s < 0) {
                    j++;
                } else { // 三数之和为 0
                    ans.add(List.of(x, nums[j], nums[k]));
                    for (j++; j < k && nums[j] == nums[j - 1]; j++); // 跳过重复数字
                    for (k--; k > j && nums[k] == nums[k + 1]; k--); // 跳过重复数字
                }
            }
        }
        return ans;
    }
    // 题解：https://leetcode.cn/problems/3sum/solutions/1968332/shuang-zhi-zhen-xiang-bu-ming-bai-yi-ge-pno55/?envType=study-plan-v2&envId=top-100-liked
    // 两数之和、三数之和视频讲解：https://www.bilibili.com/video/BV1bP411c7oJ/?spm_id_from=333.1387.collection.video_card.click&vd_source=f42bf25a3f3373fb412a6bdda2c93f4e

}