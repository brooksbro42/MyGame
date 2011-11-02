import java.awt.*;
public class HelpScreen {
  public static boolean visible = false;
  public HelpScreen() {
  
  }
  public static void draw(Graphics g) {
    if(visible) {
      g.setColor(Color.black);
      g.fillRect(0,0,GameThread.width,GameThread.height);
      g.setColor(Color.white);
      g.drawString("Welcome to Luke's Game!", 20,20);
      g.drawString("Player 1: Arrow Keys to move, space to shoot",20,35);
      g.drawString("Player 2: WASD to move, e to shoot",20,50);
      g.drawString("Press R to reset coins and players",20,65);
      g.drawString("Press 1 or 2 to change amount of players",20,80);
      g.drawString("Press h to view or close the help screen",20,95);
      g.drawString("Made by Luke Nelson",20,280);
    }
  }
}