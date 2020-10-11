import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class some_eventhandler implements EventHandler<ActionEvent>{
    Model model;
    public some_eventhandler(Model a){
        this.model = a;
    }

    @Override
    public void handle(ActionEvent event){
        // this line is important, without it the GUI will not update
        // connect Model with View
        // when button in GUI pressed. Event listener calls for change.
        model.You_changed();
        System.out.println(model.a);
    }
}
