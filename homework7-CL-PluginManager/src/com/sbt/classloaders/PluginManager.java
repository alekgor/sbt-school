package com.sbt.classloaders;

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory) {
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName,String pluginClassName ) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader loader = new MyClassLoader(pluginRootDirectory,pluginName);
        Class clazz = Class.forName(pluginClassName,false,loader);
        com.sbt.classloaders.Plugin plugin;
        plugin = (com.sbt.classloaders.Plugin)clazz.newInstance();
        return plugin;
    }
}
