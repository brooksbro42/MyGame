//Copyright 2011 Luke Nelson
//This software is distributed under the terms of the GNU General Public License
import java.awt.*;
public class LockedDoor {
  public Color doorColor;
  int x,y;
  boolean visible = true;
  public static int doorCount = -1;
  public LockedDoor(int xtemp, int ytemp, Color colortemp) {
    x = xtemp;
    y = ytemp;
    doorColor = colortemp;
    doorCount++;
  }
  public void draw(Graphics g) {
    if(visible) {
      g.setColor(Color.pink);
      g.fillRect(x,y,20,20);
      g.setColor(doorColor);
      g.fillRect(x+5,y+5,10,10);
    }
  }
  public static void drawDoors(Graphics g) {
     if(doorCount != -1) {
       for(int i = doorCount; i >= 0; i--) {
         Level.doorArray[i].draw(g);
       }
     }
  }
  public static boolean playerHitDoor(int playerx, int playery, Player p) {
    if(doorCount != -1) {
       for(int i = doorCount; i >= 0; i--) {
         if(playerx == Level.doorArray[i].x && playery == Level.doorArray[i].y ||
       playerx + 10 == Level.doorArray[i].x && playery == Level.doorArray[i].y ||
       playerx == Level.doorArray[i].x && playery + 10== Level.doorArray[i].y ||
       playerx - 10 == Level.doorArray[i].x && playery == Level.doorArray[i].y ||
       playerx == Level.doorArray[i].x && playery - 10 == Level.doorArray[i].y||
       playerx-10 == Level.doorArray[i].x && playery-10 == Level.doorArray[i].y ||
       playerx+10 == Level.doorArray[i].x && playery+10 == Level.doorArray[i].y ||
       playerx+10 == Level.doorArray[i].x && playery-10 == Level.doorArray[i].y ||
       playerx-10 == Level.doorArray[i].x && playery+10 == Level.doorArray[i].y) {
           if(Level.doorArray[i].visible == true) {
             if(Level.doorArray[i].doorColor == Color.green && p.greenKeys > 0) {
               p.greenKeys--;
               Level.doorArray[i].visible = false;
             }
             else if(Level.doorArray[i].doorColor == Color.orange && p.orangeKeys > 0) {
               p.orangeKeys--;
               Level.doorArray[i].visible = false;
             }
             return true;
           }
         }
       }
     }
    return false;
  }
  public static void reset() {
    if(doorCount != -1) {
       for(int i = doorCount; i >= 0; i--) {
         Level.doorArray[i].visible = true;
       }
     }
  }
}