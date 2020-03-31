package com.sbt.classloaders;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


// Кодировщик. Прибавляет к байту key
public class Coder {
    private String key = "10";
    public String dir = "";

    public Coder(String dir) {
        this.dir = dir;
    }

    public File encode(File f) throws IOException {
        byte[] bytes = FileHelper.loadByteOfClass(f);

        File res = new File(dir + File.separatorChar + "Enc" + f.getName());
        FileOutputStream st = new FileOutputStream(res);
        for (byte b : bytes) {
            st.write(b + Byte.parseByte(key));
        }
        st.close();
        return res;
    }
}
