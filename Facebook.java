import javafx.util.Pair;

import java.util.*;

public class Facebook {
    /* 1 2 3 4 5 6 7 8 k = 7
       i         j
       2^(j-i-1)
     */

    public int numSubset(int[] arr, int k){
        int end = arr.length-1, sum = 0;
        for(int i = 0; i<arr.length; ++i){
            while(end >= 0 && arr[end] > k-arr[i]) end--;
            if(end < i) break;
            if(arr[i] + arr[end] != k){
                k++;
                continue;
            }
            if(end == i) sum += 1;
            else sum += Math.pow(2, end-i-1);
            //sum += 1 << end-i-1;
        }
        return sum;
    }

    /** max + min <= k **/
    public int numSubset2(int[] arr, int k){
        int end = arr.length-1, sum = 0;
        for(int i = 0; i<arr.length; ++i){
            while(end >= 0 && arr[end] > k-arr[i]) end--;
            if(end < i) break;
            else sum += Math.pow(2, end-i);
        }
        return sum;
    }

    /* Special Case: Merge 3 Lists/Arrays */
    public List<Integer> mergeLists(List<Integer> a, List<Integer> b, List<Integer> c){
        int pa = 0, pb = 0, pc = 0;
        List<Integer> res = new ArrayList<>();
        while(pa<a.size()||pb<b.size()||pc<c.size()){
            int aa = pa < a.size() ? a.get(pa) : Integer.MAX_VALUE,
                bb = pb < b.size() ? b.get(pb) : Integer.MAX_VALUE,
                cc = pc < c.size() ? c.get(pc) : Integer.MAX_VALUE;
            if(aa <= bb && aa <= cc){
                res.add(aa); pa++;
            } else if(bb <= aa && bb <= cc){
                res.add(bb); pb++;
            } else{
                res.add(cc); pc++;
            }
        }
        return res;
    }

    private int parseTime(String str) {
        int start = 0;
        for (int i = str.length() - 1; i >= 0; --i) {
            if (str.charAt(i) == 'p') {
                start = 12 * 100;
                break;
            }
        }
        String[] time = str.split(":");
        int hr = 0;
        for (char c : time[0].toCharArray()) {
            if (!Character.isDigit(c)) break;
            hr = hr * 10 + Character.getNumericValue(c);
        }
        hr = hr % 12;
        int min = 0;
        if(time.length > 1) {
            for (char c : time[1].toCharArray()) {
                if (!Character.isDigit(c)) break;
                min = min * 10 + Character.getNumericValue(c);
            }
        }
        return hr*100 + min + start;
    }

    public int[] longestSub(int[] arr){
        int max = 0, end = 1, cur = 1;
        for(int i = 1; i<arr.length; ++i){
            if(arr[i] > arr[i-1]) cur++;
            else cur = 1;
            if(cur > max){
                max = cur;
                end = i;
            }
        }
        int[] res = new int[max];
        for(int i = 0; i< max; ++i)
            res[i] = arr[end-max+1+i];
        return res;
    }

