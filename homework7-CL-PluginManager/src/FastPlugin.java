public class FastPlugin implements com.sbt.classloaders.Plugin {
    @Override
    public void doUsefull() {
        System.out.println(this.getClass().getName() + " : "+this.getClass().getClassLoader());
    }
}
