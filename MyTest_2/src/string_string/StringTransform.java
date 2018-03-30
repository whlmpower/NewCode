package string_string;

/**
 * Created by Administrator on 2018/03/07 0007.
 * 判断两个字符，是否为变形词
 * 出现的字符一样 字符出现的次数也一样
 */
public class StringTransform {
    public boolean chkTransform(String A, int lena, String B, int lenb ){
        if (lena != lenb || A == null || B == null || lena == 0 || lenb == 0){
            return false;
        }
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();

        int[] tableA = create_hashTable(charsA, lena);
        int[] tableB = create_hashTable(charsB, lenb);
        for (int i = 0; i < 256; i++) {
            if (tableA[i] != tableB[i]){
                return false;
            }
        }
        return  true;
    }

    private int[] create_hashTable(char[] a, int len){
        int[] table = new int[256];
        for (int i = 0; i < len; i++) {
            table[a[i]] ++;
        }
        return table;
    }
}
