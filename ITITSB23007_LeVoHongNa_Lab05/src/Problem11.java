import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

class KochCurve extends Frame {
    Graphics2D graph;

    public void paint(Graphics g)
    {
        graph = (Graphics2D) g;
        drawKochCurves(1,500,(int)(400 + 0.5*Math.sqrt(30000)),  400, (int)(400 - 0.5*Math.sqrt(30000)));
        drawKochCurves(1,300, (int)(400 + 0.5*Math.sqrt(30000)), 500,  (int)(400 + 0.5*Math.sqrt(30000)));
        drawKochCurves(1, 400, (int)(400 - 0.5*Math.sqrt(30000)), 300, (int)(400 + 0.5*Math.sqrt(30000)));
    }

    public void drawKochCurves(int level, int x1,int y1,int x5, int y5){
        int x2,x3,x4;
        int y2,y3,y4;
        int deltaX,deltaY;

        deltaX = x5-x1;
        deltaY = y5-y1;

        x2 = x1+deltaX/3;
        y2 = y1+deltaY/3;

        x3 = (int)((0.5 * (x1 + x5)) + Math.sqrt(3) * (y1-y5) /6);
        y3 = (int)(0.5 * (y1 + y5) + Math.sqrt(3) * (x5-x1) / 6);

        x4 = x1 + 2 * deltaX/3;
        y4 = y1 + 2 * deltaY/3;

        if(level == 1){
            graph.drawLine(x1,y1,x2,y2);
            graph.drawLine(x2,y2,x3,y3);
            graph.drawLine(x3,y3,x4,y4);
            graph.drawLine(x4,y4,x5,y5);
        }
        else if ( level >= 1){
            level --;
            drawKochCurves(level, x1, y1, x5, y5);
        }
        else{
            graph.drawLine(x1,y1,x5,y5);
        }
    }

    public static void main(String args[]){
        Frame frame = new KochCurve();
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing( WindowEvent we){
                System.exit(0);
            }
        });
        frame.setSize(800,800);
        frame.setVisible(true);
    }
}