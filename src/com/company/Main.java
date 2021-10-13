package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Main {

    public static void main(String[] args) {
    JFrame frame = new JFrame("Hello Java3");
    frame.add(new HelloComponent3("Hello, Java!"));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,300);
    frame.setVisible(true);
    }
}
class HelloComponent3 extends JComponent implements MouseMotionListener, ActionListener {
    String theMessage;
    int messageX = 125, messageY = 95;  // Координаты сообщения
    JButton theButton, aButton;
    int colorIndex;                     // текущий указатель в объекте someColors
    static Color[] someColors = {
            Color.black, Color.red, Color.green, Color.blue, Color.magenta
    };

    public HelloComponent3(String message){
    theMessage = message;
    theButton = new JButton("Change Color");
    aButton   = new JButton("Set Color");
    setLayout( new FlowLayout());
    add(theButton);
    add(aButton);
    theButton.addActionListener(this);
    aButton.addActionListener(this);
    addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g){
        g.drawString(theMessage, messageX, messageY);
    }

    public void mouseDragged(MouseEvent e){
        messageX = e.getX();
        messageY = e.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent e){}

    public void actionPerformed(ActionEvent e){
        // Кто-то нажимал нашу кнопку?
        if(e.getSource() == theButton){
            changeColor();
        }
        else{
            setForeground(Color.CYAN);
            repaint();
        }
    }

    synchronized private void changeColor(){
        //Изменить индекс на другой цвет, неудобно.
        if(++colorIndex >= someColors.length)
            colorIndex = 0;
            setForeground(currentColor()); // Использовать новый цвет

    }

    private Color currentColor(){
        return someColors[colorIndex];
    }
}
