package org;
import java.util.ArrayList;
import java.util.List;

public class Multiply {
    
    //Naive Implementation of multiplication O(n) = n^2 
    public static int naivemultiply(String a, String b){
        char[] a1 = a.toCharArray(); 
        char[] b1 = b.toCharArray();
        int retval = 0;
        int layercount = 0;
        for (int i = a1.length-1; i>=0; i--) {
            int carryover = 0;
            String layer = new String();
            for(int j=b1.length-1;j>=0; j--){
                int atemp = Integer.parseInt(String.valueOf(a1[i]));
                int btemp = Integer.parseInt(String.valueOf(b1[j]));
                int mulval = (atemp * btemp) + carryover;
                carryover = 0;
                if(mulval>9){
                    carryover = mulval/10;
                    layer =  String.valueOf(mulval%10) +layer;
                }else{
                    layer = String.valueOf(mulval) + layer;
                }   
            }
            if(carryover>0){
                layer = carryover + layer;
            }
            String appender ="";
            for(int la=0; la<layercount;la++){
                appender += "0";
            }
            layer += appender;
            layercount++;
            retval += Integer.parseInt(layer);     
        }
        return retval;
    }
public static void main(String[] args) {
            
    System.out.println((naivemultiply("55", "34") == (55*34))?"Fine":"Notfine");
    System.out.println((naivemultiply("554", "34") == (554*34))?"Fine":"Notfine");
    System.out.println((naivemultiply("55", "1") == (55*1))?"Fine":"Notfine");
    System.out.println((naivemultiply("626", "973") == (626*973))?"Fine":"Notfine");

}
}