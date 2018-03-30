package string_string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Administrator on 2018/03/04 0004.
 * 两个字符串拼接后的字典顺序最小
 */
public class JoinStrDictionaryLess {
    public String jointLess(String str1, String str2){
        String[] str = new String[2];
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });

//        Arrays.sort(str, (o1, o2) -> {
//            String c1 = o1 + o2;
//            String c2 = o2 + o1;
//            return  c1.compareTo(c2);
//        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

}
