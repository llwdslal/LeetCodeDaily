package leetcode.all;
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
//
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V +
//II 。
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//
//
// 给定一个罗马数字，将其转换成整数。
//
//
//
// 示例 1:
//
//
//输入: s = "III"
//输出: 3
//
// 示例 2:
//
//
//输入: s = "IV"
//输出: 4
//
// 示例 3:
//
//
//输入: s = "IX"
//输出: 9
//
// 示例 4:
//
//
//输入: s = "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
//
//
// 示例 5:
//
//
//输入: s = "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
//
//
//
// 提示：
//
//
// 1 <= s.length <= 15
// s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
// 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
// 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
// IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
// 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
//
// Related Topics 哈希表 数学 字符串
// 👍 1652 👎 0

public class _13罗马数字转整数_简单 {

    public static void main(String[] args) {
        _13罗马数字转整数_简单 test = new _13罗马数字转整数_简单();
        // IV IX MCMXCIV
        System.out.println(test.romanToInt("MCMXCIV"));
    }
    /*
    按照题目的描述，可以总结如下规则：

罗马数字由 I,V,X,L,C,D,M 构成；
当小值在大值的左边，则减小值，如 IV=5-1=4；
当小值在大值的右边，则加小值，如 VI=5+1=6；
由上可知，右值永远为正，因此最后一位必然为正。
一言蔽之，把一个小值放在大值的左边，就是做减法，否则为加法。

作者：donespeak
链接：https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int romanToInt(String s){
        int sum = 0;
        int current = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int next = getValue(s.charAt(i));
            if (current < next){
                sum -= current;
            }else {
                sum +=current;
            }
            current = next;
        }
        sum +=current;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }



//    public int romanToInt(String s) {
//        if (s == null || s.length() == 0 || s.length() > 15) return  -1;
//        boolean hasFlag = false;
//        int result = 0;
//        int lastIndex = s.length() - 1;
//        for (int i = 0; i <= lastIndex; i++) {
//            char ch = s.charAt(i);
//            char next = '!';
//            if (i + 1 <= lastIndex){
//                next = s.charAt(i+1);
//            }
//
//            switch (ch){
//                case 'C':
//                    if (next == 'D' || next == 'M'){
//                        hasFlag = true;
//                        continue;
//                    }else{
//                        result += hasFlag ? 90 : 100;
//                    }
//                    break;
//                case 'X':
//                    if (next == 'L' || next == 'C'){
//                        hasFlag = true;
//                        continue;
//                    }else{
//                        result +=  hasFlag ? 9 : 10;
//                    }
//                    break;
//                case 'I':
//                    if (next == 'V' || next == 'X'){
//                        hasFlag = true;
//                        continue;
//                    }else{
//                        result += 1;
//                    }
//                    break;
//                case 'M':
//                    result += hasFlag ? 900 : 1000;
//                    break;
//                case 'D':
//                    result += hasFlag ? 400 : 500;
//                    break;
//                case 'L':
//                    result += hasFlag ? 40 : 50;
//                    break;
//                case 'V':
//                    result += hasFlag ? 4 : 5;
//                    break;
//            }
//            hasFlag = false;
//        }
//        return result;
//    }



}
