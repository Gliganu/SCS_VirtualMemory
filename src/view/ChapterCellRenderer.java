package view;

import controller.Chapter;
import model.Type;

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

    public Component getListCellRendererComponent(JList list, Chapter chapter,
                                                  int index, boolean isSelected, boolean cellHasFocus) {

        setText(index+". "+chapter.getName());
        Type.TypeInformation info = chapter.getType().getInfo();

        Color foregroundColor= null;
        switch(info){

            case PROBLEM:
                foregroundColor = Color.RED;
                break;
            case SOLUTION:
                foregroundColor = new Color(0,100,0);
                break;
            case INFO:
                foregroundColor = Color.BLUE;
                break;
        }

        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(foregroundColor);
        }
        return this;
    }
}