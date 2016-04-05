package view;

import controller.Chapter;
import model.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private int currentCommandIndex = 0;

    private Chapter chapter;

    public MainFrame(List<Chapter> chapterList) {
        initUI(chapterList);

    }

    private void initUI(List<Chapter> chapterList) {

        titlePanel = new TitlePanel("Select chapter");
        storylinePanel = new StorylinePanel(this);
        chapterDashboard = new ChapterDashboard(null);
        chapterChooserPanel = new ChapterChooserPanel(this, chapterList);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, chapterChooserPanel, chapterDashboard);


        setLayout(new BorderLayout());

        addListeners();

        splitPane.setOneTouchExpandable(true);

        add(titlePanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
        add(storylinePanel, BorderLayout.EAST);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(2000, 50);
        setSize(1250, 500);
        setFocusable(true);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(500, 400));
        this.setVisible(true);
    }

    private void addListeners() {

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_SPACE) {
                    processCurrentChapterCommand();
                }

            }
        });


    }

    private void processCurrentChapterCommand() {

        List<Command> commandList = chapter.getCommandList();

        if (currentCommandIndex >= commandList.size()) {
            return;
        }

        Command command = commandList.get(currentCommandIndex);

        processCommand(command);

        chapterDashboard.repaintChapterComponents();
        currentCommandIndex++;

    }

    private void processCommand(Command command) {
        switch (command.getCommandType()) {

            case ELEMENT_VISIBILITY:
                command.changeMemoryElementVisibility();
                break;

            case NEXT_STORY:
                String nextStory = chapter.getStoryline().getNextStory();
                storylinePanel.addStory(nextStory);
                break;

            case ADDRESS_BLOCK_WRITE:
                command.changeAddressBlockDescription();
                break;
        }

        for (Command innerCommand : command.getInnerCommands()) {
            processCommand(innerCommand);
        }
    }

    public void setSelectedChapter(Chapter newChapter) {

        chapter = newChapter;
        currentCommandIndex = 0;

        titlePanel.setTitle(newChapter.getName());
        MemoryElementViewFactory.constructMemoryViewForChapter(newChapter);
        chapterDashboard.setChapter(newChapter);
        storylinePanel.clearStories();
        requestFocusInWindow();

    }
}
