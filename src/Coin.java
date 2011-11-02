import java.awt.Graphics;
import java.awt.*;
public class Coin {
  static int coinCount = -1;
  public int x,y,ystart,xstart;
  public Coin(int xtemp,int ytemp) {
    x = xtemp;
    ystart = ytemp;
    xstart = xtemp;
    y = ytemp;
    coinCount++;
  }
  public void draw(Graphics g) {
    g.setColor(Color.yellow);
    g.fillOval(x,y,10,10);
  }
  public static void drawCoins(Graphics g) {
     if(coinCount != -1) {
       for(int i = coinCount; i >= 0; i--) {
         Level.coinArray[i].draw(g);
       }
     }
  }
  public static boolean checkPlayerHit(Player p) {
    for(int i = coinCount; i >= 0; i--) {
      if(Level.coinArray[i].x == p.x && Level.coinArray[i].y ==p.y ||
        Level.coinArray[i].x == p.x+10 && Level.coinArray[i].y ==p.y ||
        Level.coinArray[i].x == p.x && Level.coinArray[i].y ==p.y+10 ||
        Level.coinArray[i].x == p.x+10 && Level.coinArray[i].y ==p.y+10) {
        Level.coinArray[i].x = 500;
        Level.coinArray[i].y = 500;
        return true;
      }
    }
    return false;
  }
  public void reset() {
    x = xstart;
    y = ystart;
  }
}