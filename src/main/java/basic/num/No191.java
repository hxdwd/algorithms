package basic.num;

/**
 * 计算一个int 数的 1的个数
 *
 * @author huangxiaodong
 * @date 2021/10/27  9:58
 */
public class No191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones += (n & 1);
            n >>>= 1;
        }
        return ones;
    }
}
