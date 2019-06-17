package ballGame;

/*处理小球之间的关系*/
public class BallAndBall {

	//两小球碰撞
	public void ballCrach(Ball b1, Ball b2){
		int x1 =  b1.x + b1.d/2;
		int y1 =  b1.y + b1.d/2;
		int x2 =  b2.x + b2.d/2;
		int y2 =  b2.y + b2.d/2;

		double e = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		//如果碰撞上
		if (e <= b1.d/2 + b2.d/2) {
			//b1小球
			switch (b1.position) {
			case Ball.LEFT_UP:
				b1.position = Ball.RIGHT_DOWN;
				break;
			case Ball.RIGHT_UP:
				b1.position = Ball.LEFT_DOWN;
				break;
			case Ball.LEFT_DOWN:
				b1.position = Ball.RIGHT_UP;
				break;
			case Ball.RIGHT_DOWN:
				b1.position = Ball.LEFT_UP;
				break;
			}
			//b2小球
			switch (b2.position) {
			case Ball.LEFT_UP:
				b2.position = Ball.RIGHT_DOWN;
				break;
			case Ball.RIGHT_UP:
				b2.position = Ball.LEFT_DOWN;
				break;
			case Ball.LEFT_DOWN:
				b2.position = Ball.RIGHT_UP;
				break;
			case Ball.RIGHT_DOWN:
				b2.position = Ball.LEFT_UP;
				break;
			}
		}
	}

	//检查是否碰撞上
	public boolean isBallCrach(Ball b1, Ball b2){
		boolean flag = false;
		int x1 =  b1.x + b1.d/2;
		int y1 =  b1.y + b1.d/2;
		int x2 =  b2.x + b2.d/2;
		int y2 =  b2.y + b2.d/2;
		//计算圆心距
		double e = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));

		if (e <= b1.d/2 + b2.d/2) {
			return true;
		}

		return false;
	}
}