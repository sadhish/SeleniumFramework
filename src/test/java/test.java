import io.cucumber.java.bs.I;
import io.cucumber.java.sl.In;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        String[] arr={"i","from","India","am","aaaaaaaaa"};
        int n= arr.length;
        LinkedHashMap<String,Integer> map= new LinkedHashMap<>();
        Arrays.sort(arr);
        for (int i=0;i<n;i++){
        map.put(arr[i],arr[i].length());
        }

        List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(map.entrySet());

        Collections.sort(list, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();



        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        LinkedHashMap<String,Integer> hm1= (LinkedHashMap<String, Integer>) temp;

        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println(  en.getKey()

                    );
        }



}




}





