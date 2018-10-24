import java.util.*;

public class SparseVector {
    int size;
    List<int[]> vector;

    SparseVector(int[] _vector){
        size = _vector.length;
        vector = new ArrayList<>();
        for(int i = 0; i<size; ++i){
            if(_vector[i] != 0){
                vector.add(new int[]{i, _vector[i]});
            }
        }
    }

    public void add(SparseVector that){
        int i = 0, j = 0;
        while(i < vector.size() && j < that.vector.size()){
            if(vector.get(i)[0] == that.vector.get(j)[0]){
                vector.get(i)[1] += that.vector.get(j)[1];
                i++; j++;
            } else if(vector.get(i)[0] < that.vector.get(i)[0]){
                i++;
            } else {
                j++;
            }
        }
    }

    public int multiply(SparseVector that){
        int i = 0, j = 0, sum = 0;
        while(i < vector.size() && j < that.vector.size()){
            if(vector.get(i)[0] == that.vector.get(j)[0]){
                sum += vector.get(i)[1] * vector.get(j)[1];
                i++; j++;
            } else if(vector.get(i)[0] < that.vector.get(i)[0]){
                i++;
            } else {
                j++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
