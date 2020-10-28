// Factory Design Pattern

public class TextDocument extends Document{
    private String type;
    // implementation
    public TextDocument(){
        this.type = "Text";
    }

    @Override
    public void open(){
        System.out.println("it is open now");
    }
}
