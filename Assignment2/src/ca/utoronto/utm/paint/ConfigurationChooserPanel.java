package ca.utoronto.utm.paint;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