    public String validPar(String s){
        int open = 0, close = 0;
        HashSet<Integer> delete = new HashSet<>();
        for(int i = 0; i<s.length(); ++i) {
            if (s.charAt(i) == '(') open++;
            else if (s.charAt(i) == ')') {
                if (open > 0) open--; else delete.add(i);
            }
        }
        for(int i = s.length()-1; i>=0; --i){
            if(s.charAt(i) == ')') close++;
            else if(s.charAt(i) == '('){
                if(close > 0) close--; else delete.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); ++i){
            if(delete.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public boolean compareStr(String a, String b){
        int pa = a.length()-1, pb = b.length()-1, count = 1;
        while(pa >= 0 && pb >=0){
            if(Character.isDigit(b.charAt(pb))){
                count = Character.getNumericValue(b.charAt(pb));
                pb--; continue;
            } else if(count ==0) {
                count = 1;
                pb--;
                continue;
            } else if(a.charAt(pa) != b.charAt(pb)) return false;
            else{
                pa--; count--;
            }
        }
        return pa <=0 && pb<=0 && count==0;
    }


    public static void main(String[] args) {
        Facebook o = new Facebook();
        //List<Integer> a = Arrays.asList(1,4,7,10,13), b = Arrays.asList(1,4,7,10,13), c = Arrays.asList(3,6,9,12,100);
        //List<Integer> res = o.mergeLists(a,b,c);
        System.out.println(o.validPar("(a)((b)c)))"));
    }



    public static List<String> sort(List<String> input){
        HashMap<String, Integer> months = new HashMap<>();
        months.put("Jan", 1); months.put("Feb", 2); months.put("Mar", 3); months.put("Apr", 4);
        months.put("May", 5); months.put("Jun", 6); months.put("Jul", 7); months.put("Aug", 8);
        months.put("Sep", 9); months.put("Oct", 10); months.put("Nov", 11); months.put("Dec", 12);
        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }



    public boolean isNumber(String s){
        boolean isDot = false;
        for(int i = 0; i<s.length(); ++i){
            char c = s.charAt(i);
            if(i == 0 ){
                if(c == '0' && s.charAt(i+1) != '.') return false;
                if(c != '-' && !Character.isDigit(c)) return false;
            } else if(i == s.length()-1){
                if(c == '0' || c == '.' || !Character.isDigit(c)) return false;
            }else{
                if(c == '0' && !Character.isDigit(s.charAt(i-1)) && s.charAt(i+1) != '.') return false;
                if(Character.isDigit(c)) continue;
                if(c == '.'){
                    if(isDot) return false;
                    else isDot = true;
                }else return false;
            }
        }
        return true;
    }





    public List<List<int[]>> allPaths(int[][] grid, int[] start, int[] end){
        List<List<int[]>> paths = new ArrayList<>();
        List<int[]> path = new ArrayList<>();
        path.add(start);
        backtrack(grid, start, end, paths, path, new boolean[grid.length][grid[0].length]);
        return paths;
    }
    private void backtrack(int[][] grid, int[] loc, int[] end, List<List<int[]>> all, List<int[]> cur, boolean[][] isVisited){
        if(loc[0] == end[0] && loc[1] == end[1]){
            all.add(new ArrayList<>(cur));
            return;
        }
        int x = loc[0], y = loc[1];
        List<int[]> nbs = nbs(grid, loc);
        for(int[] nb : nbs) {
            int i = nb[0], j = nb[1];
            if (!isVisited[i][j]) {
                cur.add(nb);
                isVisited[i][j] = true;
                backtrack(grid, nb, end, all, cur, isVisited);
                cur.remove(cur.size() - 1);
                isVisited[i][j] = false;
            }
        }
    }
    int[][] dirs = {{0,1}, {0,-1},{1,0},{-1,0}};
    private List<int[]> nbs(int[][] grid, int[] loc){
        int x = loc[0], y = loc[1];
        List<int[]> nbs = new ArrayList<>();
        for(int[] dir : dirs){
            int i = x + dir[0], j = y + dir[1];
            if(i < 0 || i>=grid.length|| j<0 || j>=grid[0].length || grid[i][j] != 0) continue;
            nbs.add(new int[]{i, j});
        }
        return nbs;
    }
    public List<String> shortest(int[][] grid, int[] start, int[] end){
        int m = grid.length, n = grid[0].length;
        int[][] steps = new int[m][n];
        for(int i = 0; i<m; ++i)
            for(int j = 0; j<n; ++j)
                steps[i][j] = Integer.MAX_VALUE;
        HashMap<String, String> map = new HashMap<>();
        steps[start[0]][start[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int step = steps[cur[0]][cur[1]] + 1;
            List<int[]> nbs = nbs(grid, cur);
            for(int[] nb : nbs){
                if(steps[nb[0]][nb[1]] > step){
                    map.put(nb[0]+","+nb[1], cur[0]+","+cur[1]);
                    q.offer(nb);
                    steps[nb[0]][nb[1]] = step;
                }
            }
        }
        LinkedList<String> res = new LinkedList<>();
        String e = end[0]+","+end[1];
        while(map.containsKey(e)){
            res.addFirst(e);
            e = map.get(e);
        }
        return res;
    }

    /*public static void main(String[] args) {
        Facebook o = new Facebook();
        int[][] vector = {{0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0}
        };

        //List<List<int[]>> res = o.allPaths(vector, new int[]{0, 0}, new int[]{1, 5});
        List<String> res = o.shortest(vector, new int[]{0, 0}, new int[]{4, 5});
        for(String r : res){
            System.out.println(r);
        }
    }*/
}
