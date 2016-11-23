package edu.zipfilemaker;

import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Created by alex on 21.11.16.
 */
public class FileFilters {

    static FileNameExtensionFilter audioFilter = new FileNameExtensionFilter("Audio file", "mp3", "wav", "wma");
    static FileNameExtensionFilter videoFilter = new FileNameExtensionFilter("Video file", "avi", "mp4", "flv");
    static FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image file", "jpg", "jpeg", "gif", "png");

}
