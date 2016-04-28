package view;

import controller.Chapter;
import model.AddressBlock;
import model.MemoryBlock;
import model.MemoryElement;
import model.MemoryLink;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */

public class ChapterDashboard extends JPanel {

    private final int ARRROW_HEAD_SIZE = 10;
    private final int MEM_BLOCK_WRITE_BUFFER = 10;

    private Chapter chapter;

    public ChapterDashboard(Chapter chapter) {
        this.chapter = chapter;
        initUI();
    }

    private void initUI() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + "," + y);//these co-ords are relative to the component
            }
        });

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

        if (!memoryElement.getMemoryElementView().isVisible()) {
            return;
        }

        if(memoryElement instanceof MemoryBlock){
            drawMemoryBlock(g2d, (MemoryBlock) memoryElement);
        }

        if(memoryElement instanceof MemoryLink){
            drawMemoryLink(g2d, (MemoryLink) memoryElement);

        }

    }

    private void drawMemoryLink(Graphics2D g2d, MemoryLink memLink) {
        Point fromPoint = UIUtils.getDrawPointForAddressBlock(memLink.getFromAddressBlock(), true);
        Point toPoint = UIUtils.getDrawPointForAddressBlock(memLink.getToAddressBlock(), false);


        g2d.setColor(memLink.getMemoryElementView().getColor());
        g2d.draw(new Line2D.Double(fromPoint.x, fromPoint.y, toPoint.x, toPoint.y));

        g2d.fillRect(toPoint.x - ARRROW_HEAD_SIZE, toPoint.y - ARRROW_HEAD_SIZE / 2, ARRROW_HEAD_SIZE, ARRROW_HEAD_SIZE);


        g2d.drawString(memLink.getDescription(), (fromPoint.x + toPoint.x) / 2, (fromPoint.y + toPoint.y) / 2 - 10);
    }

    private void drawMemoryBlock(Graphics2D g2d, MemoryBlock memoryBlock) {

        MemoryElementView view = memoryBlock.getMemoryElementView();
        List<AddressBlock> addressBlockList = memoryBlock.getAddressBlockList();

        int x = view.getX();
        int y = view.getY();
        int height = view.getHeight();
        int width = view.getWidth();

        int addressBlockHeight = height / addressBlockList.size();

        if (view.isWithTopDescription()){
            g2d.drawString(memoryBlock.getDescription(), x - 40, y - addressBlockHeight);
        }

        for (AddressBlock addressBlock : addressBlockList) {

            if (addressBlock.isHidden()) {
                continue;
            }

            int indexOf = addressBlockList.indexOf(addressBlock);

            g2d.setColor(view.getColor());
            g2d.fill(new Rectangle2D.Float(x, y + indexOf * addressBlockHeight, width, addressBlockHeight));

            if (view.isWithInsideDescription() && addressBlockList.indexOf(addressBlock) == 1 && !view.isOnePiece()) {
                g2d.setColor(Color.black);
                g2d.drawString(memoryBlock.getDescription(), x+10, y + indexOf * addressBlockHeight - addressBlockHeight / 2);
            }

            if (view.isWithSideDescription()) {
                g2d.setColor(Color.black);
                g2d.drawString(addressBlock.getLeftDescription(), x - 40, y + indexOf * addressBlockHeight + 20);
            }


            g2d.setColor(Color.BLACK);
            g2d.drawString(addressBlock.getInDescription(), x+10, y + (indexOf + 1) * addressBlockHeight - addressBlockHeight / 2);


            if (!view.isOnePiece()) {
                g2d.setColor(Color.white);
                g2d.draw(new Rectangle2D.Float(x, y + indexOf * addressBlockHeight, width, 1));
            }

        }

        g2d.setColor(Color.black);

        if (view.isOnePiece()) {
            g2d.drawString(memoryBlock.getDescription(), x + MEM_BLOCK_WRITE_BUFFER, y + (addressBlockHeight * addressBlockList.size() / 2));
        }


    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
        repaint();
    }

    public void repaintChapterComponents() {
        repaint();
    }
}
