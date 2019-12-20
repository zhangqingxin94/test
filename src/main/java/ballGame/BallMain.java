package java.ballGame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

/*创建窗体*/
public class BallMain extends JFrame{
	//窗体的宽高
	public static final int SCREEN_WIDTH = 1360;
	public static final int SCREEN_HEIGHT = 760;

	//全屏
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)d.getWidth();
    int height = (int)d.getHeight();

	public BallMain(){
		this.setTitle("V1.0");
		//设置位置
		this.setBounds(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);

		//添加小球到窗体
		BallJPanel bj = new BallJPanel();
		this.add(bj);

		//添加键盘的监听事件
		this.addKeyListener(bj);

		/*frame.addKeyListener(tj);
		tj.addKeyListener(tj);
		*/
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		BallMain b = new BallMain();
		//添加音乐
				try {
					FileInputStream f =new FileInputStream("music/yyyy.wav");
					AudioStream as = new AudioStream(f);
					AudioPlayer.player.start(as);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {

					e.printStackTrace();
				}
	}
}