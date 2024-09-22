import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class snake extends JPanel  implements KeyListener,ActionListener {
    int p =1;
    Timer tn = new Timer(12 ,this);
    int z= 350,v = 300,o = 10;
    int x = 200;
    int y = 300,h = 300;
    int velx = 0,vely = 0,velw = 0,velh = 0;
    int w = 250;
    int  l ;
   
    boolean m;
    int d = 50;
    public  snake()
    {
        tn.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        

        
      }
      public static void main(String[]arges)
      {

          JFrame  jf = new JFrame("Snake");
          int  l;
          
          
          snake s = new snake();
          jf.setVisible(true);
          jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          jf.add(s);
          jf.setSize(600,600);
          
      }
    
      public void keyPressed(KeyEvent e){
          int r  = e.getKeyCode();
          
          if(r==KeyEvent.VK_LEFT)
          {
              velx  = -p;
              vely = 0;
              velw  = -p;
              velh = 0;
              x = w;
              x +=d;
              y = h;
              
          }
          if(r== KeyEvent.VK_RIGHT)
          {
              velx  = p;
              vely = 0;
              velw  = p;
              velh = 0;
              y = h;
              x = w;
              x -= d;
              
          }
          if(r == KeyEvent.VK_UP)
          {
              velx = 0;
              vely  = -p;
              velw = 0;
              velh  = -p;
              x = w;
              y = h;
              y +=d;
              
              
          }
          if(r==KeyEvent.VK_DOWN)
          {
            velx = 0;
            vely  = p;
            velw = 0;
            velh  = p;
            x = w;
            y = h;
            y -=d;
            
          }
          
      }     
      public void actionPerformed(ActionEvent e){
          
          if(x>=500 || w>=500) 

          {
              System.out.println("End");
              System.out.println("Score  "+l);
              setVisible(false);
               System.exit(0);
                 }
          if(y >= 470|| h>=470)
          {
              setVisible(false);
              System.out.println("End");
              System.out.println("Score  "+l);
              System.exit(0);
               }
          if(x <= 100|| w<=100)

          {
              setVisible(false);
              System.out.println("End");
              System.out.println("Score  "+l);
              System.exit(0);
          }
          if(y<=100|| h<= 100){
              System.out.println("End");
              System.out.println("Score  "+l);
              setVisible(false);
              System.exit(0);
              }
           int max = 400;
           int min = 190;
           int u = 0;
              if(w >= z &&w<= z+10 &&h >= v &&   h<=v+10)
              {
                  Random r = new Random();
                  z = r.nextInt((max-min)+1)+min;
                  v = r.nextInt((max-min)+1)+min;
                  repaint();
                  
                  u =l;
                  o = 10;
                  l=l+1;

              }
              if(u== 10||u==20 ||u==30||u==40||u == 50|| u==100)
              {
                 p +=1;
               }
               
          x = velx+x;
          y = vely+y;
          w = velw+w;
          h = velh+h;
          repaint();
          
      }
      public void keyReleased(KeyEvent e){}
      public void keyTyped(KeyEvent e){}

       public void paintComponent(Graphics g)
     {
         super.paintComponent(g);
         this.setBackground(new Color(100,100,250));
         g.setColor(new Color(100,230,100));
         g.fillRect(0,0,600,100);
         g.fillRect(500,100,100,500);
         g.fillRect(0,470,500,100);
         g.fillRect(0,0,100,500);
         g.setColor(Color.BLACK);
         g.drawLine(x,y,w,h);
         g.setColor(Color.RED);
         g.fillOval(z,v,o,o);g.setColor(Color.BLACK);
         g.drawString("Score   "+l,260,60);
         }

}

