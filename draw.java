import java.awt. *;
import java.math.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;


public class draw extends JFrame implements MouseListener{		
	public static int x = -1000;
	public static int y = -1000;
	public static int row = 0;
	public static int col = 0;


	// DEFINING COLORS USING HEX

	private final Color BROWN = new Color(0xcdb79e); 

	public draw () { 
		init ();
	}

	public void init () {

		// SETS BACKGROUND SIZE
		setSize(590,650);
		// SETS BACKGROUND COLOR
		setBackground(BROWN);
		repaint ();

	}


	public void paint (Graphics g) {
		if(board.turn == 0) {
			g.setColor(Color.black);
			g.drawRect(80, 150, 430, 430);
			g.drawLine(223, 150, 223, 580);
			g.drawLine(366, 150, 366, 580);
			g.drawLine(80, 270, 80, 580);
			g.drawLine(80, 290, 510, 290);
			g.drawLine(80, 435, 510, 435);
			g.setColor(Color.BLUE);
			g.drawString("Welcome to Tic-Tac-Toe!", 220, 50);
			g.drawString("This is a two player game mode, start by selecting a square!", 115, 75);
			g.drawString("Games Won:", 260, 100);
			g.drawString("Player 1   " + board.score1 + " -- " + board.score2 + "   Player 2", 214, 125);
			button();

		}
		if(board.turn%2 == 0 && board.GameOver == false) {
			g.setColor(Color.black);
			g.fillOval(x+15,  y+15,  110,  110);
			g.setColor(BROWN);
			g.fillOval(x+25, y+25, 90, 90); 
		} 
		if(board.turn%2 == 1 && board.GameOver == false) {
			g.setColor(Color.black);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(10));
			g.drawLine(x+30, y+30, x+113, y+113);
			g.drawLine(x+113,y+30, x+30, y+113);
		}

		if(board.GameOver == true) {
			g.setColor(BROWN);
			g.fillRect(0, 0, 590, 650);
			g.setColor(Color.black);
			g.drawString("Congratulations!", 280, 200);
			g.drawString("Player " + board.player + " Has Won!", 280, 300);
			g.drawString("Press anywhere to play again.", 280, 350);
			board.GameOver = false;
			board.Restart();
		}
		if(board.GameTie == true) {
			g.setColor(BROWN);
			g.fillRect(0, 0, 590, 650);
			g.setColor(Color.black);
			g.drawString("Better Luck Next Time!", 280, 200);
			g.drawString("Tie Game!", 280, 300);
			g.drawString("Press anywhere to play again.", 280, 350);
			board.GameOver = false;
			board.GameTie = false;
			board.Restart();
		}

