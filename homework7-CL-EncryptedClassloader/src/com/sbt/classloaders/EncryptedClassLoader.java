package com.sbt.classloaders;

import java.io.File;

public class EncryptedClassLoader extends ClassLoader {
    private final String key;
    private final File dir;

    public EncryptedClassLoader(String key, File dir, ClassLoader parent) {
        super(parent);
        this.key = key;
        this.dir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(dir.getAbsolutePath()+File.separatorChar +"Enc"+ name + ".class");

        byte[] bytes = new byte[(int) f.length()];
        byte[] newBytes = new byte[(int) f.length()];
        bytes = FileHelper.loadByteOfClass(f);
        int i = 0;
        for (Byte b : bytes) {
            newBytes[i++] = (byte) (b - Byte.parseByte(key));
        }

        return defineClass(name, newBytes, 0, newBytes.length);
    }
}
