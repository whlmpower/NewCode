package string_string;

/**
 * Created by Administrator on 2018/03/04 0004.
 * I am a student
 *
 * I ma a tneduts
 *
 * student a am I
 *
 */
public class ReverseWord {
    public String reverse_str(String str){

        char[] a = str.toCharArray();
        int current = 0;
        int pre = 0;
        int end = str.length() -1;
        while(current < end){
            if(a[current] == ' '){
                reverse(a, pre, current -1);
                current ++;
                pre = current;
            }else {
                current++;
            }
        }

        reverse(a, pre, current-1);
        reverse(a, 0, current -1);
        return new String(a);
    }

    public void reverse(char[] a, int front, int end){
        while(end > front){

            char temp = a[front];
            a[front] = a[end];
            a[end] = temp;
            front ++;
            end --;
        }
    }
}
