import java.awt.*;
public class WallBlock {
  static int wallCount = -1;
  int x,y;
  public WallBlock(int xtemp,int ytemp) {
    x = xtemp;
    y = ytemp;
    wallCount++;
  }
  public static void drawWalls(Graphics g) {
     if(wallCount != -1) {
       for(int i = wallCount; i >= 0; i--) {
         Level.wallArray[i].draw(g);
       }
     }
  }
  public void draw(Graphics g) {
    g.setColor(Color.blue);
    g.fillRect(x,y,20,20);
  }
  public static boolean hitWall(int playerx, int playery) {
    if(wallCount != -1) {
       for(int i = wallCount; i >= 0; i--) {
         if(playerx == Level.wallArray[i].x && playery == Level.wallArray[i].y ||
       playerx + 10 == Level.wallArray[i].x && playery == Level.wallArray[i].y ||
       playerx == Level.wallArray[i].x && playery + 10== Level.wallArray[i].y ||
       playerx - 10 == Level.wallArray[i].x && playery == Level.wallArray[i].y ||
       playerx == Level.wallArray[i].x && playery - 10 == Level.wallArray[i].y||
       playerx-10 == Level.wallArray[i].x && playery-10 == Level.wallArray[i].y ||
       playerx+10 == Level.wallArray[i].x && playery+10 == Level.wallArray[i].y ||
       playerx+10 == Level.wallArray[i].x && playery-10 == Level.wallArray[i].y ||
       playerx-10 == Level.wallArray[i].x && playery+10 == Level.wallArray[i].y) {
           return true;
         }
       }
     }
    return false;
  }
}