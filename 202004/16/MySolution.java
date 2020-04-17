import java.util.ArrayList;

public class MySolution {
    public static String string;
    public static void main(String[] args) {
        // string = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        // string = "(*))";
        string = ")";
        System.out.println(checkValidString(string));
    }

    public static boolean checkValidString(String s) {
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        ArrayList<Integer> star = new ArrayList<Integer>();

        for(int i = 0; i < s.length() ; i++){

            if(s.charAt(i) == '('){
                left.add(i);
            }else if(s.charAt(i) == ')'){
                right.add(i);
            }else if(s.charAt(i) == '*'){
                star.add(i);
            }
        }
        System.out.println("left " + left.size() + " " + left.toString());
        System.out.println("right " + right.size() + " " + right.toString());
        System.out.println("star " + star.size() + " " + star.toString());

        // if ( left.size() > right.size() + star.size() || left.size() + star.size() < right.size()){
        //     return false;
        // }

        System.out.println("while 1");
        while ( left.size() > 0 ){
            boolean matched = false;
            for ( int i = 0; i < right.size(); i++ ){
                if ( left.get( left.size() -1 ) < right.get(i)){
                    matched = true;
                    left.remove(left.size() - 1);
                    right.remove(i);
                    break;
                }
            }

            if(!matched){
                for ( int i = 0; i < star.size(); i++ ){
                    if ( left.get( left.size() -1 ) < star.get(i)){
                        matched = true;
                        left.remove(left.size() - 1);
                        star.remove(i);
                        break;
                    }
                }            
            }
            if(!matched){
                return false;
            }
        }
        System.out.println("left " + left.size() + " " + left.toString());
        System.out.println("right " + right.size() + " " + right.toString());
        System.out.println("star " + star.size() + " " + star.toString());
        
        System.out.println("while 2");
        while ( right.size() > 0 ){
            boolean matched = false;
            for ( int i = 0; i < star.size(); i++ ){
                if ( right.get(0) > star.get(i)){
                    matched = true;
                    right.remove(right.size() - 1);
                    star.remove(i);
                    break;
                }
            }
            if(!matched){
                return false;
            }
        }
        System.out.println("left " + left.size() + " " + left.toString());
        System.out.println("right " + right.size() + " " + right.toString());
        System.out.println("star " + star.size() + " " + star.toString());

        return true;
    }
}