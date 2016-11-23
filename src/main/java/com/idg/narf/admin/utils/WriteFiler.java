package com.idg.narf.admin.utils;

import com.idg.narf.admin.pojos.ImageFileEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by agermenos on 11/22/16.
 */
public class WriteFiler {
    public static void writeCommand(ImageFileEntity imageFile, String pngToJpgPath, String pngToJpgSql, String formatFrom, String formatTo) {
        String command = pngToJpgSql;
        if (imageFile.getPath() != null) {
            command = command.replace("$1", imageFile.getPath().replace(formatFrom, formatTo));
        }
        if (imageFile.getUrl() != null) {
            command = command.replace("$2", imageFile.getUrl().replace(formatFrom, formatTo));
        }
        command = command.
                replace("$3", imageFile.getImageFileKey().getImage_id() + "").
                replace("$4", imageFile.getImageFileKey().getImage_type_id() + "");
        try {
            if (!command.contains("$1")){
                Files.write(Paths.get(pngToJpgPath), command.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
