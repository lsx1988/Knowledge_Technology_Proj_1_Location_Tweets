//title			:LevenshteinDis.java
//description	:The program is used to calculate the Levenshtein Distance between two given strings
//author		:Shixun Liu
//date			:2016/08/23
//usage			:Unimelb_KT_Assignment1_Approx String Matching
//=============================================================================
public class LevenshteinDis {

		private int matchScore;
		
		private char[] query;
		private char[] keyWord;
		private int[][] metric;
		
		//Calculate the metric value based on Levenshtein algorithm
		public void score(char[] query, char[] keyWord){
			
			int rowLen = keyWord.length;
			int colLen = query.length;	
			metric = new int[rowLen+1][colLen+1];
			
			for(int row = 0; row <= rowLen; row++){
				metric[row][0] = row; 
			}
			
			for(int col = 0; col <= colLen; col++){
				metric[0][col] = col;
			}
			
			for(int row = 1; row <= rowLen; row++){
				for(int col = 1; col <= colLen; col++){
					if(query[col-1] == keyWord[row-1]){
						matchScore = 0;					
					}else{
						matchScore = 1;							
					}
					metric[row][col] = Math.min(Math.min(metric[row - 1][col] + 1, metric[row][col - 1] + 1)
							,metric[row-1][col-1] + this.matchScore);
				}
			}
		}
		
		//Get the score on the right bottom position of metric
		public int getDis(String query, String keyWord){
			
			this.query = query.toCharArray();
			this.keyWord = keyWord.toCharArray();
			this.score(this.query, this.keyWord);
			return this.metric[keyWord.length()][query.length()];
		}
}
