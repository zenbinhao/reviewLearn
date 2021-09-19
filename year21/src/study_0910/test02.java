package study_0910;

public class test02 {
    public static void main(String[] args) {
        String []strs = new String[]{"","",""};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
            if(strs.length==0)return "";
            if(strs.length==1)return strs[0];
            int count = 1;
            boolean flag =true;
            int n = strs.length;
            String sum = "";
            String out = "";
            for(int i= 0 ; i<n;i++){
                if(strs[i].length()==0
                ){
                   return "";
                }
            }
            for (int i= 0 ; i<count;i++){
    //            if(strs[i].length()==0){
    //                return "";
    //            }
                //获取到前缀
                sum  += strs[0].charAt(i);
                for(int j = 1 ;j <n;j++){
                    //两次判断
                    if(strs[j].indexOf(sum)!=0) {
                        flag =false;
                    }
                }
                if(i==0&&flag==false){
                    return "";
                }
                if(flag==true){
                    count++;
                    out = sum;
                    if(count==strs[0].length()+1){
                        return out;
                    }
                }
            }
            return out;
    }
}
