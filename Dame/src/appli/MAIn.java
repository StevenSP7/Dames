package appli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MAIn {
    public static void main(String[] args) {
        String r =new String("a");
        List<String> collection =new ArrayList<String>(Arrays.asList("a","b"));
        for(String item:collection){
            if(r==item){
                System.out.println("O");
            }
        }
    }
}
