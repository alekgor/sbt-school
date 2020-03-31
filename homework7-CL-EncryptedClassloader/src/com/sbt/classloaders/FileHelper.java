package com.sbt.classloaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// Доп функции для работы с файлами
public class FileHelper {
    public static File findFile(String rootDirectory, String name) {
        File f = new File(new File("").getAbsolutePath() + File.separatorChar
                + rootDirectory + File.separatorChar + name.replace('.',File.separatorChar) + ".class");
        if (f.exists()) {
            return f;
        } else {
            return null;
        }
    }

    public static byte[] loadByteOfClass(File f) {
        byte[] b = new byte[(int)f.length()];
        try {
            try (FileInputStream st = new FileInputStream(f)) {
                st.read(b,0,b.length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
