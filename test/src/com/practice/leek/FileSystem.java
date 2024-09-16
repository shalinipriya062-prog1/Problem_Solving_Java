package com.practice.leek;

import java.util.*;
import java.util.regex.Pattern;

public class FileSystem {
        Map<String, List<String>> files;


        public FileSystem() {
            files = new HashMap<>();
        }

        public List<String> ls(String path) {
            if(path.trim().equals("/")){
                if(files.isEmpty()){
                    List<String> emptyList1 = new ArrayList<>();
                    return emptyList1;
                }
                else{
                    List<String> rootValue = files.get("/");
                    //System.out.println("Getting value of /" + rootValue.get(0));
                    Collections.sort(rootValue);
                    return rootValue;
                }

            }
            else {
                String[] foldersToTraverse1 = path.split("/");
                String[] foldersToTraverse = new String[foldersToTraverse1.length-1];
                for (int i = 0; i < foldersToTraverse.length; i++) {
                    foldersToTraverse[i] = foldersToTraverse1[i+1];
                }
                //System.out.println("Folder to traverse:");
                for (String s: foldersToTraverse) {
                    //System.out.println(s);
                }

            //System.out.println("foldersToTraverse.length-1: " + (foldersToTraverse.length-1));
                List<String> lastValue = new ArrayList<>();
                for (int i = 0; i < foldersToTraverse.length; i++) {
                //System.out.println("i: " + i);
                    String currentValue = foldersToTraverse[i];
                    //System.out.println("Elements in the path: " + currentValue);
                    //System.out.println("i: " + i);
                    //System.out.println("foldersToTraverse.length-1: " + (foldersToTraverse.length-1));
                    if(i != foldersToTraverse.length-1) {
                        //System.out.println("If:  ");
                        //System.out.println("targetValue to add when i is not equal to foldersToTraverse.length-1 : " + (foldersToTraverse[i+1]));

                        String targetValue = foldersToTraverse[i+1];
                        lastValue = getLs(currentValue, targetValue);
                        //System.out.println("Last value for i: "+ i + " "+ lastValue);
                        if(lastValue == null){
                            List<String> emptyList = new ArrayList<>();
                            return emptyList;
                        }
                        //System.out.println("lastValue:  " + lastValue);
                    }
                    else {
                        //System.out.println("Else:  ");
                        //List<String> getLastElementvalue = files.get(currentValue);
                        //String checkForFileContent = (files.get(currentValue).isEmpty() || files.get(currentValue) == null) ?  "" :getLastElementvalue.get(0);
                        //String checkForFileContent = "";
                        List<String> checkValue = files.get(currentValue);
                        //System.out.println("files.get(currentValue): " + checkValue);
                        //System.out.println("files.get(currentValue) == null: " + (checkValue == null));
                        //System.out.println("files.get(currentValue).isEmpty(): " + (checkValue.isEmpty()));
                        //System.out.println("files.get(currentValue).size()==0: " + (checkValue.size()==0));
                        //if (files.get(currentValue) == null) {
                        /*if (checkValue== null) {
                        //checkForFileContent = "";
                            //System.out.println("Inside checkValue null");
                            List<String> insertFile1 = new ArrayList<>();
                            insertFile1.add(currentValue);
                            lastValue = insertFile1;
                            return lastValue;
                        } */
                        if ((checkValue != null) && !checkValue.isEmpty()) {
                            //System.out.println("CheckValue:");
                            //System.out.println(checkValue);
                            List<String> getLastElementvalue = files.get(currentValue);
                            for (int j = 0; j < getLastElementvalue.size(); j++) {
                                //System.out.println("Each element: " + getLastElementvalue.get(j));
                            }
                            String checkForFileContent = getLastElementvalue.get(0);
                        //System.out.println("currentValue:  " + currentValue);
                        //System.out.println("getLastElementvalue:  " + getLastElementvalue);
                        //System.out.println(!files.containsKey(getLastElementvalue));
                        //System.out.println(getLastElementvalue.isEmpty());
                            if (!files.containsKey(checkForFileContent) || getLastElementvalue.isEmpty()) {
                                List<String> insertFile = new ArrayList<>();
                                insertFile.add(currentValue);
                                lastValue = insertFile;
                            //System.out.println("lastValue:  " + lastValue);
                            } else {
                                lastValue = getLastElementvalue;
                            }
                        }
                        else{
                            //checkForFileContent = "";
                            //System.out.println("Inside checkValue null");
                            List<String> insertFile1 = new ArrayList<>();
                            insertFile1.add(currentValue);
                            lastValue = insertFile1;
                            return lastValue;
                        }
                    }
                }
                //System.out.println("lastValue outside if else:  " + lastValue);
                if(lastValue == null){
                    List<String> emptyList = new ArrayList<>();
                    return emptyList;
                }
                else{
                    Collections.sort(lastValue);
                    return lastValue;
                }
            }
        }

