package temp;

/**
 * Created by Administrator on 2018/03/19 0019.
 * 设计求幂次运算
 * 方法一  传统的公式求解 时间复杂度为O（n）
 * 方法二  使用递归求解  时间复杂度为 O(logn)
 *
 * 幂次求解问题 都可以考虑使用递归来实现
 */
public class Power {
    public double power(double base , int exponent) throws Exception {
        int exp = Math.abs(exponent);
        if (base == 1){
            return  1;
        }
        if (exp == 1){
            return base;
        }
        if (exp == 0){
            return  1;
        }
        if (base == 0 && exponent <= 0){
            throw new RuntimeException("底数为0 的 负次方出错");
        }
        double result = 1;

        for (int i = 0; i < exp; i++) {
            result = result * base;
        }

        if (exponent < 0){
            return (1/result);
        }else {
            return  result;
        }
    }


    public double power_re(double base, int exponent) throws Exception {
        int exp = 0;
        if (exponent == 0){
            return 1;
        }
        else  if (exponent < 0){
            if (base < 0){
                throw  new RuntimeException(" 分母不能为0");
            }
            exp = -exponent;
        }else {
            exp = exponent;
        }
        if (exp == 1){
            return base;
        }
        double result = 1.0;
        result = power(base, exp >> 1);
        result *= result;
        if (exponent < 0){
            return  1.0 /result;
        }else
            return result;
    }
}
