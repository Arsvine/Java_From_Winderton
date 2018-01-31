package com.arsen.app.core;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends Canvas {

    private BufferStrategy bs;
    private Graphics g;
    private JFrame fame;

    public Window(String name, int width, int height) {
        set PreferredSize (new Dimension(width, height));
        init(name);
        render();
    }

    private void init(String name) {

        frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private void render() {

        if (bs == null)
            createBufferStrategy(3);
        bs = getBufferStrategy();

        g = bs.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        onRender(g);
        g.dispose();
        bs.show();

        try {
            Thread.sleep(3);
        }catch (InterruptedException e) {
        }

        EventQueue.invokeLater(() -> render());

    }

    private void onRender(Graphics g) {

    }

}
