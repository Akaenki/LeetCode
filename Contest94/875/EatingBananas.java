package Contest94;

import java.util.Arrays;

public class EatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        if(H == piles.length) return piles[piles.length-1];
        int round = H / piles.length;
        int low = piles[0]/round, high = piles[piles.length-1]/round + 1;

        while (low < high){
            int k= (low + high )/2, h = H;
            for (int p: piles)
                h -= (p-1) / k + 1;
            if (h < 0) low = k + 1;
            else high = k;
        }
        return low;
    }
}
