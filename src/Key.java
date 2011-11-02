import java.awt.*;
public class Key {
  public int x,y,startx,starty;;
  public static int keyCount = -1;
  public Color color;
  public Key(int xtemp, int ytemp, Color colortemp) {
    x = xtemp;
    y = ytemp;
    startx = xtemp;
    starty = ytemp;
    color = colortemp;
    keyCount++;
  }
  public void draw(Graphics g) {
    g.setColor(color);
    g.fillRect(x,y,10,10);
  }
  public static void drawKeys(Graphics g) {
     if(keyCount != -1) {
       for(int i = keyCount; i >= 0; i--) {
         Level.keyArray[i].draw(g);
       }
     }
  }
  static public void checkPlayerHit(Player p) {
    for(int i = keyCount; i >= 0; i--) {
      if(Level.keyArray[i].x == p.x && Level.keyArray[i].y ==p.y ||
        Level.keyArray[i].x == p.x+10 && Level.keyArray[i].y ==p.y ||
        Level.keyArray[i].x == p.x && Level.keyArray[i].y ==p.y+10 ||
        Level.keyArray[i].x == p.x+10 && Level.keyArray[i].y ==p.y+10) {
        Level.keyArray[i].x = 500;
        Level.keyArray[i].y = 500;
        p.giveKey(Level.keyArray[i].color);
      }
    }
  }
  public static void reset() {
    if(keyCount != -1) {
       for(int i = keyCount; i >= 0; i--) {
         Level.keyArray[i].x = Level.keyArray[i].startx;
         Level.keyArray[i].y = Level.keyArray[i].starty;
       }
     }
  }
}