public class romanToInt {
	public static int romanToInt(String s){
		int sum = 0;
		int curSum = 0;
		int curLevel = 0, preLevel = 0, value = 0;
		for(int i = 0; i<s.length(); i++){
            switch(s.charAt(i)){
                case 'I':
                    curLevel = 0; value = 1; break;
                case 'V':
                    curLevel = 1; value = 5; break;
                case 'X':
                    curLevel = 2; value = 10; break;
                case 'L':
                    curLevel = 3; value = 50; break;
                case 'C':
                    curLevel = 4; value = 100; break;
                case 'D':
                    curLevel = 5; value = 500; break;
                case 'M':
                    curLevel = 6; value = 1000; break;
            }
            if(i == 0 || curLevel < preLevel){
                sum += curSum; curSum = 0;
            }
            if(i!=0 && curLevel > preLevel){
                curSum = value - curSum;
            } else{
                curSum += value;
            }
            preLevel = curLevel;
        }
        return sum + curSum;
	}

	public static void main(String[] args){
        System.out.println(romanToInt("XIII"));
    }
}