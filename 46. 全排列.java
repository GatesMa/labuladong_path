// 利用链表
class Solution {
    public List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(nums, path);
        return res;
    }

    public void backtrack(int[] nums, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new LinkedList(path));
            return;
        }
        for (int i = 0;i < nums.length;i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path);
            path.removeLast();
        }
    }
}



// 利用元素交换
class Solution {

    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int pos) {
        if (pos == nums.length) {
            List<Integer> path = new ArrayList<>();
            for (int i : nums) {
                path.add(i);
            }
            res.add(path);
            return;
        }

        for (int i = pos;i < nums.length;i++) {
            swap(nums, pos, i);
            backtrack(nums, pos + 1);
            swap(nums, pos, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
