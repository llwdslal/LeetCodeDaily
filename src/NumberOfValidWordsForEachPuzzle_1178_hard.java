import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *
 *外国友人仿照中国字谜设计了一个英文版猜字谜小游戏，请你来猜猜看吧。
 *
 * 字谜的迷面 puzzle 按字符串形式给出，如果一个单词 word 符合下面两个条件，那么它就可以算作谜底：
 *
 * 单词 word 中包含谜面 puzzle 的第一个字母。
 * 单词 word 中的每一个字母都可以在谜面 puzzle 中找到。
 * 例如，如果字谜的谜面是 "abcdefg"，那么可以作为谜底的单词有 "faced", "cabbage", 和 "baggage"；而 "beefed"（不含字母 "a"）以及 "based"（其中的 "s" 没有出现在谜面中）。
 * 返回一个答案数组 answer，数组中的每个元素 answer[i] 是在给出的单词列表 words 中可以作为字谜迷面 puzzles[i] 所对应的谜底的单词数目。
 *
 * 1 <= words.length <= 10^5
 * 4 <= words[i].length <= 50
 * 1 <= puzzles.length <= 10^4
 * puzzles[i].length == 7
 * words[i][j], puzzles[i][j] 都是小写英文字母。
 * 每个 puzzles[i] 所包含的字符都不重复。
 *
 * 二进制状态压缩 ：
 * 我们可以使用二进制数字来表每个 word 和 puzzle，该二进制数字就是 word 和 puzzle 的特征。这道题只包含 26 个小写字母，可以压缩到一个 int 中。
 * int 中的每一位取0和1表示字符是否出现过。比如 "aabb" 可以用 11 表示，"accc" 可以用 101 表示。
 *
 * Integer.bitCount(num)方法用于统计 num 二进制中1的个数。
 *
 */


public class NumberOfValidWordsForEachPuzzle_1178_hard {
    public static void main(String[] args) {
      String[]  words = {"aaaa","asas","able","ability","actt","actor","access"};
      String[]  puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
      findNumOfValidWords(words,puzzles).stream().forEach(System.out::print);
    }
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (String word : words) {
            int mask = 0;
            //每次循环将 word 进行二进制压缩 ，压缩到 mask 中
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a')); // 将 mask 第 ch-a 位设置成 1
            }
            //puzzles[i].length == 7 如果 压缩后 mask 中 1 个数大于 7  则一定不符合条件
            if (Integer.bitCount(mask) <= 7) { //
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            int total = 0;
            // 枚举子集方法二
            int mask = 0;
            for (int i = 1; i < 7; ++i) { // 取出后六位字母的二进制码
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            int subset = mask;
            do {
                int s = subset | (1 << (puzzle.charAt(0) - 'a')); // 第一个字母必须相等，每次把第一个字母对应的二进制 设置成1
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                subset = (subset - 1) & mask;
                // (subset - 1) & mask 求二进制子集最后 subset 最后的值是 0
                // subset = 0 后
                // (subset - 1) & mask  =>  -1 & mask = mask 循环结束
            } while (subset != mask);
            /*
            负数在计算机中的存储形式是其同值正数的补码
            int 正1的原码是000000000000000000000001
            int 正1的反码是(原码各位取反)11111111111111111111111111111110
            int 正1的补码是(反码末位加1)11111111111111111111111111111111
             */
            ans.add(total);
        }
        return ans;
    }
}
