package com.finepointmobile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int totalTimes = 0;
        ArrayList<String> lines;
        lines = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Search keyword:");
        String keyword = scanner.next();

        try {
            URL url = new URL("https://finepointmobile.com/");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String data;
            while ((data = reader.readLine()) != null) {
                if (data.contains(keyword)) {
                    lines.add(data);
                    totalTimes++;
                }
            }

            System.out.println("Contains keyword " + totalTimes + ".");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
