package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class DiceView extends JPanel implements Observer{
    private DiceController controller;
    private Label label;

    public DiceView(DiceController controller){
        this.controller = controller;
        this.label = new Label();
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("(" + ((Dice) o).getD1() + ", " + ((Dice) o).getD2() + ")");
    }
}
