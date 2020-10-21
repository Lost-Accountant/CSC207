import javafx.application.Application;
import javafx.stage.Stage;

public class controller extends Application {
        data d;
        view v;

        public controller(){
        this.d = new data ("123");
        this.v = new view ();
        this.d.attach(this.v);

        }

        public static void main (String [] args){
        controller c = new controller();
        c.d.changedata();
        }

        public void start(Stage s){

        }
}
