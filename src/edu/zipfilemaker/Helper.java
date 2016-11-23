package edu.zipfilemaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by alex on 22.11.16.
 */
public class Helper {

    public static String getUserInput(String inviteMessage) {
        String inputLine = null;
        boolean validInput = false;
        while (!validInput) {
            System.out.println(inviteMessage + " ");
            try {
                BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
                inputLine = is.readLine();
                if (inputLine.length() != 0) validInput = true;
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return inputLine;
    }

    public static boolean isFolderExists(File folder) {
        if (folder.exists() && folder.isDirectory())
            return true;
        else return false;
    }

    public static String getPathToFolder(String s) {
        boolean validInput = false;
        File root = null;
        while (!validInput) {
            root = new File(getUserInput(s));
            if (isFolderExists(root))
                validInput = true;
            else
                System.out.println("Каталог не существует или указан неверный путь к нему.");
        }
        String path = root.getPath();
        return path;
    }

}
