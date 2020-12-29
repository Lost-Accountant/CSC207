package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.Locale;

public class ConfigurationChooserPanel extends JPanel implements ActionListener, ChangeListener { // extends JPanel implements ActionListener {

    private View view;

    // line thickness
    static final int LINE_MIN = 1;
    static final int LINE_MAX = 10;

    // title label
    static JLabel lineThichknessTitle;
    private JSlider lineThickness;

    public ConfigurationChooserPanel(View view){
        this.view = view;

        this.setLayout(new BorderLayout());

        // Slider for Line Thickness
        this.createLineThicknessSlider();

        // Buttons for different colors
        this.createColorButtons();
    }

    public void createLineThicknessSlider(){
        lineThickness = new JSlider(JSlider.HORIZONTAL,
                LINE_MIN, LINE_MAX, LINE_MIN);
        lineThickness.addChangeListener(this);
        // provide labels
        lineThickness.setMajorTickSpacing(1);
        lineThickness.setPaintTicks(true);
        lineThickness.setPaintLabels(true);
        // provide title label
        lineThichknessTitle = new JLabel("Slide for line thickness adjustment",
                JLabel.CENTER);
        // set font
        //Font font = new Font("Serif", Font.ITALIC, 15);
        //lineThichknessTitle.setFont(font);
        this.add(lineThickness, BorderLayout.WEST);
        this.add(lineThichknessTitle,BorderLayout.EAST);
    }

    public void createColorButtons(){
        String[] colorLabels = {"Red", "Green", "Blue", "Black", "White", "Yellow"};
        this.setLayout(new GridLayout(1, colorLabels.length));
        for (String label : colorLabels) {
            JButton button = new JButton(label);
            button.setBackground(getColor(label));
            this.add(button, BorderLayout.SOUTH);
            button.addActionListener(this);
        }
    }

    public Color getColor(String color){
        try {
            Field field = Class.forName("java.awt.Color").getField(color.toLowerCase());
            Color returnColor = (Color)field.get(null);
            // make it semi transparent
            return new Color(returnColor.getRed(), returnColor.getGreen(), returnColor.getBlue(), 200);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * Controller aspect
     */
    @Override
    public void actionPerformed(ActionEvent e){
        //this.view.getPaintPanel().setConfiguration(e.getActionCommand());
        System.out.println(e.getActionCommand());
    }

    @Override
    public void stateChanged(ChangeEvent e){
        System.out.println(e.getSource());
        lineThichknessTitle.setText("Line Thickness: " + lineThickness.getValue());
    }
}
