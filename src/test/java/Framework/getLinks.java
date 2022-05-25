package Framework;

import java.util.LinkedHashMap;

public class getLinks {
    void countOccurences(int a){

    }

    String countOccurences(int b, String str){
    int a=b;
    String s=str;
    return s;
    }

    public static void main(String[] args) {


        String str="Ramya";
        //R-1,a-2
        char[] ch=str.toCharArray();
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        for(char c:ch){

            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }

        }
        System.out.println(map);




    }

}
