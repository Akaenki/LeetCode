import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.net.HttpURLConnection;

public class Test {
    public static double E(int num){
        double[] a = new double[num], b = new double[num];
        a[0] = 1; a[1] = 0.5; a[2] = 0.5;
        double E = 0.0;
        for(int i = 3; i<num; ++i)
            a[i] = 0.5*a[i-2] + 0.125*a[i-3];
        for(int i = 2; i<num; ++i){
            b[i] = 0.25 * a[i-2];
            E += i * b[i];
        }
        return E;
    }

    public static List<String> parseEmails(String[] emails){
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String e : emails){
            char[] email = e.toCharArray();
            StringBuilder key = new StringBuilder();
            boolean isTruncate = false;
            for(int i = 0; i<email.length; ++i){
                if(email[i] == '@') {
                    key.append(e.substring(i));
                    break;
                }
                if(email[i] == '+') isTruncate = true;
                if(!isTruncate && email[i] != '.') key.append(email[i]);
            }
            map.put(key.toString(), map.getOrDefault(key.toString(), 0)+1);
        }
        for(String key : map.keySet()){
            if(map.get(key) > 1) res.add(key);
        }
        return res;
    }


    static class Member {
        int val; int index;
        Member(int _val, int _id){
            val = _val; index = _id;
        }
    }
    public static int decreasing(int[] A){
        if(A.length == 0) return 0;
        List<List<Integer>> reslist = new ArrayList<>();
        TreeMap<Member, Integer> map = new TreeMap<>((a, b)->a.val == b.val ? a.index - b.index : a.val - b.val);
        map.put(new Member(A[0], 0), 0);
        reslist.add(new ArrayList<>());
        reslist.get(reslist.size()-1).add(A[0]);

        for(int i = 1; i<A.length; ++i){
            Member cur = new Member(A[i], i);
            Map.Entry toInset = map.higherEntry(cur); //find the higher entry
            if(toInset == null){ // no higher entry
                map.put(cur, reslist.size());
                reslist.add(new ArrayList<>());
                reslist.get(reslist.size()-1).add(A[i]);
            } else {
                map.remove(toInset.getKey());
                map.put(cur, (Integer) toInset.getValue());
                reslist.get((int) toInset.getValue()).add(A[i]);
            }
        }
        for(List<Integer> res : reslist){
            System.out.print("[");
            for(int i : res){
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
        return reslist.size();
    }

    public static int[] findStores(int[] stores, int[] houses){
        if(houses.length == 0) return new int[0];

        int[] res = new int[houses.length];
        Member[] s = new Member[stores.length], h = new Member[houses.length];
        for(int i = 0; i<stores.length; ++i) s[i] = new Member(stores[i], i);
        for(int i = 0; i<houses.length; ++i)  h[i] = new Member(houses[i], i);

        //smaller index comes first
        Arrays.sort(s, (a, b)->a.val == b.val ? b.index-a.index : a.val-b.val);
        Arrays.sort(h, (a, b)->a.val == b.val ? b.index-a.index : a.val-b.val);

        int left = 0;
        for(int i = 0; i<h.length; ++i){
            while(left < s.length && s[left].val <= h[i].val){
                left++;
            }
            if(left == 0) res[h[i].index] = s[left].index;
            else if(left > s.length-1) res[h[i].index] = s[s.length-1].index;
            else{
                res[h[i].index] = (h[i].val-s[left-1].val)<=(s[left].val-h[i].val) ? s[left-1].index : s[left].index;
                left--;
            }
        }
        return res;
    }

    public static int[] findStores2(int[] stores, int[] houses){
        if(houses.length == 0) return new int[0];
        //remove repeated stores, only keep the one with smallest index
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<stores.length; ++i) {
            if(!map.containsKey(stores[i]))
                map.put(stores[i], i);
        }

        Member[] s = new Member[map.size()], h = new Member[houses.length];
        for(int i = 0; i<houses.length; ++i) h[i] = new Member(houses[i], i);
        int ptr = 0;
        for(int key : map.keySet()){
            s[ptr++] = new Member(key, map.get(key));
        }

        int[] res = new int[houses.length];

        //smaller index comes first


        int left = 0;Arrays.sort(s, (a, b)->a.val-b.val);
        Arrays.sort(h, (a, b)->a.val-b.val);
        for(int i = 0; i<h.length; ++i){
            while(left < s.length && s[left].val < h[i].val){
                left++;
            }
            if(left == 0) res[h[i].index] = s[left].index;
            else if(left > s.length-1) res[h[i].index] = s[s.length-1].index;
            else{
                res[h[i].index] = (h[i].val-s[left-1].val)<=(s[left].val-h[i].val) ? s[left-1].index : s[left].index;
                left--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] emails = new String[]{
                "@google.com",
                "a.b.c.e.f.g@google.com",
                "a+google@a.com",
                "a.+c@a.com",
                "+google@google.com",
                "a.b.cefg+abddd@google.com"
        };
        //System.out.println("res: "+decreasing(new int[]{5,100,4,3,98,6,96,5,4,95,97}));
        int[] houses = new int[]{1, 4, 6, 9, 7,3,1,12,5}, stores = new int[]{1, 10, 1, 10, 11, 2, 4, 9};
        for(int i : stores) System.out.print(i + "     ");
        System.out.println();
        for(int i : houses) System.out.print(i + "     ");
        int[] res = findStores2(stores, houses);
        System.out.println();
        for(int i : res) System.out.print(i + "(" + stores[i]+")  ");
    }
}
