package com.sbt;

import java.io.*;

public class Serializer {

    public static void serialize(File directory, Object o) throws IOException {
        File file = new File(directory.getPath()
                + File.separatorChar
                + o.getClass().getName());
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(o);
        }
    }

    public static <T> T deserialize(File file, Class<T> clazz) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            return (T) in.readObject();
        }
    }
}