        public List<String> getLs(String key, String targetValue){
            if(files.containsKey(key)){
                List<String> value = files.get(key);
                if(value.contains(targetValue)){
                    return value;
                }
                else{
                    return null;
                }
            }
            else{
                return null;
            }
        }

        public void mkdir(String path) {
            String[] folders1 = path.split("/");
            String[] folders = new String[folders1.length-1];
            for (int i = 0; i < folders.length; i++) {
                folders[i] = folders1[i+1];
            }
            if(files.isEmpty()){
                //System.out.println("Adding to empty map");
                String firstValue = folders[0];
                //System.out.println("firstValue: "+ firstValue);
                List<String> addFirstValueList = new ArrayList<>();
                addFirstValueList.add(firstValue);
                files.put("/", addFirstValueList);

            }
            else{
                List<String> firstValueList = files.get("/");
                if(!firstValueList.contains(folders[0])){
                    //List<String> addFirstValueToList = new ArrayList<>();
                    firstValueList.add(folders[0]);
                    files.put("/", firstValueList);
                }
            }
            for (int i = 0; i < folders.length; i++) {
                if(!files.containsKey(folders[i])){ // If the folder/file is not in the already existing map key
                    if(i != folders.length-1) {
                        List<String> addValue = new ArrayList<>();
                        addValue.add(folders[i + 1]);
                        files.put(folders[i], addValue);
                    }
                    else{
                        List<String> addFileValue = new ArrayList<>();
                        //addFileValue.add("");
                        files.put(folders[i], addFileValue);
                    }
                }
                else{ // If the folder/file is in the already existing map key
                    List<String> value = files.get(folders[i]);
                    if(i != folders.length-1) { // If its not the last folder/file in the path
                        if (!value.contains(folders[i + 1])) {
                            value.add(folders[i + 1]);
                            files.put(folders[i], value);
                        }
                    }
                    else { // If its the last folder/file in the path
                        if(files.containsKey(folders[i])){
                            System.out.println("In if last element");
                            //lastElement Value -

                        }
                        else {

                            List<String> addFileValueLast = new ArrayList<>();
                            //addFileValueLast.add(folders[i]);
                            //addFileValueLast.add("");
                            files.put(folders[i], addFileValueLast);
                        }
                    }

                }
            }

        }

        public void showFolders(){
            for (String key: files.keySet()){
                System.out.println("Key: " + key + " Value: " + files.get(key));
            }
        }

        public void addContentToFile(String filePath, String content) {
            /*List<String> getPath = ls(filePath);
            System.out.println("Get Path: ");
            System.out.println(getPath);*/
            String[] folders1 = filePath.split("/");
            String[] folders = new String[folders1.length-1];
            for (int i = 0; i < folders.length; i++) {
                folders[i] = folders1[i+1];
            }
            String lastFile = folders[folders.length -1];
            boolean filePathExists = true;
            for(String x: folders){
                //System.out.println("Each file in add: " + x);
            }
            for(String j: folders){
                if(!files.containsKey(j)){
                    filePathExists = false;
                }
            }
            if(filePathExists == false){
                mkdir(filePath);
                List<String>  newContent = new ArrayList<>();
                newContent.add(content);
                files.put(lastFile, newContent);
            }
            else{
                if(files.get(lastFile)==null || files.get(lastFile).isEmpty()){
                    List<String>  newContent = new ArrayList<>();
                    newContent.add(content);
                    files.put(lastFile, newContent);
                }
                else {
                    List<String> oldContent = files.get(lastFile);
                    String justContentString = oldContent.get(0);
                    String addedNewContent = justContentString + content;
                    List<String> addedontentList = new ArrayList<>();
                    addedontentList.add(addedNewContent);
                    files.put(lastFile, addedontentList);
                }
            }

            //if(files.containsKey())
        }

        public String readContentFromFile(String filePath) {
            List<String> getPath = ls(filePath);
            String[] folders = filePath.split("/");
            if(!getPath.isEmpty()){
                String lastFile = folders[folders.length -1];
                List<String> content = files.get(lastFile);
                String value = content.get(0);
                return value;
            }
            else{
                return "";
            }
        }

