package org.example.examle0;

public class Solution {
    public static void main(String[] args) {

        Thread thread = new Thread(
                // ВОТ СЮДА ДАВАТЬ Runnable
                );

        System.out.println(thread.getState());

        System.out.println(thread.getThreadGroup());


    }
}
