import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;
	
	/**
	 * �չ�����
	 */
	public GobangGame() {
		
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
		
		/*int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
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
				if(board[x][y]=="ʮ")
				{
					//�Է�����
					//����
					i=x-1;j=y;
					while(i>=0)
					{
						
						if(board[i][j]=="��")
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
						
						if(board[i][j]=="��")
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
					//����
					

					i=x;j=y-1;
					while(j>=0){
						if(board[i][j]=="��")
						{
							count++;
						j--;
						}else{
							break;
						}
						
					
					}
					i=x;j=y+1;
					while(j<BOARD_SIZE){
						if(board[i][j]=="��")
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
					//���Խ���
					i=x-1;j=y-1;
					while(i>=0&&j>=0){
						if(board[i][j]=="��")
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
						if(board[i][j]=="��")
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
					//���Խ���
					i=x-1;j=y+1;
					while(i>=0&&j<BOARD_SIZE){
						if(board[i][j]=="��")
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
						if(board[i][j]=="��")
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
					
					//����������
					//����
					i=x-1;j=y;
					while(i>=0){
						if(board[i][j]=="��")
						{
							count++;
						i--;
						}else{
							break;
						}
						
					
					}
					i=x+1;j=y;
					while(i<BOARD_SIZE&&board[i][j]=="��"){
						if(board[i][j]=="��")
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
					//����
					i=x;j=y-1;
					while(j>=0){
						if(board[i][j]=="��")
						{
							count++;
						j--;
						}else{
							break;
						}
						
					
					}
					i=x;j=y+1;
					while(j<BOARD_SIZE){
						if(board[i][j]=="��")
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
					//���Խ���
					i=x-1;j=y-1;
					while(i>=0&&j>=0){
						if(board[i][j]=="��")
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
						if(board[i][j]=="��")
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
					//���Խ���
					i=x-1;j=y+1;
					while(i>=0&&j<BOARD_SIZE){
						if(board[i][j]=="��")
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
						if(board[i][j]=="��")
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
					
					System.out.print("Ȩֵ��"+quan[x][y][8]);
				}
				
			}
			
		}
		
		int max=0;
		int posX=0,posY=0;
		for( i=0;i<BOARD_SIZE;i++)
		{
			for( j=0;j<BOARD_SIZE;j++)
			{
				//System.out.println("Ȩֵ��"+quan[x][y][8]);
				
				if(board[i][j]=="ʮ"&&quan[i][j][8]>max)
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
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int p=0,q=0;
		int i;
		int x=posX;
		int y=posY;
		boolean result=false;
		String board[][]=chessboard.getBoard();
		//x��y������ֵ��һ��
		//�����ж�
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
		//�����ж�
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
		//���Խ����ж�
		for(i=1;i<=x&&i<=y;i++)
		{
			if((x-i==-1)&&board[x][y]==ico) {p=x;}
			if(board[x-i][y-i]!=ico||x-i==-1||y-i==-1){
				p=x-i+1;
				//System.out.print("x="+x+"�ҵ��Ķ˵�Ϊ"+p);
				break;
			}
		}
		for(i=1;i<chessboard.BOARD_SIZE-x&&i<chessboard.BOARD_SIZE-y;i++)
		{
			if(board[x+i][y+i]!=ico){
				q=x+i-1;
				//System.out.print("x="+x+"y="+y+"��һ���˵�Ϊ"+q);
				break;
			}
		}
		//quan[x][y]+=(p-q+1)*10;
		if(q-p+1>=WIN_COUNT){
			result=true;
		}
		//���Խ����ж�
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
		//System.out.print("ȨֵΪ"+quan[x][y]);
		return result;
	}

	public static void main(String[] args) throws Exception {
        
		//List<Integer> list=new ArrayList<Integer>();
		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
