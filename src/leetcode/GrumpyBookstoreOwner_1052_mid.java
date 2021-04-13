package leetcode;

/***
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。
 *
 * 每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 *
 * 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *
 */

public class GrumpyBookstoreOwner_1052_mid {

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy =    {0,1,0,1,0,1,0,1};
        int X = 3;
        System.out.println(maxSatisfied(customers,grumpy,X));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                total += customers[i];
            }
        }
        // 此时 total 的值为 老板未发动秘技留下的客户数

        // 发动秘技： 固定长度X的窗口 ，窗口从左向右移动，
        // 每次移动计算出 因秘技所增加的客户数 ，即 窗口中 grumpy 数组中（grumpy[index]）等于 1 时索引位置对应 customers 数组中客户数(customers[index])的和
        // 每次移动因秘技所增加的客户数的最大值就是 发动秘技所能留下客户数的最大值
        // 最多有多少客户能够感到满意的数量 = 老板未发动秘技留下的客户数 + 发动秘技所能留下客户数的最大值

        // 初始化窗口
        int increase = 0;// 因秘技所增加的客户数
        for(int i = 0; i < X; i++){
            // 不生气是 0 ， 生气是 1 => customers[i] * grumpy[i] 索引为 i 时 因秘技所增加的客户数
            increase += customers[i] * grumpy[i] ;
        }

        int maxIncrease = increase;
        //向右移动窗口
        for(int i = 0; i < customers.length - X; i ++){
            //移动后窗口中因秘技所增加的客户数为 减去现在窗口左边界因秘技所增加的客户数 加上右边界下一个因秘技所增加的客户数
            increase = increase - customers[i] * grumpy[i] + customers[i+X] * grumpy[i+X];
            maxIncrease = Math.max(maxIncrease,increase);
        }
        return total + maxIncrease;

    }
}
