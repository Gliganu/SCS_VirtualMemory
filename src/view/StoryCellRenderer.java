package view;

import controller.Chapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class StoryCellRenderer extends JLabel implements ListCellRenderer<String> {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public StoryCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }

    @Override
    public Component getListCellRendererComponent(JList list, String value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        setText(index+". "+value);

        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}