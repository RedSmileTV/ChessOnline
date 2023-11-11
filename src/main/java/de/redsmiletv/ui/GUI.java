package de.redsmiletv.ui;

import de.redsmiletv.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GUI extends JFrame {
    private Controller controller;
    private JPanel field = new JPanel();
    private JButton[][] btnField = new JButton[8][8];
    private JButton whitePlayer = new JButton();
    private JButton blackPlayer = new JButton();
    public GUI() {
        // UI properties
        setTitle("Chess");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("icon.png"));
        resizeIcon(icon);
        setIconImage(icon.getImage());
        Dimension dimension = getToolkit().getScreenSize();
        int xPos = (dimension.width - getWidth()) / 2;
        int yPos = (dimension.height - getHeight()) / 2;
        setLocation(xPos, yPos);
        getContentPane().setBackground(Color.DARK_GRAY);

        // Field panel properties
        field.setSize(488, 488);
        field.setLocation(50, 50);
        field.setBorder(new LineBorder(Color.GRAY, 4));
        field.setBackground(Color.BLACK);
        field.setLayout(null);
        add(field);

        whitePlayer.setSize(200, 50);
        whitePlayer.setLocation(550, getHeight() - (getHeight() - field.getHeight()));
        whitePlayer.setBorder(new LineBorder(Color.GRAY, 4));
        whitePlayer.setBackground(Color.WHITE);
        whitePlayer.setForeground(Color.BLACK);
        whitePlayer.setLayout(null);
        whitePlayer.setText("Become the white player");
        whitePlayer.setFocusable(false);
        add(whitePlayer);

        blackPlayer.setSize(200, 50);
        blackPlayer.setLocation(550, 50);
        blackPlayer.setBorder(new LineBorder(Color.GRAY, 4));
        blackPlayer.setBackground(Color.BLACK);
        blackPlayer.setForeground(Color.WHITE);
        blackPlayer.setLayout(null);
        blackPlayer.setText("Become the black player");
        blackPlayer.setFocusable(false);
        add(blackPlayer);





        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                btnField[j][i] = new JButton();
                btnField[j][i].setSize(60, 60);
                btnField[j][i].setLocation(4 + j * 60, 4 + i * 60);
                btnField[j][i].setBorder(null);
                field.add(btnField[j][i]);

                if ((j + i) % 2 == 0) btnField[j][i].setBackground(new Color(245, 245, 230));
                else btnField[j][i].setBackground(new Color(0, 80, 0));

                btnField[j][i].addActionListener(e -> {
                    JButton btn = (JButton) e.getSource();
                    int x = (btn.getX() - 4) / 60;
                    int y = (btn.getY() - 4) / 60;
                    controller.move(x, y);
                });


            }
        }

        // Action listeners
        whitePlayer.addActionListener(e -> whitePlayer.setVisible(false));
        blackPlayer.addActionListener(e -> blackPlayer.setVisible(false));


        // UI properties
        setLayout(null);
        setResizable(false);
        setVisible(true);

        // Initializing the controller
        controller = new Controller(this);

    }

    public void setPiece(int x, int y, ImageIcon pieceIcon) {
        btnField[x][y].setIcon(resizeIcon(pieceIcon));
    }
    private ImageIcon resizeIcon(ImageIcon pieceIcon) {
        if (pieceIcon == null) return null;
        Image scaledPieceImage = pieceIcon.getImage().getScaledInstance(69, 69, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledPieceImage);
    }
}
