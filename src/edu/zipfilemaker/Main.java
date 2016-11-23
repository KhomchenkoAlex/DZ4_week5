package edu.zipfilemaker;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static edu.zipfilemaker.FileFilters.*;
import static edu.zipfilemaker.Helper.getPathToFolder;
import static edu.zipfilemaker.Source.*;

public class Main {

    public static void main(String[] args) {

        String pathToZipArchives = getPathToFolder("Укажите путь к рабочему каталогу где будут созданы архивы: ");

        try {
            openSource(pathToZipArchives);
        } catch (IOException e) {
            System.out.println(e);
        }

        String pathToFolderForZip = getPathToFolder("Укажите путь к каталогу для архивации: ");

        File folder = new File(pathToFolderForZip);

        try {
            doZip(folder, imageZip, imageFilter);
            doZip(folder, videoZip, videoFilter);
            doZip(folder, audioZip, audioFilter);
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            closeSource();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private static void doZip(File dir, ZipOutputStream out, FileNameExtensionFilter filter) throws IOException {
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                doZip(f, out, filter);
            else if (filter.accept(f)) {
                    out.putNextEntry(new ZipEntry(f.getName()));// или использовать f.getPath() для отображения дерева директорий, ведущих к файлу
                    try {
                        writeFile(new FileInputStream(f), out);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }
        }

    private static void writeFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }

}

