//Copyright 2011 Luke Nelson
//This software is distributed under the terms of the GNU General Public License
import java.applet.*;
import java.awt.*;
public class GameThread extends Applet implements Runnable {
private static final long serialVersionUID = 1L;
Thread t;
  Image offscreenImage;
  Graphics offscr;
  public static int width, height;
  static Player player, player2;
  KeyHandler keyhandler;
  static boolean wait = true;
  public void init() {
    t = new Thread(this);
    setSize(400,300);
    width = getSize().width;
    height = getSize().height;
    offscreenImage = createImage(width,height);
    offscr = offscreenImage.getGraphics();
    player = new Player(0,0,Color.cyan,true);
    player2 = new Player(0, 40,Color.red,false);
    //Enemy.enemyArray[0] = new Enemy(Color.green,200,200);
    keyhandler = new KeyHandler(this);
    t.start();
  }
  public void run() {
    while(true) {
      repaint();
      try {
        Thread.sleep(1000/30);
      }
      catch (InterruptedException e) {
        ;
      }
     }
    }
  public void paint(Graphics g) {
    offscr.setColor(Color.black);
    offscr.fillRect(0,0,width,height);
    player.draw(offscr);
    player2.draw(offscr);
    Coin.drawCoins(offscr);
    offscr.setColor(Color.white);
    offscr.drawString("P1 Coins: "+player.coins, 300,250);
    if(player2.visible == true) {
      offscr.drawString("P2 Coins: "+player2.coins, 300,270);
    }
    Key.drawKeys(offscr);
    LockedDoor.drawDoors(offscr);
    WallBlock.drawWalls(offscr);
    offscr.setColor(Color.yellow);
    offscr.drawString("v0.4.2",2,11);
    Enemy.drawEnemies(offscr);
    HelpScreen.draw(offscr);
    if(wait) {
    	offscr.setColor(Color.black);
    	offscr.fillRect(0,0,width,height);
    	offscr.setColor(Color.white);
    	offscr.drawString("Press L to load level or D for default", 40, 40);
    }
    g.drawImage(offscreenImage,0,0,this);
  }
  public void update(Graphics g) {
    paint(g);
  }
  public boolean keyDown(Event e, int key) {
    keyhandler.handle(key);
    return true;
  }
}