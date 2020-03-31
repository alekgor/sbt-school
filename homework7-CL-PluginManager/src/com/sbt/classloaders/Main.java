package com.sbt.classloaders;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        System.out.println("hello");

        String pluginName = "NewPlugin";
        String pluginRootDirectory = "RootDirectory";

        // Plugin подгружается системным загрузчиком, поэтому мы можем пользоваться через него нашими плагинами
        // избегая ClassCast

        // Создадим плагин-менеджер
        PluginManager manager = new PluginManager(pluginRootDirectory);

        // Загрузим NewPlugin.class из RootDirectory/NewPlugin/
        Plugin newPlugin = manager.load(pluginName, pluginName);

        // Загрузим GooglePlugin.class из RootDirectory/GooglePlugin/
        Plugin googlePlugin = manager.load("GooglePlugin", "GooglePlugin");

        // Загрузим FastPlugin.class из RootDirectory/FastPlugin/
        Plugin fastPlugin = manager.load("FastPlugin", "FastPlugin");

        // Загрузим FastPlugin.class из RootDirectory/GooglePlugin/  (Два класса с одним именем)
        Plugin fastPluginInGooglePlugin = manager.load("GooglePlugin", "FastPlugin");


        // Вызовим у каждого метод System.out.println(this.getClass().getName() + " : "+this.getClass().getClassLoader());
        newPlugin.doUsefull();
        fastPlugin.doUsefull();
        googlePlugin.doUsefull();
        fastPluginInGooglePlugin.doUsefull();


    }
}
