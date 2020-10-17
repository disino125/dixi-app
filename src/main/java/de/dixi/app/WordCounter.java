package de.dixi.app;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    private WordCounter() {
    }

    public static String getMostWordOccurences(String text) {

        if (text == null || text.equals("")) {
            return "";
        }

        String[] strs = getAlphabetsFromText(text);

        HashSet<String> set = setToFilterSameWords(strs);

        HashMap<String, Integer> map = compareSetAndStringsAndSaveCountAndWordInMap(strs, set);

        ArrayList<Map.Entry<String, Integer>> list = putMapEntryInListAndSort(map);

        return getPrintStringForm(list);
        //throw new UnsupportedOperationException("Not implemented.");
    }


    private static String[] getAlphabetsFromText(String text) {
        Pattern pattern = Pattern.compile("[^(A-ZÄÖÜa-zäöüß)]");
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll(" ");
        String[] strs = result.toLowerCase().split("\\s+");
        return strs;
    }

    private static HashSet<String> setToFilterSameWords(String[] strings) {
        HashSet<String> set = new HashSet<>();
        for (String str : strings) {
            set.add(str);
        }
        return set;
    }

    private static HashMap<String, Integer> compareSetAndStringsAndSaveCountAndWordInMap
            (String[] strs, HashSet<String> set) {
        HashMap<String, Integer> map = new HashMap<>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int count = 0;
            for (String str : strs) {
                if (str.equals(next)) {
                    count++;
                }
            }
            map.put(next, count);
        }
        return map;
    }

    private static ArrayList<Map.Entry<String, Integer>> putMapEntryInListAndSort
            (HashMap<String, Integer> map) {
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() == o1.getValue()) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });
        return list;
    }

    private static String getPrintStringForm(ArrayList<Map.Entry<String, Integer>> list) {
        String counter = "";
        for (Map.Entry<String, Integer> entry : list) {
            counter += StringUtils.leftPad(entry.getValue().toString(), 3, "0") +
                    " " + entry.getKey() + "\n";
        }
        return counter;
    }


}
