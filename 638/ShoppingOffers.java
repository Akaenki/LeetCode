import java.util.*;
public class ShoppingOffers {
    private int max = 0;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        for(int i = 0; i<price.size(); ++i) max += price.get(i) * needs.get(i);
        return search(price, special, needs, 0);
    }

    private int search(List<Integer> p, List<List<Integer>> s, List<Integer> n, int o){
        int min = max;
        for(int i = o; i<s.size(); ++i){
            List<Integer> offer = s.get(i);
            List<Integer> needs = new ArrayList<>();
            for(int j = 0; j<n.size(); ++j){
                if(n.get(j) < offer.get(j)) break;
                needs.add(n.get(j) - offer.get(j));
            }

            if(needs.size() == n.size()) min = Math.min(min,
                    offer.get(offer.size()-1) + search(p, s, needs, i));
        }
        return min;
    }
}
