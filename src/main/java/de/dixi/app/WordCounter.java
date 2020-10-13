package de.dixi.app;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private WordCounter() {
    }

    public static String getMostWordOccurences(String text) {
        if(text==null||text.equals("")){
            return "";
        }
        String regEx="[☀;|\uD83C\uDF19|!|\n|,:.|\uFE0F|0-9]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll(" ");
        String[] strs = result.toLowerCase().split("\\s+");

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
            if(entry.getValue()<10){
                counter+="00"+entry.getValue()+" "+entry.getKey()+"\n";
            }else if(entry.getValue()<100){
                counter+="0"+entry.getValue()+" "+entry.getKey()+"\n";
            }else{
                counter+=entry.getValue()+" "+entry.getKey()+"\n";
            }
        }
        return counter;
        //throw new UnsupportedOperationException("Not implemented.");
    }

}
