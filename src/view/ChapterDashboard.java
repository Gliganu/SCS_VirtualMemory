package view;

import controller.Chapter;
import model.MemoryBlock;
import model.MemoryElement;
import model.MemoryLink;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
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

        if(chapter == null){
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        for(MemoryElement memoryElement  : chapter.getMemoryElementList()){
            drawMemoryElement(memoryElement,g2d);
        }

    }

    private void drawMemoryElement(MemoryElement memoryElement, Graphics2D g2d) {

        MemoryElementView view = memoryElement.getMemoryElementView();
        g2d.setColor(view.getColor());

        if(memoryElement instanceof MemoryBlock){
            g2d.fill(new Rectangle2D.Float(view.getX(),view.getY(),view.getWidth(),view.getHeight()));
        }

        if(memoryElement instanceof MemoryLink){
            MemoryLink memLink = (MemoryLink) memoryElement;
            Point fromPoint = memLink.getFromAddressBlock().getDrawPoint();
            Point toPoint = memLink.getToAddressBlock().getDrawPoint();
            g2d.draw(new Line2D.Double(fromPoint.x,fromPoint.y, toPoint.x, toPoint.y));
        }

    }



    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
        repaint();
    }
}
