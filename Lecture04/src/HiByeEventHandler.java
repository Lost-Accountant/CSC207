import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HiByeEventHandler implements EventHandler<ActionEvent>{
    Button btn;
    public HiByeEventHandler(Button btn){
        this.btn = btn;
    }

    public void handle(ActionEvent event){
        // the code that ran every time the button is clicked
        System.out.println(btn.getText());

        return;
    }
}
