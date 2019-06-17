package ballGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Ball {
	/* 小球的基本属性 */
	int x, y;//定义x, y坐标
	int d;//直径
	Color ballColor;//小球的颜色
	int speed;//小球的运动速度
	int position;//小球的运动方向

	/*小球的运动方向*/
	public static final int LEFT_UP = 0;//左上
	public static final int RIGHT_UP = 1;//右上
	public static final int LEFT_DOWN = 2;//左下
	public static final int RIGHT_DOWN = 3;//右下

	/*构造方法*/
	public Ball(int x, int y, int position, int d, int speed, Color ballColor){
		this.x = x;
		this.y = y;
		this.position = position;
		this.d = d;
		this.speed = speed;
		this.ballColor = ballColor;
	}
	//构造玩家球
	public Ball(int x, int y, int d, int speed, Color ballColor){
		this.x = x;
		this.y = y;
		this.d = d;
		this.speed = speed;
		this.ballColor = ballColor;
	}

	//画小球
	public void drawBall(Graphics g){
		g.setColor(ballColor);
		g.fillOval(x, y, d, d);
	}
	public void drawBall2(Graphics g){
		g.setColor(ballColor);
		g.fillOval(x, y, d, d);

		//球加文字
		g.setColor(Color.RED);
		//设置字体大小
		Font font = new Font(Font.DIALOG, Font.BOLD, 14);
		g.setFont(font);
		g.drawString("^_^", x+d/2, y+d/2);
	}

//小球的运动方向
public void ballMove(){
	switch (this.position) {
	case LEFT_UP:
		x -= speed;
		y -= speed;
		if (x <= 0) {
			this.position = RIGHT_UP;
		}else if (y <= 0) {
			this.position = LEFT_DOWN;
		}
		break;
	case RIGHT_UP:
		x += speed;
		y -= speed;
		if (x >= BallMain.SCREEN_WIDTH - d) {
			this.position = LEFT_UP;
		}else if (y <= 0) {
			this.position = RIGHT_DOWN;
		}
		break;
	case LEFT_DOWN:
		x -= speed;
		y += speed;
		if (x <= 0) {
			this.position = RIGHT_DOWN;
		}else if (y >= BallMain.SCREEN_HEIGHT - d) {
			this.position = LEFT_UP;
		}
		break;
	case RIGHT_DOWN:
		x += speed;
		y += speed;
		if (x >= BallMain.SCREEN_WIDTH - d) {
			this.position = LEFT_DOWN;
		}else if (y >= BallMain.SCREEN_HEIGHT - d) {
			this.position = RIGHT_UP;
		}
		break;
		}
	}
}