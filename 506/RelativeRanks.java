public class RelativeRanks {
    /** O(n) counting sort */
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        int max = 0;
        for(int n : nums) max = Math.max(max, n);

        int[] hash = new int[max + 1];
        for(int i = 0; i<nums.length; ++i){
            hash[nums[i]] = i+1;
        }

        int rank = 1;
        for(int i = max; i>=0; --i){
            if(hash[i] == 0) continue;
            if(rank == 1) res[hash[i]-1] = "Gold Medal";
            else if(rank == 2) res[hash[i]-1] = "Silver Medal";
            else if(rank == 3) res[hash[i]-1] = "Bronze Medal";
            else res[hash[i]-1] = "" + rank;
            rank++;
            if(rank > nums.length) break;
        }
        return res;
    }
}