    public static void main(String[] args) {
        FileSystem obj = new FileSystem();
        // ["FileSystem","ls", "mkdir",     "ls",      "mkdir",    "ls"]
        // [[],          ["/"], ["/a/b/c"],  ["/a/b"], ["/a/b/a"], ["/a/b"]]
        System.out.println("-----------Check for path /-----------");
        List<String> param_0 = obj.ls("/");
        System.out.println(param_0);
        System.out.println("-----------Create path /a/b/c-----------");
        obj.mkdir("/a/b/c");
        obj.showFolders();
        System.out.println("-----------Check for path /a/b-----------");
        List<String> param_1 = obj.ls("/a/b");
        System.out.println(param_1);
        System.out.println("-----------Create path /a/b/a-----------");
        obj.mkdir("/a/b/a");
        obj.showFolders();
        System.out.println("-----------Check for path /a/b-----------");
        List<String> param_2 = obj.ls("/a/b");
        System.out.println(param_2);
        obj.showFolders();
        // [[],          ["/zijzllb"],["/"],["/zijzllb"],["/r"],  ["/"],["/r"],["/zijzllb/hfktg","d"],["/zijzllb/hfktg"],   ["/"], ["/zijzllb/hfktg"]]
        // ["FileSystem","mkdir",     "ls", "ls",        "mkdir", "ls", "ls",  "addContentToFile",    "readContentFromFile", "ls", "readContentFromFile"]
        /*System.out.println("-----------Create path /zijzllb-----------");
        obj.mkdir("/zijzllb");
        obj.showFolders();
        System.out.println("-----------Check for path /-----------");
        List<String> param_0 = obj.ls("/");
        System.out.println(param_0);
        System.out.println("-----------Check for path /zijzllb-----------");
        List<String> param_1 = obj.ls("/zijzllb");
        System.out.println(param_1);
        System.out.println("-----------Create path /r-----------");
        obj.mkdir("/r");
        System.out.println("-----------Check for path /-----------");
        List<String> param_2 = obj.ls("/");
        System.out.println(param_2);
        System.out.println("-----------Check for path /r-----------");
        List<String> param_3 = obj.ls("/r");
        System.out.println(param_3);
        obj.showFolders();
        System.out.println("-----------Add to file path /zijzllb/hfktg d-----------");
        obj.addContentToFile("/zijzllb/hfktg", "d");
        System.out.println("-----------Read from file path /zijzllb/hfktg-----------");
        String contentFromFile = obj.readContentFromFile("/zijzllb/hfktg");*/


        //  [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
        /*System.out.println("-----------Check for path /-----------");
        List<String> param_0 = obj.ls("/");
        System.out.println(param_0);
        System.out.println("-----------Create path /a/b/c-----------");
        obj.mkdir("/a/b/c");
        System.out.println("-----------Add to file path /a/b/c/d Hello-----------");
        obj.addContentToFile("/a/b/c/d", "Hello");
        System.out.println("-----------Check for path /-----------");
        List<String> param_1 = obj.ls("/");
        System.out.println(param_1);
        System.out.println("-----------Read from file path /a/b/c/d-----------");
        String contentFromFile = obj.readContentFromFile("/a/b/c/d");
        System.out.println(contentFromFile);*/

        //obj.mkdir("/goowmfn");

        /*List<String> param_0 = obj.ls("/");
        System.out.println(param_0);
        obj.mkdir("/a/b/c");
        List<String> param_1 = obj.ls("/a/b");
        System.out.println(param_1);*/
        //obj.showFolders();
        /*System.out.println("-----------Check for path /a/b/c-----------");
        List<String> param_0 = obj.ls("/");
        System.out.println(param_0);
        obj.showFolders();
        System.out.println("-----------Check for path /a/b/c-----------");
        List<String> param_1 = obj.ls("/a/b/c");
        System.out.println(param_1);
        obj.showFolders();
        System.out.println("-----------Create path /a/b/c-----------");
        obj.mkdir("/a/b/c");
        obj.showFolders();
        System.out.println("-----------Check for path /a/b/c again-----------");
        List<String> param_2 = obj.ls("/a/b/c");
        System.out.println(param_2);
        System.out.println("-----------Create path /a/b/d-----------");
        obj.mkdir("/a/b/d");
        obj.showFolders();
        System.out.println("-----------Check for path /a/b-----------");
        List<String> param_3 = obj.ls("/a/b");
        System.out.println(param_3);
        obj.showFolders();
        System.out.println("-----------Add to file path /a/b/d-----------");
        obj.addContentToFile("a/b/d", "Hello");
        obj.showFolders();
        System.out.println("-----------Check for path /a/b/d-----------");
        List<String> param_4 = obj.ls("/a/b/d");
        System.out.println(param_4);
        obj.showFolders();
        System.out.println("-----------Add to file path /a/b/d-----------");
        obj.addContentToFile("a/b/d", " World");
        obj.showFolders();
        System.out.println("-----------Read from file path /a/b/d-----------");
        String contentFromFile = obj.readContentFromFile("a/b/d");
        System.out.println(contentFromFile);
        obj.showFolders();*/

    }
/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */


}
