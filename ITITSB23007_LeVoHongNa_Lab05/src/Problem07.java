public class Problem07 {
    String reverse(String a){
        if (a == null){
            return "";
        }
        if (a.length() == 1){
            return a;
        }
        else{
            return reverse(a.substring(1)) + a.charAt(0);
        }
    }
}
