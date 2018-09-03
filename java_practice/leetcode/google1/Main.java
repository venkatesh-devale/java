import java.util.ArrayList;
import java.util.LinkedHashMap;

class Main {
  public static void main(String[] args) {
    ArrayList<Integer> newList = f(new int[]{15,10,5,10,7},1);
    for(int i:newList) {
      System.out.print(i+" ");
    }
  }

  private static ArrayList<Integer> f(int[] data, int n) {
    LinkedHashMap<Integer, Integer> h = new LinkedHashMap<Integer, Integer>();
    for(int i=0;i<data.length;i++) {
      if(!h.containsKey(data[i])){
        h.put(data[i],1);
      } else {
        int cnt = h.get(data[i]);
        h.put(data[i], ++cnt);
      }
    }

    ArrayList<Integer> a = new ArrayList<Integer>();
    h.forEach((k,v)-> {
      if(v <= n) {
        a.add(k);
      }
    });
    return a;
  }
}