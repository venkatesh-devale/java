import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] str = {"aab", "addadd", "break", "aabccdfff"};
        List<Integer> list = new ArrayList<>();

        for(String s: str) {
            String temp = s;
            StringBuilder sb = new StringBuilder(temp);

            int count = 0;
            for(int i=1;i<sb.length();i++) {
                if(sb.charAt(i) == sb.charAt(i-1)) {
                    if((i+1) < sb.length() && sb.charAt(i) == sb.charAt(i+1)) {
                        sb.replace(i, i+1, "*");
                        count++;
                    } else {
                        sb.replace(i, i+1, "*");
                        count++;
                    }
                }
            }
            System.out.println(sb.toString());
            list.add(count);

        }

        System.out.println(list);
    }
}
