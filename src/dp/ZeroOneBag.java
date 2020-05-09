package dp;

import array.Array;

import java.util.Arrays;

public class ZeroOneBag {

    public static void main(String[] args) {
        int[] weight = new int[]{2,2,4,6,3};
        int n = 5;
        int w = 9;
        ZeroOneBag zeroOneBag = new ZeroOneBag();
        zeroOneBag.knapsack2(weight, n ,w);
    }

    public int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w+1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= w) {
            states[items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w-items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j]==true) states[j+items[i]] = true;
            }
        }

        System.out.println(Arrays.toString(states));
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }

}
