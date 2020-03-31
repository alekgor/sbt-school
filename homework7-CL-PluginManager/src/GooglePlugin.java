import com.sbt.classloaders.Plugin;

public class GooglePlugin implements Plugin {
    @Override
    public void doUsefull() {
        System.out.println(this.getClass().getName() + " : "+this.getClass().getClassLoader());
    }
}
