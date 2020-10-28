// Factory Design Pattern

import java.util.ArrayList;
import java.util.List;

public abstract class Application {
    private List<Document> docs = new ArrayList<Document>();
    public void newDocument(){
        Document doc = createDocument();
        docs.add(doc);
        doc.open();
    }

    public abstract Document createDocument(); // factory method

}
