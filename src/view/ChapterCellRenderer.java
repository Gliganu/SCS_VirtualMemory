package view;

import controller.Chapter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class ChapterCellRenderer extends JLabel implements ListCellRenderer<Chapter> {
    private static final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

    public ChapterCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
    }

    public Component getListCellRendererComponent(JList list, Chapter value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        Chapter entry = (Chapter) value;
        setText(entry.getName());
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