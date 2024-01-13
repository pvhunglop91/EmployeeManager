package Utils;

public class AppCurrency {
    public static String toVnd(double value){
        String st = (int)value + "";
        String st2 = "";

        int d = 0;
        for(int i = st.length()-1; i >= 0; i--){
            st2 = st.charAt(i) + st2;
            d++;
            if((d == 3) && (i>0)){
                st2 = '.' + st2;
                d = 0;
            }
        }
        return st2 + " VND";
    }
}
