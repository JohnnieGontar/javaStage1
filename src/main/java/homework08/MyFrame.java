package homework08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private final JSplitPane splitPane;
    private final JPanel topPanel;
    private final JPanel bottomPanel;
    public JButton[] jbs;
    public JButton isRepeatYes = new JButton("да");
    public JButton isRepeatNo = new JButton("нет");
    public MyFrame(){

        splitPane = new JSplitPane();

        topPanel = new JPanel();
        bottomPanel = new JPanel();

        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 450));
        setLocationRelativeTo(null);

        getContentPane().setLayout(new GridLayout());

        getContentPane().add(splitPane);

        splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
        splitPane.setDividerLocation(50);
        splitPane.setTopComponent(topPanel);
        splitPane.setBottomComponent(bottomPanel);

        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

        JTextArea infoText = new JTextArea("Идёт игра");
        topPanel.add(infoText);


        JPanel ticTacToe = new JPanel(new GridLayout(5, 5));
        jbs = new JButton[25];

        TicTacToe.prepareGame();

        addButtons(infoText, ticTacToe);

        bottomPanel.add(ticTacToe);

        pack();
    }


    private void addButtons(JTextArea infoText, JPanel ticTacToe) {
        addNameForButtons();
        addActionsForButtons(infoText, ticTacToe);
    }

    private void addNameForButtons() {
        int row = 0;
        int col = 0;
        for (int i = 0; i < jbs.length; i++) {
            if((i + 1) % 5 == 0) {
                jbs[i] = new JButton(String.valueOf(TicTacToe.DOT_EMPTY));
                jbs[i].setName(row + ":" + col);
                col = 0;
                row++;
            } else {
                jbs[i] = new JButton(String.valueOf(TicTacToe.DOT_EMPTY));
                jbs[i].setName(row + ":" + col);
                col++;
            }
        }
    }


    private void addActionsForButtons(JTextArea infoText, JPanel ticTacToe) {
        for (JButton jb : jbs) {
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (HumanTurn(e, infoText)) {
                        if (!AiTurn(infoText)) {
                            repeatGame(infoText);
                        }
                    } else {
                        repeatGame(infoText);
                    }
                }
            });
            ticTacToe.add(jb);
        }
    }

    private void repeatGame(JTextArea infoText) {
        infoText.setText(infoText.getText() + "\nПовторить?");

        isRepeatYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton jb : jbs) {
                    jb.setBackground(null);
                    jb.setEnabled(true);

                    TicTacToe.prepareGame();

                    topPanel.remove(isRepeatYes);
                    topPanel.remove(isRepeatNo);
                    repaint();

                    infoText.setText("Идёт игра");
                }
            }
        });
        isRepeatNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        topPanel.add(isRepeatYes);
        topPanel.add(isRepeatNo);
    }

    private boolean AiTurn(JTextArea infoText) {
        int aiPos[] = TicTacToe.aiTurn();
        JButton jbAi = null;
        for (JButton jb : jbs) {
            if (jb.getName().equals(aiPos[0] + ":" + aiPos[1])) {
                jbAi = jb;
                jbAi.setBackground(Color.orange);
            }
        }

        jbAi.setEnabled(false);
        int moveResult = TicTacToe.checkEnd(TicTacToe.DOT_O);

        if (moveResult == 1) {
            infoText.setText(TicTacToe.AI_WIN_MESSAGE);
            return false;
        } else if (moveResult == 2) {
            infoText.setText("Игра закончена! Ничья");
            return false;
        } else {
            return true;
        }
    }

    private boolean HumanTurn(ActionEvent e, JTextArea infoText) {
        JButton activeBut = ((JButton) e.getSource());
        String nameBut = activeBut.getName();
        String[] rowAndCol = nameBut.split(":");

        activeBut.setBackground(Color.cyan);

        TicTacToe.humanTurn(rowAndCol[0], rowAndCol[1]);

        activeBut.setEnabled(false);
        int moveResult = TicTacToe.checkEnd(TicTacToe.DOT_X);

        if (moveResult == 1) {
            infoText.setText(TicTacToe.PLAYER_WIN_MESSAGE);
            return false;
        } else if (moveResult == 2) {
            infoText.setText("Игра закончена! Ничья");
            return false;
        } else {
            return true;
        }
    }

}
