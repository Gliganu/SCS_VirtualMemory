package view;

import controller.Chapter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class ChapterChooserPanel extends JPanel {


    private MainFrame parent;
    private JList<Chapter> chapterList;
    private Chapter selectedChapter;

    public ChapterChooserPanel(MainFrame parent, List<Chapter> chapters) {

        this.parent = parent;
        initUI(chapters);
    }

    private void initUI(List<Chapter> chapters) {

        DefaultListModel<Chapter> listModel = new DefaultListModel<>();

        for(Chapter chapter: chapters){
            listModel.addElement(chapter);
        }

        chapterList = new JList<>(listModel);
        chapterList.setCellRenderer(new ChapterCellRenderer());

        addListener();

        int selectedChapter = 6;
        chapterList.setSelectedIndex(selectedChapter);
        parent.setSelectedChapter(chapters.get(selectedChapter));

        add(chapterList);
    }

    private void addListener() {
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {

                Chapter newChapter = chapterList.getSelectedValue();

                if(!newChapter.equals(selectedChapter)){
                    parent.setSelectedChapter(newChapter);
                    selectedChapter = newChapter;
                }

            }
        };
        chapterList.addMouseListener(mouseListener);
    }
}
