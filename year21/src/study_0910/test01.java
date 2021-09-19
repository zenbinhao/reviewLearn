package study_0910;

public class test01 {
    public static void main(String[] args) {
        System.out.println(
                romanToInt("MCMXCIV")
        );
    }
    public static int romanToInt(String s) {
        int sum = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            switch(s.charAt(i)){
                case 'I':
                    if(i!=n-1){
                        if(s.charAt(i+1)=='V' || s.charAt(i+1)=='X'){
                            sum = sum-1;
                        }else{
                            sum = sum +1;
                        }
                    }else{
                        sum = sum +1;
                    }
                    break;
                case 'V':
                    sum = sum +5;
                    break;
                case 'X':
                    if(i!=n-1){
                        if(s.charAt(i+1)=='L' || s.charAt(i+1)=='C'){
                            sum = sum-10;
                        }else{
                            sum = sum +10;
                        }
                    }else{
                        sum = sum +10;
                    }
                    break;
                case 'L':
                    sum = sum +50;
                    break;
                case 'C':
                    if(i!=n-1){
                        if(s.charAt(i+1)=='D' || s.charAt(i+1)=='M'){
                            sum = sum-100;
                        }else{
                            sum = sum +100;
                        }
                    }else{
                        sum = sum +100;
                    }
                    break;
                case 'D':
                    sum = sum +500;
                    break;
                case 'M':
                    sum = sum +1000;
                    break;
                default:
                    break;
            }
        }
        return sum;
    }
}
