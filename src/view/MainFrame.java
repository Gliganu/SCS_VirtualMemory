package view;

import controller.Chapter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by GligaBogdan on 31-Mar-16.
 */
public class MainFrame extends JFrame{

    private ChapterChooserPanel chapterChooserPanel;
    private StorylinePanel storylinePanel;
    private JSplitPane   splitPane;
    private ChapterDashboard chapterDashboard;
    private TitlePanel titlePanel;

    public MainFrame(List<Chapter> chapterList) {
        initUI(chapterList);

    }

    private void initUI(List<Chapter> chapterList) {

        titlePanel = new TitlePanel("Select chapter");
        chapterDashboard = new ChapterDashboard(null);
        chapterChooserPanel = new ChapterChooserPanel(this, chapterList);
        storylinePanel = new StorylinePanel(this);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, chapterChooserPanel, chapterDashboard);


        setLayout(new BorderLayout());


        splitPane.setOneTouchExpandable(true);

        add(titlePanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
        add(storylinePanel, BorderLayout.EAST);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(100, 50);
        this.setSize(1250, 500);
        //  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(500, 400));
        this.setVisible(true);
    }

    public void setSelectedChapter(Chapter newChapter) {
        //todo smth here
        titlePanel.setTitle(newChapter.getName());
        MemoryElementViewFactory.constructMemoryViewForChapter(newChapter);
        chapterDashboard.setChapter(newChapter);
    }
}
