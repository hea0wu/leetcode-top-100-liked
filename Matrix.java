import java.util.ArrayList;
import java.util.List;

public class Matrix {
    
    // 73.矩阵置零：https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
    public void setZeroes(int[][] matrix) {
        boolean col0_flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0_flag = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0_flag) matrix[i][0] = 0;
        }
    }
    // 题解：https://leetcode.cn/problems/set-matrix-zeroes/solutions/6594/o1kong-jian-by-powcai/?envType=study-plan-v2&envId=top-100-liked



    // 54.螺旋矩阵：https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        List<Integer> ans = new ArrayList<>(size); // 预分配空间
        int i = 0;
        int j = -1; // 从 (0, -1) 开始
        for (int di = 0; ans.size() < size; di = (di + 1) % 4) {
            for (int k = 0; k < n; k++) { // 走 n 步（注意 n 会减少）
                i += DIRS[di][0];
                j += DIRS[di][1]; // 先走一步
                ans.add(matrix[i][j]); // 再加入答案
            }
            int tmp = n;
            n = m - 1; // 减少后面的循环次数（步数）
            m = tmp;
        }
        return ans;
    }
    // 题解：https://leetcode.cn/problems/spiral-matrix/solutions/2966229/liang-chong-fang-fa-jian-ji-gao-xiao-pyt-4wzk/?envType=study-plan-v2&envId=top-100-liked



    // 48.旋转图像：https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 第一步：转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { // 遍历对角线下方元素
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 第二步：行翻转
        for (int[] row : matrix) {
            for (int j = 0; j < n / 2; j++) { // 遍历左半元素
                int tmp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = tmp;
            }
        }
    }
    // 题解：https://leetcode.cn/problems/rotate-image/solutions/3655166/shu-xue-ben-zhi-liang-ci-fan-zhuan-deng-aon4a/?envType=study-plan-v2&envId=top-100-liked



    // 240.搜索二维矩阵II：https://leetcode.cn/problems/search-a-2d-matrix-ii/description/?envType=study-plan-v2&envId=top-100-liked
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1; // 从右上角开始
        while (i < matrix.length && j >= 0) { // 还有剩余元素
            if (matrix[i][j] == target) {
                return true; // 找到 target
            }
            if (matrix[i][j] < target) {
                i++; // 这一行剩余元素全部小于 target，排除
            } else {
                j--; // 这一列剩余元素全部大于 target，排除
            }
        }
        return false;
    }
    // 题解：https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/2783938/tu-jie-pai-chu-fa-yi-tu-miao-dong-python-kytg/?envType=study-plan-v2&envId=top-100-liked
    
}