import java.applet.*;
public class KeyHandler {
  Applet parentApplet;
  public KeyHandler(Applet a) {
    parentApplet = a;
  }
  public void handle(int key) {
    if(key==1004) {
      GameThread.player.moveUp();
    }
    else if(key == 1005) {
      GameThread.player.moveDown();
    }
    else if(key == 1006) {
      GameThread.player.moveLeft();
    }
    else if(key == 1007) {
      GameThread.player.moveRight();
    }
    else if(key == 114) {
      GameThread.player.reset();
      GameThread.player.visible = true;
      GameThread.player2.reset();
      if(Coin.coinCount != -1) {
       for(int i = Coin.coinCount; i >= 0; i--) {
         Level.coinArray[i].reset();
       }
     }
      if(Enemy.enemyCount != -1) {
       for(int i = Enemy.enemyCount; i >= 0; i--) {
         Enemy.enemyArray[i].visible = true;
       }
     }
     Key.reset();
     LockedDoor.reset();
  }
    else if(key == 119) { 
      GameThread.player2.moveUp();
    }
    else if(key == 97) {
      GameThread.player2.moveLeft();
    }
    else if(key == 115) {
      GameThread.player2.moveDown();
    }
    else if(key == 100) {
      GameThread.player2.moveRight();
    }
    else if(key == 32) {
      GameThread.player.shootBullet();
    }
    else if(key == 101) {
      GameThread.player2.shootBullet();
    }
    else if(key == 49) {
      handle(114);
      GameThread.player2.visible = false;
    }
    else if(key == 50) {
      handle(114);
      GameThread.player2.visible = true;
    }
    else if(key == 104) {
      HelpScreen.visible = !HelpScreen.visible;
    }
  }
 }