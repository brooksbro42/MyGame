//Copyright 2011 Luke Nelson
//This software is distributed under the terms of the GNU General Public License
import java.awt.*;
public class Player {
 private final int WIDTH = 20;
 private final int HEIGHT = 20;
 public int x, y, startX, startY, lastMovement,coins,greenKeys,orangeKeys;
 public boolean visible = false;
 private Bullet bullet1;
 Color color;
 public Player(int xtemp, int ytemp, Color c, boolean vis) {
   x = xtemp;
   y = ytemp;
   startX = xtemp;
   startY = ytemp;
   visible = vis;
   color = c;
   bullet1 = new Bullet(500,500,4);
 }
 public void draw(Graphics g) {
   Key.checkPlayerHit(this);
   if(visible) {
     g.setColor(this.color);
     g.fillRect(x,y,WIDTH,HEIGHT);
   }
   bullet1.draw(g);
   if(Coin.checkPlayerHit(this)) {
     this.coins++;
   }
   if(Enemy.checkEnemyHit(this) == true) {
     this.visible = false;
   }
   if(greenKeys > 0) {
     g.setColor(Color.green);
     g.fillRect(x+7,y+3,10,10);
   }
 }
 public void moveUp() {
   if(WallBlock.hitWall(x,y-10) == false && visible) {
     int xt, yt;
     xt = x;
     yt = y;
     y = y - 10;
     if(y < 0) {
       y = 0;
     }
     if(checkPlayerHit() == true || Enemy.checkEnemyHit(this) == true || LockedDoor.playerHitDoor(x,y,this) == true) {
       x = xt;
       y = yt;
     }
     lastMovement = 1;
   }
 }
 public void moveDown() {
   if(WallBlock.hitWall(x,y+10) == false && visible) {
     int xt, yt;
     xt = x;
     yt = y;
     y = y + 10;
     if(y > 280) {
       y = 280;
     }
     if(checkPlayerHit() == true || Enemy.checkEnemyHit(this) == true|| LockedDoor.playerHitDoor(x,y,this)) {
       x = xt;
       y = yt;
     }
     lastMovement = 2;
   }
 }
 public void moveLeft() {
   if(WallBlock.hitWall(x-10,y) == false && visible) {
     int xt, yt;
     xt = x;
     yt = y;
     x = x - 10;
     if(x < 0) {
       x = 0;
     }
     if(checkPlayerHit() == true || Enemy.checkEnemyHit(this) == true|| LockedDoor.playerHitDoor(x,y,this)) {
       x = xt;
       y = yt;
     }
     lastMovement = 3;
   }
 }
 public void moveRight() {
   if(WallBlock.hitWall(x+10,y) == false && visible) {
     int xt, yt;
     xt = x;
     yt = y;
     x = x + 10;
     if(x > 380) {
       x = 380;
     }
     if(checkPlayerHit() == true || Enemy.checkEnemyHit(this) == true || LockedDoor.playerHitDoor(x,y,this) == true) {
       x = xt;
       y = yt;
     }
     lastMovement = 4;
   }
 }
 public void reset() {
   x = startX;
   y = startY;
   coins = 0;
   greenKeys = 0;
 }
 public void shootBullet() {
   if(visible && bullet1.bulletShot == false) {
     bullet1.visible = true;
     bullet1.bulletShot = true;
     bullet1.x = this.x + 6;
     bullet1.y = this.y - 10;
     bullet1.counter = 0;
   }
 }
 public boolean checkPlayerHit() {
   if(GameThread.player.visible == true && GameThread.player2.visible == true) {
     if(GameThread.player.x == GameThread.player2.x && GameThread.player.y == GameThread.player2.y ||
       GameThread.player.x + 10 == GameThread.player2.x && GameThread.player.y == GameThread.player2.y ||
       GameThread.player.x == GameThread.player2.x && GameThread.player.y + 10== GameThread.player2.y ||
       GameThread.player.x - 10 == GameThread.player2.x && GameThread.player.y == GameThread.player2.y ||
       GameThread.player.x == GameThread.player2.x && GameThread.player.y - 10 == GameThread.player2.y||
       GameThread.player.x-10 == GameThread.player2.x && GameThread.player.y-10 == GameThread.player2.y ||
       GameThread.player.x+10 == GameThread.player2.x && GameThread.player.y+10 == GameThread.player2.y ||
       GameThread.player.x+10 == GameThread.player2.x && GameThread.player.y-10 == GameThread.player2.y ||
        GameThread.player.x-10 == GameThread.player2.x && GameThread.player.y+10 == GameThread.player2.y) {
       return true;
     }
   }
   return false;
 }
 public void giveKey(Color col) {
   if(col == Color.green) {
     greenKeys++;
   }
   if(col == Color.orange) {
     orangeKeys++;
   }
 }
 public void takeKey(Color col) {
   if(col == Color.green) {
     greenKeys--;
   }
   else if(col == Color.orange) {
     orangeKeys--;
   }
 }
}