import java.applet.*;
import java.awt.*;
import java.io.IOException;
public class GameThread extends Applet implements Runnable {
  
	private static final long serialVersionUID = 1L;
Thread t;
  Image offscreenImage;
  Graphics offscr;
  public static int width, height;
  static Player player, player2;
  KeyHandler keyhandler;
  public void init() {
    t = new Thread(this);
    setSize(400,300);
    width = getSize().width;
    height = getSize().height;
    offscreenImage = createImage(width,height);
    offscr = offscreenImage.getGraphics();
    player = new Player(0,0,Color.cyan,true);
    player2 = new Player(0, 40,Color.red,false);
    try {
		Level.init(1);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
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
    offscr.drawString("v0.4.0",2,11);
    Enemy.drawEnemies(offscr);
    HelpScreen.draw(offscr);
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