import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
public class Level {
  public Level() {}
  public static WallBlock[] wallArray = new WallBlock[120];
  static Coin[] coinArray = new Coin[10];
  static LockedDoor[] doorArray = new LockedDoor[10];
  static Key[] keyArray = new Key[10];
  static StringBuffer[] levelDat = new StringBuffer[15];
  public static void init(int lev) throws IOException {
    getLevelFile();
  }
  static public void getLevelFile() throws IOException {
	  for(int cr = 0;cr <= 14;cr++) {
		  levelDat[cr] = new StringBuffer();
	  }
	  FileReader in = null;
	  JFileChooser fc = new JFileChooser();
	  int returnVal = fc.showOpenDialog(fc);
	  if(returnVal == JFileChooser.APPROVE_OPTION) {
	     File f = fc.getSelectedFile();
	     try {
	    	in = new FileReader(f);
	    	int c = 0;
	    	int endBlock = 0;
	    	byte d = 00000000;
	    	do {
	    		d = new Integer(in.read()).byteValue();
	    		endBlock = new Integer(d).intValue();
	    		if(endBlock == 10) {
	    			c++;
	    		}
	    	    if(endBlock != 10) {levelDat[c].append(new Byte(d));}
	    		
	     } while(endBlock != -1);}
	     finally {
	    	if(in != null) {in.close(); readLevel();}
	     }
	  }
	  else {
		  keyArray[0] = new Key(0,80,Color.green);
	      coinArray[0] = new Coin(100,0);
	      coinArray[1] = new Coin(110,0);
	      coinArray[2] = new Coin(100,10);
	      coinArray[3] = new Coin(110,10);
	      doorArray[0] = new LockedDoor(120,60,Color.green);
	      wallArray[0] = new WallBlock(20,0);
	      wallArray[1] = new WallBlock(40,0);
	      wallArray[2] = new WallBlock(60,0);
	      wallArray[3] = new WallBlock(60,20);
	      wallArray[4] = new WallBlock(60,40);
	      wallArray[5] = new WallBlock(60,60);
	      wallArray[6] = new WallBlock(80,60);
	      wallArray[7] = new WallBlock(100,60);
	      wallArray[8] = new WallBlock(140,60);
	      wallArray[9] = new WallBlock(20,40);
	      wallArray[10] = new WallBlock(140,40);
	      wallArray[11] = new WallBlock(140,20);
	      wallArray[12] = new WallBlock(140,0);
	      wallArray[13] = new WallBlock(0,60);
	      wallArray[14] = new WallBlock(20,60);
	      wallArray[15] = new WallBlock(40,100);
	      wallArray[16] = new WallBlock(60,100);
	      wallArray[17] = new WallBlock(20,100);
	      wallArray[18] = new WallBlock(20,80);
	  }
  }
  static public void readLevel() throws IOException{
	  int column = 0;
	  int row = 1;
	  int sub1 = 0;
	  int sub2 = 2;
	  while(column <= 14) {
		  sub1 = 0;
		  sub2 = 2;
		while(row <=20) {
		  System.out.println(levelDat[1].substring(sub1,sub2));
		  if(getChar(Integer.parseInt(levelDat[column].substring(sub1, sub2))) == 'W') {
			  wallArray[WallBlock.wallCount + 1] = new WallBlock((row-1)*20,column*20);
		  }
		  else if(getChar(Integer.parseInt(levelDat[column].substring(sub1, sub2))) == 'D') {
			  doorArray[LockedDoor.doorCount + 1] = new LockedDoor((row-1)*20,column*20,Color.green);
		  }
		  else if(getChar(Integer.parseInt(levelDat[column].substring(sub1, sub2))) == 'K') {
			  keyArray[Key.keyCount + 1] = new Key((row-1)*20,column*20,Color.green);  
		  }
		  row++;
		  sub1 = sub1 + 2;
		  sub2 = sub2 + 2;
		 }
		column++;
		row = 1;
		}
	  }
  public static char getChar(int a) {
	  if(a == 87) {
		return 'W';  
	  }
	  else if(a == 66) {
		return 'B';  
	  }
	  else if(a == 68) {
		  return 'D';
	  }
	  else if(a == 75) {
		return 'K';  
	  }
	  else {return '0';}
    }
   }
