package ballGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*画小球*/
public class BallJPanel extends JPanel implements KeyListener{
	//存储小球的集合
	List<Ball> ballList = new ArrayList<Ball>();
	int x1 = 450;
	int y1 = 450;
	int d1 = 40;
	private Color white;
	//玩家球
	Ball game = new Ball(x1, y1, d1, 50, white);

	//小球的数量
	private int ballNumber = 100;

	public BallJPanel(){
		addBall();
		startBalls();
	}

	//产生小球的方法
	public void addBall(){
		for (int i = 0; i < ballNumber; i++) {
			//随机产生100个小球
			int x = (int)(Math.random()*BallMain.SCREEN_WIDTH);
			int y = (int)(Math.random()*BallMain.SCREEN_HEIGHT);
			int position = (int)(Math.random()*4);
		//	int d = (int)(Math.random()*50 + 1);
			int d = 20;
			int speed = 1;

			//颜色   三原色 R G B
			int red = (int)(Math.random()*255 + 1);
			int green = (int)(Math.random()*255 + 1);
			int blue = (int)(Math.random()*255 + 1);
			Color ballColor = new Color(red, green, blue);
			Ball b = new Ball(x, y, position, d, speed, ballColor);

			//将小球添加到集合中
			ballList.add(b);
		}
	}

	public void paint(Graphics g){
		super.paint(g);

		BufferedImage img =null;
		//添加图片
		try {
			img = ImageIO.read(new File("music/timg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, 1360, 760, this);

		this.setBackground(Color.CYAN);

		for (int i = 0; i < ballList.size(); i++) {
			Ball ball = ballList.get(i);
			ball.drawBall(g);

		}

		//玩家
		game.drawBall2(g);

	}

	public void startBalls(){
		//启动线程-----匿名内部类
		new Thread(){
			public void run() {
				while (true) {
					//遍历小球集合
					for (int i = 0; i < ballList.size(); i++) {
						//取出小球
						Ball b = ballList.get(i);
						//让每一个小球进行移动
						b.ballMove();
					}
					for (int i = 0; i < ballList.size(); i++) {
						//先取第一个小球
						Ball b1 = ballList.get(i);
						for (int j = i+1; j < ballList.size(); j++) {
							Ball b2 = ballList.get(j);
							BallAndBall bad = new BallAndBall();
							//bad.ballCrach(b1, b2);
							if(bad.isBallCrach(b1, b2)){
								if (b1.d >= b2.d) {
									b1.d += b2.d/3;
									ballList.remove(b2);
									break;
								}else if(b1.d < b2.d){
									b2.d += b1.d/3;
									ballList.remove(b1);
									break;
								}
							}
							if (bad.isBallCrach(b1, game)) {
								if (bad.isBallCrach(b1, game)) {
									if (b1.d > game.d) {
										System.out.println("GAME OEVR");
										JOptionPane.showMessageDialog(null, "GAME OVER");
										return;
									}else{
										game.d += b1.d/3;
										ballList.remove(b1);
										break;
									}
								}
							}
						}
					}
					repaint();//重绘
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
		}.start();
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP) {
		//	System.out.println("点击了上方向键");
			game.y -= 10;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		//	System.out.println("点击了下方向键");
			game.y += 10;
		}


  		if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
		//	System.out.println("点击了左方向键");
  			game.x -= 15;
		}

  		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		//	System.out.println("点击了右方向键");
			game.x += 15;
		}
		if (e.getKeyCode() == KeyEvent.VK_1) {
			//	System.out.println("点击了右方向键");
				game.x += 10;
				game.y -= 10;
		}
		if (e.getKeyCode() == KeyEvent.VK_2) {
			//	System.out.println("点击了右方向键");
				game.x -= 10;
				game.y -= 10;
		}
		if (e.getKeyCode() == KeyEvent.VK_3) {
			//	System.out.println("点击了右方向键");
				game.x -= 10;
				game.y += 10;
		}
		if (e.getKeyCode() == KeyEvent.VK_4) {
			//	System.out.println("点击了右方向键");
				game.x += 10;
				game.y += 10;
		}
		repaint();

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}