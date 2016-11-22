package edu.zipfilemaker;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static edu.zipfilemaker.FileFilters.*;

public class Main {

    public static void main(String[] args) throws Exception {

        ZipOutputStream audioZip = new ZipOutputStream(new FileOutputStream("/home/alex/audio.zip"));
        ZipOutputStream videoZip = new ZipOutputStream(new FileOutputStream("/home/alex/video.zip"));
        ZipOutputStream imageZip = new ZipOutputStream(new FileOutputStream("/home/alex/image.zip"));

        File folder = new File("/home/alex/Test1");

        if (folder.exists() && folder.isDirectory()) {
            doZip(folder, imageZip, imageFilter);
            doZip(folder, videoZip, videoFilter);
            doZip(folder, audioZip, audioFilter);
        } else {
            System.out.println("");
        }

        imageZip.close();
        videoZip.close();
        audioZip.close();
    }


    private static void doZip(File dir, ZipOutputStream out, FileNameExtensionFilter filter) throws IOException {
        for (File f : dir.listFiles()) {
                if (f.isDirectory())
                    doZip(f, out, filter);
                else {
                    if (filter.accept(f)) {
                        out.putNextEntry(new ZipEntry(f.getName()));// или использовать f.getPath() для отображения дерева директорий, ведущих к файлу
                        try {
                            writeFile(new FileInputStream(f), out);
                        } catch (IOException e) {
                            System.out.println("Ошибка записи файла " + f.getPath());
                            e.printStackTrace();
                        }
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

