import java.awt.*;
public class Bullet {
  public int startX, startY,x,y,direction,counter;
  public boolean visible, bulletShot;
  public Bullet(int xtemp,int ytemp,int dir) {
    startX = xtemp;
    x = xtemp;
    startY = ytemp;
    y = ytemp;
    direction = dir;
    visible = true;
  }
  public void draw(Graphics g) {
    if(visible) {
      checkBulletHit(this);
      
      if(x!=500){checkBulletWall(this);}
      if(counter == 0) {
        g.setColor(Color.orange);
        g.fillRect(startX,startY,8,16);
      }
      else if(counter < 500){
        y = y - 5;
        g.setColor(Color.orange);
        g.fillRect(x,y,8,16);
      }
      if(this.y < 0) {
        bulletShot = false;
      }
      
      counter++;
    }
  }
  public void checkBulletHit(Bullet b) {
    if(Enemy.enemyCount != -1) {
       for(int i = Enemy.enemyCount; i >= 0; i--) {
         if(b.x == Enemy.enemyArray[i].x+6 || b.x == Enemy.enemyArray[i].x+16 || b.x == Enemy.enemyArray[i].x-4) {
           if(b.y == Enemy.enemyArray[i].y+10 || b.y == Enemy.enemyArray[i].y+5) {
             if(Enemy.enemyArray[i].visible == true) {
               Enemy.enemyArray[i].visible = false;
               b.visible = false;
               b.bulletShot = false;
             }
           }
         }
       }
     }
  }
  public void checkBulletWall(Bullet b) {
    if(WallBlock.wallCount != -1) {
       for(int i = WallBlock.wallCount; i >= 0; i--) {
         if(b.x == Level.wallArray[i].x+6 || b.x == Level.wallArray[i].x+16 || b.x == Level.wallArray[i].x-4) {
           if(b.y == Level.wallArray[i].y+10 || b.y == Level.wallArray[i].y+5) {
             b.visible = false;
             b.bulletShot = false;
           }
         }
       }
     }
  }
}