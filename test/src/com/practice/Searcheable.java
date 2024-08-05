package com.practice;

import java.util.*;
import java.util.stream.Collectors;

public class Searcheable {
    public static void main(String[] args) {
        List<String> list_sentences = new ArrayList<String>();
        list_sentences.add("camera");
        list_sentences.add("mobile");
        list_sentences.add("charger");
        list_sentences.add("laptop");
        list_sentences.add("mouse");
        list_sentences.add("computer");
        list_sentences.add("cooker");
        list_sentences.add("mobile");
        list_sentences.add("calculator");
        List<List<String>> output = getList(list_sentences, "cam");
        for (List<String> s : output) {
            System.out.println(s);
        }

    }

    public static List<List<String>> getList(List<String> strList, String search){
        List<List<String>> output = new ArrayList<>();
        /*List<String> eachSearchCharacter = new ArrayList<String>();
        for(int i=0; i<search.length(); i++){
            eachSearchCharacter.add(search.substring(0,i+1));
        }
        //System.out.println(eachSearchCharacter.toString());

        for(String wordToSearch: eachSearchCharacter){
            List<String> filteredWord = new ArrayList<String>();
            for(String item: strList){
                if(item.startsWith(wordToSearch)){
                    filteredWord.add(item);
                }
            }
            Collections.sort(filteredWord);
            List<String> firstNElementsList = filteredWord.stream().limit(3).collect(Collectors.toList());
            output.add(firstNElementsList);
        }*/
        for (int i=1; i<=search.length(); i++) {
            int finalI = i;
            List<String> list = strList.stream()
                    .filter(product -> product.startsWith(search.substring(0,finalI)))
                    .sorted()
                    .limit(3)
                    .collect(Collectors.toList());
            output.add(list);
        }
        return output;
    }
}
