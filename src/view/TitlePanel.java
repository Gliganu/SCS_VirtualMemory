package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class TitlePanel extends JPanel {

    private Label label;


    public TitlePanel(String title) {
        label = new Label(title);
        initUI();
    }

    private void initUI() {
        add(label);
    }

    public void setTitle(String title) {
        label.setText(title);
    }


}
