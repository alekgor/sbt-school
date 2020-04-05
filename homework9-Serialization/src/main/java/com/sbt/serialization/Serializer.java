package com.sbt.serialization;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Serializer {

    public static void serialize(File file, Object o) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(o);
        }
    }

    public static void serialize(File directory, String dstFileName, Object o) throws IOException {
        File file = new File(directory.getPath()
                + File.separatorChar
                + dstFileName);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(o);
        }
    }

    public static void toZIP(File file) throws IOException {

        try (FileOutputStream fs = new FileOutputStream(file.getAbsolutePath() + ".zip");
             ZipOutputStream zip = new ZipOutputStream(fs)) {
            byte[] buffer;
            try (FileInputStream fis = new FileInputStream(file)) {
                ZipEntry entry1 = new ZipEntry(file.getName());
                zip.putNextEntry(entry1);
                // считываем содержимое файла в массив byte
                buffer = new byte[fis.available()];
                fis.read(buffer);
                // добавляем содержимое к архиву
                zip.write(buffer);
                // закрываем текущую запись для новой записи
                zip.closeEntry();
            }
        } finally {
            file.delete();
        }
    }


    public static File unZIP(File file) {
        boolean flag = false;
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(file))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                // распаковка
                FileOutputStream fout = new FileOutputStream("delete.bin");
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
                flag = true;
            }
        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
            return null;
        }
        return flag ? new File("delete.bin") : null;
    }


    public static Object deserialize(File file) {
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            return in.readObject();
        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(e.getMessage());
            return null;
        } finally {
            file.delete();
        }
    }
}
