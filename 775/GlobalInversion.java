public class GlobalInversion {
    /** Hummmmmm */
    public boolean isIdealPermutation(int[] A) {
        for(int i = 1; i<A.length; ++i){
            if(A[i] < A[i-1]){
                if(A[i] != i-1 || A[i-1] != i) return false;
            }
        }
        return true;
    }
}
