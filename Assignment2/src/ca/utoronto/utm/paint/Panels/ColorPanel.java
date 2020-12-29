package ca.utoronto.utm.paint.Panels;

import ca.utoronto.utm.paint.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class ColorPanel extends JPanel implements ActionListener {

    private View view;

    public ColorPanel(View view){
        this.view = view;

        this.createColorButtons();
    }

    public void createColorButtons(){
        String[] colorLabels = {"Red", "Green", "Blue", "Black", "White", "Yellow", "Pink", "Orange"};
        this.setLayout(new GridLayout(colorLabels.length, 1));
        for (String label : colorLabels) {
            JButton button = new JButton(label);
            button.setBackground(getColor(label));
            button.setForeground(Color.WHITE);
            this.add(button, BorderLayout.SOUTH);
            button.addActionListener(this);
        }
    }

    public Color getColor(String color){
//       //     Field field = Class.forName("java.awt.Color").getField(color.toLowerCase());
       //     Color returnColor = (Color)field.get(null);
            // make it semi transparent
       //     return new Color(returnColor.getRed(), returnColor.getGreen(), returnColor.getBlue(), 50);
       // } catch (Exception e){
        //    return null;
        //}
        // reflection seems not steady

        Color returnColor = null;
        switch(color){
            case "Red":
                returnColor = Color.RED;
                break;
            case "Green":
                returnColor = Color.GREEN;
                break;
            case "Blue":
                returnColor = Color.BLUE;
                break;
            case "Black":
                returnColor = Color.BLACK;
                break;
            case "White":
                returnColor = Color.WHITE;
                break;
            case "Yellow":
                returnColor = Color.YELLOW;
                break;
            case "Pink":
                returnColor = Color.PINK;
                break;
            case "Orange":
                returnColor = Color.ORANGE;
                break;
        }
        return returnColor;
    }

    /**
     * Controller aspect
     */
    @Override
    public void actionPerformed(ActionEvent e){
        //this.view.getPaintPanel().setConfiguration(e.getActionCommand());
        System.out.println(e.getActionCommand());
    }
}
