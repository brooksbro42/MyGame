import java.awt.*;
public class Enemy {
  Color color;
  protected int x,y;
  boolean visible = true;
  static Enemy[] enemyArray = new Enemy[10];
  static int enemyCount = -1;
  boolean flipFlop = true; //temp
  public int counterlol; //temp
  public Enemy(Color c,int xtemp,int ytemp) {
    color = c;
    x = xtemp;
    y = ytemp;
    enemyCount++;
  }
  public static boolean checkEnemyHit(Player p) {
    if(enemyCount != -1) {
      for(int i = enemyCount;i>=0;i--) {
        if(enemyArray[i].visible == true) {
          if(p.x == enemyArray[i].x && p.y == enemyArray[i].y ||
       p.x + 10 == enemyArray[i].x && p.y == enemyArray[i].y ||
       p.x == enemyArray[i].x && p.y + 10== enemyArray[i].y ||
       p.x - 10 == enemyArray[i].x && p.y == enemyArray[i].y ||
       p.x == enemyArray[i].x && p.y - 10 == enemyArray[i].y||
       p.x-10 == enemyArray[i].x && p.y-10 == enemyArray[i].y ||
       p.x+10 == enemyArray[i].x && p.y+10 == enemyArray[i].y ||
       p.x+10 == enemyArray[i].x && p.y-10 == enemyArray[i].y ||
       p.x-10 == enemyArray[i].x && p.y+10 == enemyArray[i].y) {
            p.visible = false;
            return true;
          }
        }
      }
    }
    return false;
   }
   public void draw(Graphics g) {
    if(visible) {
      g.setColor(color);
      g.fillOval(x,y,20,20);
      if(counterlol % 5 == 0) {
        if(flipFlop == true) { //tempstart
          x = x-10;
          if(x==180) {flipFlop = !flipFlop;}
        }
        else {
          x = x+10;
          if(x == 220) {flipFlop = !flipFlop;}
        } 
      } //tempend
    }
    counterlol++; //temp
  }
   public static void drawEnemies(Graphics g) {
     if(enemyCount != -1) {
       for(int i = enemyCount; i >= 0; i--) {
         enemyArray[i].draw(g);
       }
     }
  }
}