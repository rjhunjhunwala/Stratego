/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stratego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author rohan
 */
public class Piece {
public static class GameFrame extends JFrame{
		private static final long serialVersionUID = 1L;
	public GameFrame(){
		super("Stratego!");
		this.setVisible(true);
		this.add(new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			public void paintComponent(Graphics g){
super.paintComponent(g);
g.setColor(Color.green);
g.fillRect(0,0,640,640);
			}
			@Override
			public Dimension getPreferredSize(){
				return new Dimension(640,640);
			}
		});
	this.setBackground(Color.green);
	this.pack();
	this.setResizable(false);
	}
	}
	private static void goodMove(int x1, int y1, int x2, int y2) {
if(board[x2][y2]==null){
	board[x2][y2]= board[x2][y2];
	board[x2][y2]=null;
}else{
	if(board[x1][y1].isRed==!board[x2][y2].isRed){
		attack(x1,y1,x2,y2);
	}
}
	}
public static void main(String[] args){
	GameFrame frame = new GameFrame();
		for(;;frame.repaint());
	
}
	private static void attack(int x1, int y1, int x2, int y2) {

		Piece Attacker = board[x1][y1];
	Piece Defender = board[x2][y2];
		board[x1][y1]=null;
if(Defender.value.equalsIgnoreCase("F")){
	System.out.println("GAME OVER! "+(Attacker.isRed?"red":"blue")+" wins!");
}
	//dirty hack!
	if("1098765432".contains(Attacker.value)&&"1098765432".contains(Defender.value)){

		if(Integer.parseInt(Attacker.value)>=Integer.parseInt(Defender.value)){
			board[x2][y2]=Attacker;
		}
	}
if(Defender.value.equalsIgnoreCase("B")){
	if(Attacker.value.equals("3")){
		board[x2][y2]=Attacker;
	}
}
if(Attacker.value.equals("S")&&Defender.value.equals("10")){
	board[x2][y2]=Attacker;    
}
	}
	private String value="";
	public boolean discovered = false;
	public final boolean isRed;
	public String getValue(){
	return discovered?value:"?";
}
	public static Piece[][] board = new Piece[10][10];
	static{
		//consider putting in lakes
	}
	public Piece(String inValue,boolean isRed){
		value = inValue;
		this.isRed=isRed;
	}
	private static void move(int x1,int y1,int x2,int y2){
	 if(x1<0||x1>9||x2<0||x2>9||y1<0||y1>9||y1>0||y2>9){
			return;
		}
		int dX=x2-x1;
		int dY = y2-y1;
		if(board[x1][y1].value.equals("2")){
			if(dX==0^dY==0){
			}else{
				return;
			}
		}
		else if(Math.abs(dX)+Math.abs(dY)==1){
		
		}
		else {
			return;
		}
		goodMove(x1,y1,x2,y2);
	}
}
