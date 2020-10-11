import javafx.scene.control.TextField;

import java.util.Observable;
import java.util.Observer;

// about how the GUI should be updated, but not the GUI itself

public class View extends TextField implements Observer{
    public View(){
        this.setText("placeholder");
    }

    @Override
    public void update(Observable o, Object arg){
        Model model = (Model) o;
        // specify the observable is a Model named o
        this.setText(model.a);
    }
}
