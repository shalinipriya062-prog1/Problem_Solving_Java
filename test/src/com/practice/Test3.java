package com.practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
* Get frequency of words in a list
* */
public class Test3 {
    public static void main(String[] args) {
        System.out.println("-----------------Case 1-------------------");
        List<String> list_sentences = new ArrayList<String>();
        list_sentences.add("bob and alice like to text each other");
        list_sentences.add("bob does not like to ski but does not like to fall");
        list_sentences.add("Alice likes to ski");

        List<String> list_queries = new ArrayList<String>();
        list_queries.add("bob alice");
        list_queries.add("alice");
        list_queries.add("like");
        list_queries.add("non occurrence");

        List<List<Integer>> finalMatrix = getFrequency(list_sentences, list_queries);
        for (List<Integer> s : finalMatrix) {
            System.out.println(s);
        }

        System.out.println("-----------------Case 2-------------------");
        List<String> list_sentences1 = new ArrayList<String>();
        list_sentences1.add("jim likes mary");
        list_sentences1.add("kate likes tim");
        list_sentences1.add("tom does not like jim");

        List<String> list_queries1 = new ArrayList<String>();
        list_queries1.add("jim tom");
        list_queries1.add("likes");

        List<List<Integer>> finalMatrix1 = getFrequency(list_sentences1, list_queries1);
        for (List<Integer> s1 : finalMatrix1) {
            System.out.println(s1);
        }

        System.out.println("-----------------Case 3-------------------");
        List<String> list_sentences2 = new ArrayList<String>();
        list_sentences2.add("how it was done");
        list_sentences2.add("are you how");
        list_sentences2.add("it goes to");
        list_sentences2.add("gone done are it");

        List<String> list_queries2 = new ArrayList<String>();
        list_queries2.add("done it");
        list_queries2.add("it");

        List<List<Integer>> finalMatrix2 = getFrequency(list_sentences2, list_queries2);
        for (List<Integer> s2 : finalMatrix2) {
            System.out.println(s2);
        }
    }

        public static List<List<Integer>> getFrequency(List<String> list_sentences, List<String> list_queries){

            String[] sentences = new String[list_sentences.size()];
            for (int i = 0; i < list_sentences.size(); i++) sentences[i] = list_sentences.get(i);

            String[] queries = new String[list_queries.size()];
            for (int i = 0; i < list_queries.size(); i++) queries[i] = list_queries.get(i);
            List<List<Integer>> finalMatrix = new ArrayList<List<Integer>>();
            for (int i = 0; i < queries.length; i++) {
                String[] array_query_word = queries[i].split(" ");
                List<Integer> countEachQuery = new ArrayList<Integer>();
                LinkedHashMap<String, Integer> j_map = new LinkedHashMap<String, Integer>();
                for (int j = 0; j < sentences.length; j++) {
                    List<Integer> countEachQueryWord = new ArrayList<Integer>();
                    for (String each_query_word : array_query_word) {
                        int count = 0;
                        Pattern pattern = Pattern.compile("(\\s|^)" + each_query_word + "(\\s|$)");
                        Matcher matcher = pattern.matcher(sentences[j]);
                        while (matcher.find()) {
                            count++;
                        }
                        countEachQueryWord.add(count);

                    }
                    Collections.sort(countEachQueryWord);
                    j_map.put(sentences[j], countEachQueryWord.get(0));
                };
                for (String name : j_map.keySet()) {
                    String key = name.toString();
                    String value = j_map.get(name).toString();
                    //System.out.println(key + " " + value);
                }
                List<Integer> countForSentence = new ArrayList<Integer>();
                Set<Integer> values = new HashSet<Integer>();
                for (String name : j_map.keySet()) {
                    int value = j_map.get(name);
                    values.add(value);
                }
                if (values.size() == 1 && values.contains(0)) {
                    countForSentence.add(-1);
                } else {
                    int countKeyIndex = 0;
                    for (String name : j_map.keySet()) {
                        int value = j_map.get(name);
                        for (int a = 1; a <= value; a++) {
                            countForSentence.add(countKeyIndex);
                        }
                        countKeyIndex++;
                    }
                }
                //Collections.reverse(countForSentence);
                for (Integer s : countForSentence) {
                    //System.out.println("-----------------------Each element in countSentence list---------------"+ s);
                }
                finalMatrix.add(countForSentence);
            }
            return finalMatrix;
    }
}
