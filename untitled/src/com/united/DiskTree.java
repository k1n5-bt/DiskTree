package com.united;

import java.io.*;
import java.util.Scanner;

public class DiskTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GetDiskTree(scanner.next(), 0);
    }

    public static void GetDiskTree(String path, int depth) {
        File file = null;
        try{
            file = new File(path);
        }
        catch (Exception e) {
            System.out.println("File is not found");
        }
        File[] catalog = file.listFiles();
        StringBuilder indent = new StringBuilder();
        while (indent.length() != depth) {
            indent.append(" ");;
        }
        for (File e:catalog) {
            System.out.println(indent.toString() + e.getName());
            if(e.isDirectory()){
                GetDiskTree(e.getAbsolutePath(), ++depth);
            }
        }
    }
}
