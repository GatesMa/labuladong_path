// 暴力递归
class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}


// 备忘录，剪枝
class Solution {
    public int fib(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }
    public int helper(int[] memo, int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        }
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
}

// 迭代
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for (int i = 3;i <= n;i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}

// 迭代+状态压缩
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1 || n == 2) return 1;
        int pre = 1;
        int cur = 1;
        for (int i = 3;i <= n;i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}