import java.util.*;
public class KaratInterview {

    /** 1.1 find the node with 0 or 1 parent */
    List<Integer> findParent(int[][] edges){
        // Build the map child to parent:
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        HashSet<Integer> nodes = new HashSet<>();
        for(int[] edge : edges){
            int child = edge[1], parent = edge[0];
            nodes.add(child);
            nodes.add(parent);
            if(!map.containsKey(child))
                map.put(child, new ArrayList<>());
            map.get(child).add(parent);
        }

        List<Integer> res = new ArrayList<>();
        for(int node : nodes){
            if(!map.containsKey(node) || map.get(node).size() == 1)
                res.add(node);
        }
        return res;
    }

    /** 1.2 if the two nodes has common ancestor **/
    boolean hasCommmonAnc(int[][] edges, int[] target){
        int node1 = target[0], node2 = target[1];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            int child = edge[1], parent = edge[0];
            if(!map.containsKey(child))
                map.put(child, new ArrayList<>());
            map.get(child).add(parent);
        }

        HashSet<Integer> roots1 = getRoots(map, node1),  roots2 = getRoots(map, node2);
        for(int p1 : roots1){
            if(roots2.contains(p1)) return true;
        }
        return false;
    }

    HashSet<Integer> getRoots(HashMap<Integer, List<Integer>> map, int node){
        HashSet<Integer> roots = new HashSet<>();
        if(!map.containsKey(node)) return roots;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            int visiting = queue.poll();
            for(int parent : map.get(visiting)){
                if(!map.containsKey(parent)){
                    roots.add(parent);
                } else{
                    queue.offer(parent);
                }
            }
        }
        return roots;
    }

    /** 1.3 find the highest root of a node **/
    int topAncestor(int[][] edges, int node){
        /** any way we have to traverse all root */
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            int child = edge[1], parent = edge[0];
            if(!map.containsKey(child))
                map.put(child, new ArrayList<>());
            map.get(child).add(parent);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node, 0});
        int maxDepth = 0, rootNode = node;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int visiting = cur[0], curDepth = cur[1];
            if(curDepth > maxDepth){
                rootNode = visiting;
                maxDepth = curDepth;
            }
            if(!map.containsKey(visiting)) continue;
            for(int parent : map.get(visiting)){
                queue.offer(new int[]{parent, curDepth+1});
            }
        }
        return rootNode;
    }


    /** 1.1 given bandge_reconds find employees that are:
     *  a. enter without exit, b. exit without enter record
     */
    HashSet<String>[] findEmplyees(String[][] badge_records){
        HashSet<String> a = new HashSet<>(), b= new HashSet<>();
        HashMap<String, Integer> traffic = new HashMap<>();
        for(String[] record : badge_records){
            String name = record[0], action = record[1];
            int actCost = -1;
            if(action.equals("enter")) actCost = 1;
            traffic.put(name, traffic.getOrDefault(name, 0) + actCost);
            int curCost = traffic.get(name);
            if(curCost > 1){ //exit without badge
                a.add(name);
            } else if(curCost < 0){//enter without badge
                b.add(name);
            }
        }

        for(String name : traffic.keySet()){
            if(traffic.get(name) == 1) a.add(name);
        }
        return new HashSet[]{a, b};
    }

    /** 2.2 find employee have more than 3 times entry within 1 hr
     * if the input list is not sorted, sort it before check */
    HashMap<String, List<Integer>> findSpam(String[][] badge_records){
        HashMap<String, Queue<Integer>> map = new HashMap<>();
        HashMap<String, List<Integer>> spam = new HashMap<>();
        for(String[] entry : badge_records){
            String name = entry[0];
            int time = Integer.parseInt(entry[1]);
            if(!map.containsKey(name)) map.put(name, new LinkedList<>());
            map.get(name).offer(time);
            while((map.get(name).peek() < Math.floorMod(time-100,2400)) || (map.get(name).peek() > time + 100)){
                map.get(name).poll();
            }
            int max = map.get(name).size();
            if(max>=3 && (!spam.containsKey(name) || max > spam.get(name).size()))
                spam.put(name, new LinkedList<>(map.get(name)));
        }
        return spam;
    }

    /** 3.1 find rectangulars */
    int[][] findRect(int[][] matrix){
        List<int[]> rects = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(matrix[i][j] == 0){
                    int[] coords = new int[]{i, j, i, j};
                    findShape(matrix, coords, i, j);
                    rects.add(coords);
                }
            }
        }
        return rects.toArray(new int[rects.size()][4]);
    }

    void findShape(int[][] matrix, int[] coords, int i, int j){
        matrix[i][j] = 1;
        if(i < matrix.length-1 && matrix[i+1][j] == 0)
            findShape(matrix, coords, i+1, j);
        if(i > 0 && matrix[i-1][j] == 0)
            findShape(matrix, coords, i-1, j);
        if(j < matrix[0].length-1 && matrix[i][j+1] == 0)
            findShape(matrix, coords, i, j+1);
        if(j > 0 && matrix[i][j-1] == 0)
            findShape(matrix, coords, i, j-1);
        coords[0] = Math.min(coords[0], i);
        coords[1] = Math.min(coords[1], j);
        coords[2] = Math.max(coords[2], i);
        coords[3] = Math.max(coords[3], j);
    }


    /** 3.1 find all shapes */
    List<List<Integer>> findAllShapes(int[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(matrix[i][j] == 0){
                    List<Integer> shape = new ArrayList<>();
                    dfs(matrix, i, j, shape);
                    res.add(shape);
                }
            }
        }
        return res;
    }

    void dfs(int[][] matrix, int i, int j, List<Integer> shape){
        matrix[i][j] = 1;
        shape.add(i); shape.add(j);
        if(i < matrix.length-1 && matrix[i+1][j] == 0)
            dfs(matrix, i+1, j, shape);
        if(i > 0 && matrix[i-1][j] == 0)
            dfs(matrix, i-1, j, shape);
        if(j < matrix[0].length-1 && matrix[i][j+1] == 0)
            dfs(matrix, i, j+1, shape);
        if(j > 0 && matrix[i][j-1] == 0)
            dfs(matrix, i, j-1, shape);
    }

    /** 4.1 Calculator with +, - */
    int caculate1(String expression){
        int sign = 1, num = 0, sum = 0;
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)) num = num *10 + Character.getNumericValue(c);
            else{
                sum += sign * num;
                if(c == '-') sign = -1;
                else sign = 1;
                num = 0;
            }
        }
        sum += sign * num;
        return sum;
    }


    /** 4.2 Calculator with +, - (, )  e.g. 1 + (1+1+2) */
    int caculate2(String expression){
        int sign = 1, num = 0, sum = 0;
        Stack<Integer> signs = new Stack<>();
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)) num = num *10 + Character.getNumericValue(c);
            else{
                sum += sign * num;
                num = 0;
                int prevSign = signs.isEmpty()? 1 : signs.peek();
                if(c == '-') sign = prevSign * -1;
                if(c == '+') sign = prevSign;
                else if(c == '(') signs.add(sign);
                else if(c == ')') signs.pop();
            }
        }
        sum += sign * num;
        return sum;
    }

    /** 4.3 Calculator with +, - (, ) and variables */
    String caculate3(String expression, HashMap<String, Integer> vars){
        int sign = 1, num = 0, sum = 0;
        String var = "";
        Stack<Integer> signs = new Stack<>();
        HashMap<String, Integer> unknown = new HashMap<>();
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)) num = num *10 + Character.getNumericValue(c);
            else if(Character.isLetter(c)) var += c;
            else{
                sum += sign * num;
                num = 0;
                if(var.length() != 0){
                    if(vars.containsKey(var)) sum += sign * vars.get(var);
                    else unknown.put(var, unknown.getOrDefault(var, 0) + sign);
                }
                var = "";
                int prevSign = signs.isEmpty()? 1 : signs.peek();
                if(c == '-') sign = prevSign * -1;
                if(c == '+') sign = prevSign;
                else if(c == '(') signs.add(sign);
                else if(c == ')') signs.pop();
            }
        }
        sum += sign * num;
        String result = "" + sum;
        for(String v : unknown.keySet()){
            if(unknown.get(v) == 0) continue;
            else {
                int prefector = unknown.get(v);
                if(prefector > 0) result += "+";
                else result += "-";

                if(prefector == 1 || prefector == -1) result += v;
                else result += Math.abs(prefector) + v;
            }
        }
        return result;
    }


    /** 5.1 given domain and clicks, sum up its sub domains' clicks */
    String[][] countCliks(String[][] domains){
        HashMap<String, Integer> counts = new HashMap<>();
        for(String[] domain : domains){
            String name = domain[0];
            int clicks = Integer.parseInt(domain[1]);
            String[] subs = name.split("\\.");
            String subdomain = "";
            for(int i = subs.length-1; i>=0; --i){
                if(subdomain.length() == 0)
                    subdomain = subs[i];
                else subdomain = subs[i] + "." + subdomain;
                counts.put(subdomain, counts.getOrDefault(subdomain, 0) + clicks);
            }
        }
        List<String[]> res = new ArrayList<>();
        for(String domain : counts.keySet()){
            res.add(new String[]{domain, ""+counts.get(domain)});
        }
        return res.toArray(new String[res.size()][2]);
    }

    /** 5.2 find longest continuous common history
     * dp[i][j] = the current CH end at user1[i] to user1[j]*/
    String[] findLCH(String[] user1, String[] user2){
        int max = 0, end = -1; //end index of LCH in user1
        int[][] dp = new int[user1.length+1][user2.length+1];
        for(int i = 0; i<user1.length; ++i){
            for(int j = 0; j<user2.length; ++j){
                if(user1[i].equals(user2[j]))
                    dp[i+1][j+1] = dp[i][j] + 1;
                else dp[i+1][j+1] = 0;

                if(dp[i+1][j+1] > max){
                    max = dp[i+1][j+1];
                    end = i;
                }
            }
        }
        int start = end - max + 1;
        String[] res = new String[max];
        for(int i = 0; i<max; ++i){
            res[i] = user1[start + i];
        }
        return res;
    }


    /** 6.1 if the meeting time can be insert into a schedule */
    boolean isAvailable(int[][] meetings, int start, int end){
        Arrays.sort(meetings, (a, b)->a[0] - b[0]);
        for(int i = 0; i<meetings.length; ++i){
            if(i == 0 && end <= meetings[i][0]) return true;
            else if(i == meetings.length-1 && start >= meetings[i][1]) return true;
            else if(i > 0 && meetings[i-1][1] <= start && meetings[i][0] >= end) return true;

            if(start < meetings[i][1]) return false;
        }
        return false;
    }

    /** 6.2 merge the schedule and output the free time
     * Review LC merge interval and scan once more to get free time.*/

    public static void main(String[] args) {
        KaratInterview o = new KaratInterview();

        int[][] input = new int[][]{{1300,1500},{930,1200},{830,845}};
        System.out.println(o.isAvailable(input, 1450, 1500));

        /*String[][] input = {
                {"3234.html", "xys.html", "7hsaa.html"}, // user1
                {"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"}};*/
        /*String[][] input = {
                {"/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html"},
                {"/nine.html", "/two.html", "/three.html", "/four.html", "/six.html", "/seven.html"},
                {"/one.html", "/two.html", "/three.html", "/four.html", "/six.html"},
                {"/three.html", "/eight.html"}};

        String[] res = o.findLCH(input[1], input[3]);
        for(String s : res) System.out.println(s);*/

        /*String[][] input = {
                {"google.com", "60"},
                {"yahoo.com", "50"},
                {"sports.yahoo.com", "80"}};

        String[][] output = o.countCliks(input);
        for(String[] domain : output){
            System.out.println(domain[0] + ": " + domain[1]);
        }*/

        /*HashMap<String, Integer> vars = new HashMap<>();
        vars.put("pressure", 1);
        vars.put("a", 10);
        System.out.println(o.caculate3(
        "2-temperature+((8+2+pressure)+(3-999-c)+b)-(temperature+b)", vars)); */

        /*String[][] badge_records = {
                {"Martha",   "exit"},
                {"Paul",     "enter"},
                {"Martha",   "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "enter"},
                {"Paul",     "enter"},
                {"Curtis",   "enter"},
                {"Paul",     "exit"},
                {"Martha",   "enter"},
                {"Martha",   "exit"},
                {"Jennifer", "exit"}};*/

        /*String[][] badge_records = {
                {"Paul", "1355"},
                {"Jennifer", "2355"},
                {"John", "830"},
                {"Paul", "1315"},
                {"John", "835"},
                {"Paul", "1405"},
                {"Paul", "1630"},
                {"John", "855"},
                {"John", "915"},
                {"John", "930"},
                {"Jennifer", "105"},
                {"Jennifer", "120"},
                {"John", "1630"}};
        HashMap<String, List<Integer>> res = o.findSpam(badge_records);
        for(String name : res.keySet()){
            System.out.println(name);
            for(int time : res.get(name))
                System.out.print(time + " ");
            System.out.println();
        }*/

        /*int[][] input ={
                {1,1,1,1,1,1},
                {0,0,1,0,1,1},
                {0,0,1,0,1,0},
                {1,1,1,0,1,0},
                {1,0,0,1,1,1}};
        int[][] output = o.findRect(input);
        for(int[] i : output){
            for(int j : i)
                System.out.print(j + " ");
            System.out.println();
        }*/
    }
}
