package study_0919;

public class test1 {
    public static void main(String[] args) {

        System.out.println(isValid("[]({()})[]()[]"));
    }

    public static boolean isValid(String s) {
        //考虑的情况少了

//        //字符串长度
//        int n = s.length();
//        //循环
//        for (int i=0;i<n;i++){
//
//            switch (s.charAt(i)){
//                case '(':
//                    if(s.charAt(i+1)!=')' && s.charAt(n-i-1)!=')'){
//                        return false;
//                    }
//                    break;
//                case '[':
//                    if(s.charAt(i+1)!=']' && s.charAt(n-i-1)!=']'){
//                        return false;
//                    }
//                    break;
//                case '{':
//                    if(s.charAt(i+1)!='}' && s.charAt(n-i-1)!='}'){
//                        return false;
//                    }
//                    break;
//            }
//        }
        int n = s.length();
        //最坏的情况就是所有的都是同一个字符[[[[[[]]]]]]
        for(int i=0;i<n/2;i++){
            s = s.replace("()","").replace("[]","").replace("{}","");
        }
        return s.length()==0;
    }
}
