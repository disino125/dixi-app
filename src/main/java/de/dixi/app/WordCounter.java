package de.dixi.app;

import java.util.*;

public class WordCounter {

    private WordCounter() {
    }

    public static String getMostWordOccurences(String text) {
        if(text==null||text.equals("")){
            return "";
        }
        String str1=text.replace("\n"," ").replace(",","").
                replace(".","").toLowerCase();
        String[] strs=str1.split("\\s+");

        HashSet<String> set = new HashSet<>();
        for (String str : strs) {
            set.add(str);
        }
        HashMap<String, Integer> map = new HashMap<>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String next = it.next();
            int count=0;
            for (String str : strs) {
                if(str.equals(next)){
                    count++;
                }
            }
            map.put(next,count);
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o2.getValue()==o1.getValue()){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        String counter="";
        for (Map.Entry<String, Integer> entry : list) {
            counter+="00"+entry.getValue()+" "+entry.getKey()+"\n";
        }
        return counter;
        //throw new UnsupportedOperationException("Not implemented.");
    }

}
