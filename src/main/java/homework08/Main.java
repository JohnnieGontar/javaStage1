package homework08;

import java.awt.*;

public class Main {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new MyFrame().setVisible(true);
            }
        });
    }

}