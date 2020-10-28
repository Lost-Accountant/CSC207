public abstract class MyApplication extends Application{
    public Document createDocument(){
        return new TextDocument();
    }
}