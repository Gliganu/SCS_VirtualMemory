package view;

import controller.Chapter;
import model.MemoryBlock;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */

public class ChapterDashboard extends JPanel {

    private Chapter chapter;

    public ChapterDashboard(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.RED);

        g2d.draw(new Rectangle2D.Float(50,50,30,30));


    }
}
