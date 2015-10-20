public int[] computerDo() {
		
		
		/*int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "Ê®") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}*/
		
		int computer[][][] = new int[chessboard.BOARD_SIZE][chessboard.BOARD_SIZE][4];
		int man[][][] = new int[chessboard.BOARD_SIZE][chessboard.BOARD_SIZE][4];
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				for(int z=0;z<4;z++){
					computer[i][j][z]=0;
					man[i][j][z]=0;
				}
			}
		}
		
		int x=0,y=0;
		int posX,posY;
		int countl=0,countr=0;
		
		for(x=0;x<chessboard.BOARD_SIZE;x++){
			for(y=0;y<chessboard.BOARD_SIZE;y++){		
				if(chessboard.getBoard()[x][y].equals("Ê®")){
					
					posX=x-1;posY=y;countl=0;countr=0;
					while(posX>=0){
						if(chessboard.getBoard()[posX][posY].equals("¡ð")){
							posX--;
							countl++;
						}else{
							break;
						}
					}
					
					posX=x+1;posY=y;
					while(posX<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[posX][posY].equals("¡ð")){
							posX++;
							countr++;
						}else{
							break;
						}
					}
					computer[x][y][0]=countl+countr;
					
					posX=x;posY=y-1;countl=0;countr=0;
					while(posY>=0){
						if(chessboard.getBoard()[posX][posY].equals("¡ð")){
							posY--;
							countl++;
						}else{
							break;
						}
					}
					posX=x;posY=y+1;
					while(posY<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[posX][posY].equals("¡ð")){
							posY++;
							countr++;
						}else{
							break;
						}
					}
					computer[x][y][1]=countl+countr;
					
					posX=x-1;posY=y-1;countl=0;countr=0;
					while(posY>=0&&posX>=0){
						if(chessboard.getBoard()[posX][posY].equals("¡ð")){
							posX--;posY--;
							countl++;
						}else{
							break;
						}
					}
					posX=x+1;posY=y+1;
					while(posX<chessboard.BOARD_SIZE&&posY<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[posX][posY].equals("¡ð")){
							posX++;posY++;
							countr++;
						}else{
							break;
						}
					}
					computer[x][y][2]=countl+countr;
					
					posX=x-1;posY=y+1;countl=0;countr=0;
					while(posX>=0&&posY<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[posX][posY].equals("¡ð")){
							posX--;posY++;
							countl++;
						}else{
							break;
						}
					}
					posX=x+1;posY=y-1;
					while(posX<chessboard.BOARD_SIZE&&posY>=0){
						if(chessboard.getBoard()[posX][posY].equals("¡ð")){
							posX++;posY--;
							countr++;
						}else{
							break;
						}
					}
					computer[x][y][3]=countl+countr;
					
					
					
					posX=x-1;posY=y;countl=0;countr=0;
					while(posX>=0){
						if(chessboard.getBoard()[posX][posY].equals("¡ñ")){
							posX--;
							countl++;
						}else{
							break;
						}
					}
					posX=x+1;posY=y;
					while(posX<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[posX][posY].equals("¡ñ")){
							posX++;
							countr++;
						}else{
							break;
						}
					}
					man[x][y][0]=countl+countr;
					
					posX=x;posY=y-1;countl=0;countr=0;
					while(posY>=0){
						if(chessboard.getBoard()[posX][posY].equals("¡ñ")){
							posY--;
							countl++;
						}else{
							break;
						}
					}
					posX=x;posY=y+1;
					while(posY<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[posX][posY].equals("¡ñ")){
							posY++;
							countr++;
						}else{
							break;
						}
					}
					man[x][y][1]=countl+countr;
					
					posX=x-1;posY=y-1;countl=0;countr=0;
					while(posY>=0&&posX>=0){
						if(chessboard.getBoard()[posX][posY].equals("¡ñ")){
							posX--;posY--;
							countl++;
						}else{
							break;
						}
					}
					posX=x+1;posY=y+1;
					while(posX<chessboard.BOARD_SIZE&&posY<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[posX][posY].equals("¡ñ")){
							posX++;posY++;
							countr++;
						}else{
							break;
						}
					}
					man[x][y][2]=countl+countr;
					
					posX=x-1;posY=y+1;countl=0;countr=0;
					while(posX>=0&&posY<chessboard.BOARD_SIZE){
						if(chessboard.getBoard()[posX][posY].equals("¡ñ")){
							posX--;posY++;
							countl++;
						}else{
							break;
						}
					}
					posX=x+1;posY=y-1;
					while(posX<chessboard.BOARD_SIZE&&posY>=0){
						if(chessboard.getBoard()[posX][posY].equals("¡ñ")){
							posX++;posY--;
							countr++;
						}else{
							break;
						}
					}
					man[x][y][3]=countl+countr;
				}
			}
		}
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				for(int z=0;z<4;z++){
					if(computer[i][j][z]==0){
						computer[i][j][z]=1;
					}
					if(computer[i][j][z]==1){
						computer[i][j][z]=100;
					}
					if(computer[i][j][z]==2){
						computer[i][j][z]=400;
					}
					if(computer[i][j][z]==3){
						computer[i][j][z]=2000;
					}
					if(computer[i][j][z]==4){
						computer[i][j][z]=10000;
					}
					if(man[i][j][z]==0){
						man[i][j][z]=1;
					}
					if(man[i][j][z]==1){
						man[i][j][z]=100;
					}
					if(man[i][j][z]==2){
						man[i][j][z]=400;
					}
					if(man[i][j][z]==3){
						man[i][j][z]=2000;
					}
					if(man[i][j][z]==4){
						man[i][j][z]=10000;
					}
					
				}
			}
		}
		
		int[][] count=new int[chessboard.BOARD_SIZE][chessboard.BOARD_SIZE];
		
		int Max=computer[0][0][0]+computer[0][0][1]+computer[0][0][2]+computer[0][0][3]+man[0][0][0]+man[0][0][1]+man[0][0][2]+man[0][0][3];
		x=0;y=0;
		String[][] board = chessboard.getBoard();
		/*for(int i=0;i<chessboard.BOARD_SIZE;i++)
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				System.out.println(board[i][j]);
			}*/
		System.out.println(Max);
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				/*System.out.println(chessboard.getBoard()[i][j]);*/
				/*System.out.println(board[i][j]);*/
				if(board[i][j]!="Ê®"){
					continue;
				}
					/*System.out.println("++++");*/
				count[i][j]=computer[i][j][0]+computer[i][j][1]+computer[i][j][2]+computer[i][j][3]+man[i][j][0]+man[i][j][1]+man[i][j][2]+man[i][j][3];
				System.out.println(count[i][j]);
				if(count[i][j]>=Max){
					x=i;y=j;
					Max=count[i][j];
				}
				
				
			}
			
		}
		int[] result = { x, y };
		return result;
	}
