import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;
	
	/**
	 * 空构造器
	 */
	public GobangGame() {
		
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		
		/*int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;*/
		int BOARD_SIZE=chessboard.BOARD_SIZE;
		String[][] board = chessboard.getBoard();
		int[][][] quan = new int[BOARD_SIZE][BOARD_SIZE][9];
		int count=0;
		int x=0,y=0;
		int i,j;
		
		for(x=0;x<BOARD_SIZE;x++)
		{
			for(y=0;y<BOARD_SIZE;y++)
			{						
					for(i=0;i<9;i++)
					{
						
						quan[x][y][i]=0;
					}				
			}
		}
		for(x=0;x<BOARD_SIZE;x++)
		{
			for(y=0;y<BOARD_SIZE;y++)
			{		
				if(board[x][y]=="十")
				{
					//对方，人
					//横向
					i=x-1;j=y;
					while(i>=0)
					{
						
						if(board[i][j]=="●")
						{
							
							count++;
							i--;
							
						}else{
							break;
						}
						
					}
					//System.out.print("666");
					i=x+1;j=y;
					while(i<BOARD_SIZE)
					{
						
						if(board[i][j]=="●")
						{
							count++;
						i++;
							
						}else{
							break;
						}
						
					
					}
					
					if(count==0)
					{
						quan[x][y][0]+=0;
					}else if(count==1)
					{
						quan[x][y][0]+=20;
					}else if(count==2)
					{
						quan[x][y][0]+=80;
					}else if(count==3)
					{
						quan[x][y][0]+=500;
					}else if(count==4)
					{
						quan[x][y][0]+=5000;
					}		
					count=0;
					//竖向
					

					i=x;j=y-1;
					while(j>=0){
						if(board[i][j]=="●")
						{
							count++;
						j--;
						}else{
							break;
						}
						
					
					}
					i=x;j=y+1;
					while(j<BOARD_SIZE){
						if(board[i][j]=="●")
						{
							count++;
						j++;
						}else{
							System.out.print("66666666");
							break;
						}
						
					
					}
					if(count==1)
					{
						quan[x][y][1]+=20;
					}else if(count==2)
					{
						quan[x][y][1]+=80;
					}else if(count==3)
					{
						quan[x][y][1]+=500;
					}else if(count==4)
					{
						quan[x][y][1]+=5000;
					}
					count=0;
					//主对角线
					i=x-1;j=y-1;
					while(i>=0&&j>=0){
						if(board[i][j]=="●")
						{
							count++;
						i--;
						j--;
						}else{
							break;
						}
						
					
					}
					i=x+1;j=y+1;
					while(i<BOARD_SIZE&&j<BOARD_SIZE){
						if(board[i][j]=="●")
						{
							count++;
						i++;
						j++;
						}else{
							break;
						}
						
					
					}
					if(count==1)
					{
						quan[x][y][2]+=20;
					}else if(count==2)
					{
						quan[x][y][2]+=80;
					}else if(count==3)
					{
						quan[x][y][2]+=500;
					}else if(count==4)
					{
						quan[x][y][2]+=5000;
					}
					count=0;
					//副对角线
					i=x-1;j=y+1;
					while(i>=0&&j<BOARD_SIZE){
						if(board[i][j]=="●")
						{
							count++;
						i--;
						j++;
						}else{
							break;
						}
						
					
					}
					i=x+1;j=y-1;
					while(i<BOARD_SIZE&&j>=0){
						if(board[i][j]=="●")
						{
							count++;
						i++;
						j--;
						}else{
							break;
						}
						
					
					}
					if(count==1)
					{
						quan[x][y][3]+=20;
					}else if(count==2)
					{
						quan[x][y][3]+=80;
					}else if(count==3)
					{
						quan[x][y][3]+=500;
					}else if(count==4)
					{
						quan[x][y][3]+=5000;
					}
					count=0;
					
					//己方，电脑
					//横向
					i=x-1;j=y;
					while(i>=0){
						if(board[i][j]=="○")
						{
							count++;
						i--;
						}else{
							break;
						}
						
					
					}
					i=x+1;j=y;
					while(i<BOARD_SIZE&&board[i][j]=="○"){
						if(board[i][j]=="○")
						{
							count++;
						i++;
						}else{
							break;
						}
						
					
					}
					if(count==1)
					{
						quan[x][y][4]+=21;
					}else if(count==2)
					{
						quan[x][y][4]+=81;
					}else if(count==3)
					{
						quan[x][y][4]+=501;
					}else if(count==4)
					{
						quan[x][y][4]+=5001;
					}
					count=0;
					//竖向
					i=x;j=y-1;
					while(j>=0){
						if(board[i][j]=="○")
						{
							count++;
						j--;
						}else{
							break;
						}
						
					
					}
					i=x;j=y+1;
					while(j<BOARD_SIZE){
						if(board[i][j]=="○")
						{
							count++;
						j++;
						}else{
							break;
						}
						
					
					}
					if(count==1)
					{
						quan[x][y][5]+=21;
					}else if(count==2)
					{
						quan[x][y][5]+=81;
					}else if(count==3)
					{
						quan[x][y][5]+=501;
					}else if(count==4)
					{
						quan[x][y][5]+=5001;
					}
					count=0;
					//主对角线
					i=x-1;j=y-1;
					while(i>=0&&j>=0){
						if(board[i][j]=="○")
						{
							count++;
						i--;
						j--;
						}else{
							break;
						}
						
					
					}
					i=x+1;j=y+1;
					while(i<BOARD_SIZE&&j<BOARD_SIZE){
						if(board[i][j]=="○")
						{
							count++;
						i++;
						j++;
						}else{
							break;
						}
						
					
					}
					if(count==1)
					{
						quan[x][y][6]+=21;
					}else if(count==2)
					{
						quan[x][y][6]+=81;
					}else if(count==3)
					{
						quan[x][y][6]+=501;
					}else if(count==4)
					{
						quan[x][y][6]+=5001;
					}
					count=0;
					//副对角线
					i=x-1;j=y+1;
					while(i>=0&&j<BOARD_SIZE){
						if(board[i][j]=="○")
						{
							count++;
						i--;
						j++;
						}else{
							break;
						}
						
					
					}
					i=x+1;j=y-1;
					while(i<BOARD_SIZE&&j>=0){
						if(board[i][j]=="○")
						{
							count++;
						i++;
						j--;
						}else{
							break;
						}
						
					
					}
					if(count==1)
					{
						quan[x][y][7]+=21;
					}else if(count==2)
					{
						quan[x][y][7]+=81;
					}else if(count==3)
					{
						quan[x][y][7]+=501;
					}else if(count==4)
					{
						quan[x][y][7]+=5001;
					}
					count=0;
					
					for(i=0;i<8;i++)
					{
						
						quan[x][y][8]+=quan[x][y][i];
					}
					
					System.out.print("权值是"+quan[x][y][8]);
				}
				
			}
			
		}
		
		int max=0;
		int posX=0,posY=0;
		for( i=0;i<BOARD_SIZE;i++)
		{
			for( j=0;j<BOARD_SIZE;j++)
			{
				//System.out.println("权值是"+quan[x][y][8]);
				
				if(board[i][j]=="十"&&quan[i][j][8]>max)
				{
					max=quan[i][j][8];
					posX=i;
					posY=j;
				}
			}	
		}
		int[] result = { posX, posY };
		return result;
		
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int p=0,q=0;
		int i;
		int x=posX;
		int y=posY;
		boolean result=false;
		String board[][]=chessboard.getBoard();
		//x和y是输入值减一；
		//竖向判断
		for(i=x-1;i>=0;i--)
		{
			if(i==0&&board[i][y]==ico) {p=i;}
			if(board[i][y]!=ico||i==-1){
				p=i+1;
				break;
			}
		}
		for(i=x+1;i<chessboard.BOARD_SIZE;i++)
		{
			if(board[i][y]!=ico){
				q=i-1;
				break;
			}
		}
		/*while(q<chessboard.BOARD_SIZE)
		{
			q=x+1;
			if(board[q][y]==ico){
				q++;
			}
		}*/
		//quan[x][y]+=(p-q+1)*10;
		if(q-p+1>=WIN_COUNT){
			result=true;
		}
		//横向判断
		for(i=y-1;i>=0;i--)
		{
			if(i==0&&board[x][i]==ico) {p=i;}

			if(board[x][i]!=ico||i==-1){
				p=i+1;
				break;
			}
		}
		for(i=y+1;i<chessboard.BOARD_SIZE;i++)
		{
			if(board[x][i]!=ico){
				q=i-1;
				break;
			}
		}
		//quan[x][y]+=(p-q+1)*10;
		if(q-p+1>=WIN_COUNT){
			result=true;
		}
		//主对角线判断
		for(i=1;i<=x&&i<=y;i++)
		{
			if((x-i==-1)&&board[x][y]==ico) {p=x;}
			if(board[x-i][y-i]!=ico||x-i==-1||y-i==-1){
				p=x-i+1;
				//System.out.print("x="+x+"找到的端点为"+p);
				break;
			}
		}
		for(i=1;i<chessboard.BOARD_SIZE-x&&i<chessboard.BOARD_SIZE-y;i++)
		{
			if(board[x+i][y+i]!=ico){
				q=x+i-1;
				//System.out.print("x="+x+"y="+y+"另一个端点为"+q);
				break;
			}
		}
		//quan[x][y]+=(p-q+1)*10;
		if(q-p+1>=WIN_COUNT){
			result=true;
		}
		//副对角线判断
		for(i=1;i<x&&i<chessboard.BOARD_SIZE-y;i++)
		{
			if(i==0&&board[x-i][y+i]==ico) {p=i;}
			if(board[x-i][y+i]!=ico){
				p=x-i+1;
				break;
			}
		}
		for(i=1;i<chessboard.BOARD_SIZE-x&&i<y;i++)
		{
			if(board[x+i][y-i]!=ico){
				q=x+i-1;
				break;
			}
		}
		//quan[x][y]+=(p-q+1)*10;
		if(q-p+1>=WIN_COUNT){
			result=true;
		}	
		//System.out.print("权值为"+quan[x][y]);
		return result;
	}

	public static void main(String[] args) throws Exception {
        
		//List<Integer> list=new ArrayList<Integer>();
		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
