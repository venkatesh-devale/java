public class Solution {
    public int numSquares(int n) {
        int m = 0, cnt1 = 9999, r = 0, j=0, s, cnt = 0, temp = 0;
        m = n;
        int i = 1;
        if(n == 0)
            return 0;
        while(m>=(i*i))
            i++;
        int l = i;
        System.out.println(l);
        m = n;
        for(i=1;i<l;i++) {
            s = i*i;
            r = m%s;
            cnt += m/s;
            if(r != 0) {
                int x = r;
                j = i-1;
                while(r != 0) {
                    temp = j*j;
                    x = r%temp;
                    cnt += r/temp;
                    r = x;
                    j--;
                }
            }

            if(cnt < cnt1) {
                //System.out.println("cnt: "+cnt+" and cnt1: "+ cnt1+" and i is:" + i);
                cnt1 = cnt;
                //cnt = 0;
            }
            cnt = 0;
        }
        return cnt1;
    }
}