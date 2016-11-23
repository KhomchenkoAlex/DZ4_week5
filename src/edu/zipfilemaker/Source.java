package edu.zipfilemaker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

/**
 * Created by alex on 23.11.16.
 */
public class Source {


    static ZipOutputStream audioZip;
    static ZipOutputStream videoZip;
    static ZipOutputStream imageZip;


    public static void openSource(String pathToZipArchives) throws IOException {

        audioZip = new ZipOutputStream(new FileOutputStream(pathToZipArchives + "/audio.zip"));
        videoZip = new ZipOutputStream(new FileOutputStream(pathToZipArchives + "/video.zip"));
        imageZip = new ZipOutputStream(new FileOutputStream(pathToZipArchives + "/image.zip"));
    }

    public static void closeSource() throws IOException {

        imageZip.close();
        videoZip.close();
        audioZip.close();
    }
}