		if(board.test == true && board.turn ==0) {
			g.setColor(BROWN);
			g.fillRect(0, 0, 590, 650);
			g.setColor(Color.black);
			g.drawRect(80, 150, 430, 430);
			g.drawLine(223, 150, 223, 580);
			g.drawLine(366, 150, 366, 580);
			g.drawLine(80, 270, 80, 580);
			g.drawLine(80, 290, 510, 290);
			g.drawLine(80, 435, 510, 435);
			g.setColor(Color.BLUE);
			g.drawString("Welcome to Tic-Tac-Toe!", 220, 50);
			g.drawString("This is a two player game mode, start by selecting a square!", 115, 75);
			g.drawString("Games Won:", 260, 100);
			g.drawString("Player 1   " + board.score1 + " -- " + board.score2 + "   Player 2", 214, 125);
			button();
		}

	}

	public void button () {
		Label l;  
		addMouseListener(this);
		l =new Label();

		//		Icon xIcon = new ImageIcon("/Users/MARIUS/Desktop/TICTACTOE.PNG");
		//		Icon yIcon = new ImageIcon("/Users/MARIUS/Desktop/TICTACTOEO.PNG");
		//		Icon nothing = new ImageIcon("/Users/MARIUS/Desktop/TICTACTOEN.PNG");


		//		JButton b1 = new JButton("", nothing);
		//		b1.setBounds(80, 127, 143, 143);
		//		add(b1);
		//		b1.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent a) {
		//				board.xoButton();
		//				x = 0;
		//				y = 0;
		//			}
		//		});

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		col = (e.getX()-80)/143;
		row = (e.getY()-150)/143;
		//System.out.println(row + " " + col);
		if(board.GameOver == false) {
			board.xoButton();
			repaint();
			board.checkGame();
		}

		if(board.GameOver == true) {
			board.Restart();
			repaint();
			if(board.turn == 0) {
				repaint();
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}



}























//JButton b2 = new JButton("", nothing);
//b2.setBounds(223, 127, 143, 143);
//add(b2);
//b2.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent b) {
//		board.xoButton();
//		x = 0;
//		y = 1;
//	}
//});
//
//JButton b3 = new JButton("", nothing);
//b3.setBounds(366, 127, 143, 143);
//add(b3);
//b3.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent c) {
//		board.xoButton();
//		x = 0;
//		y = 2;
//	}
//});
//
//JButton b4 = new JButton("", nothing);
//b4.setBounds(80, 270, 143, 143);
//add(b4);
//b4.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent d) {
//		board.xoButton();
//		x = 1;
//		y = 0;
//
//	}
//});
//
//JButton b5 = new JButton("", nothing);
//b5.setBounds(223, 270, 143, 143);
//add(b5);
//b5.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent e) {
//		board.xoButton();
//		x = 1;
//		y = 1;
//	}
//});
//
//
//JButton b6 = new JButton("", nothing);
//b6.setBounds(366, 270, 143, 143);
//add(b6);
//b6.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent f) {
//		board.xoButton();
//		x = 1;
//		y = 2;
//	}
//});
//
//JButton b7 = new JButton("", nothing);
//b7.setBounds(80, 413, 143, 143);
//add(b7);
//b7.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent g) {
//		board.xoButton();
//		x = 2;
//		y = 0;
//	}
//});
//
//JButton b8 = new JButton("", nothing);
//b8.setBounds(223, 413, 143, 143);
//add(b8);
//b8.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent h) {
//		board.xoButton();
//		x = 2;
//		y = 1;
//	}
//});
//
//JButton b9 = new JButton("", nothing);
//b9.setBounds(366, 413, 143, 143);
//add(b9);
//b9.addActionListener(new ActionListener() {
//	public void actionPerformed(ActionEvent i) {
//		board.xoButton();
//		x = 2;
//		y = 2;
//	}
//});


//		public static void icon() {
//			if(board.start == true) {
//				for(int i = 0; i < 9; i++) {
//					if(board.turn%2 == 0) {
//						Icon z = new ImageIcon("/Users/MARIUS/Desktop/TICTACTOE.PNG");
//					}
//					else if(board.turn%2 == 1) {
//						Icon z = new ImageIcon("/Users/MARIUS/Desktop/TICTACTOEO.PNG");
//					}
//				}
//			}
//			
//		}


//	public void button1 () {
//		Icon nothing = new ImageIcon("/Users/MARIUS/Desktop/TICTACTOE.PNG");
//		Icon yIcon = new ImageIcon("/Users/MARIUS/Desktop/TICTACTOEO.PNG");
//		//Icon z = new ImageIcon("/Users/MARIUS/Desktop/TICTACTOEN.PNG");
//
//
//
//		JButton b = new JButton("Start");
//		b.setBounds(250, 30, 80, 80);
//		add(b);
//		b.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});
//
//		if(board.turn%2 == 0) {
//			JButton b1 = new JButton("", nothing);
//			b1.setBounds(80, 127, 143, 143);
//			add(b1);
//			b1.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b2 = new JButton("", nothing);
//			b2.setBounds(223, 127, 143, 143);
//			add(b2);
//			b2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//
//				}
//			});
//
//			JButton b3 = new JButton("", nothing);
//			b3.setBounds(366, 127, 143, 143);
//			add(b3);
//			b3.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b4 = new JButton("", nothing);
//			b4.setBounds(80, 270, 143, 143);
//			add(b4);
//			b4.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//
//				}
//			});
//
//			JButton b5 = new JButton("", nothing);
//			b5.setBounds(223, 270, 143, 143);
//			add(b5);
//			b5.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//
//				}
//			});
//
//			JButton b6 = new JButton("", nothing);
//			b6.setBounds(223, 270, 143, 143);
//			add(b6);
//			b6.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//
//				}
//			});
//
//			JButton b7 = new JButton("", nothing);
//			b7.setBounds(366, 270, 143, 143);
//			add(b7);
//			b7.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//
//				}
//			});
//
//			JButton b7 = new JButton("", nothing);
//			b7.setBounds(80, 413, 143, 143);
//			add(b7);
//			b7.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//
//				}
//			});
//
//			JButton b8 = new JButton("", nothing);
//			b8.setBounds(223, 413, 143, 143);
//			add(b8);
//			b8.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//
//				}
//			});
//
//			JButton b9 = new JButton("", nothing);
//			b9.setBounds(366, 413, 143, 143);
//			add(b9);
//			b9.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.turn -= board.turn;
//
//				}
//			});
//		}
//
//		else if (board.turn%2 == 1) {
//			JButton b1 = new JButton("", yIcon);
//			b1.setBounds(80, 127, 143, 143);
//			add(b1);
//			b1.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b2 = new JButton("", yIcon);
//			b2.setBounds(223, 127, 143, 143);
//			add(b2);
//			b2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b3 = new JButton("", yIcon);
//			b3.setBounds(366, 127, 143, 143);
//			add(b3);
//			b3.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b4 = new JButton("", yIcon);
//			b4.setBounds(80, 270, 143, 143);
//			add(b4);
//			b4.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b5 = new JButton("", yIcon);
//			b5.setBounds(223, 270, 143, 143);
//			add(b5);
//			b5.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b6 = new JButton("", yIcon);
//			b6.setBounds(223, 270, 143, 143);
//			add(b6);
//			b6.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b7 = new JButton("", yIcon);
//			b7.setBounds(366, 270, 143, 143);
//			add(b7);
//			b7.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b7 = new JButton("", yIcon);
//			b7.setBounds(80, 413, 143, 143);
//			add(b7);
//			b7.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b8 = new JButton("", yIcon);
//			b8.setBounds(223, 413, 143, 143);
//			add(b8);
//			b8.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//
//			JButton b9 = new JButton("", yIcon);
//			b9.setBounds(366, 413, 143, 143);
//			add(b9);
//			b9.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					board.startButton();
//					board.turn -= board.turn;
//				}
//			});
//		}
//
//
//	}













