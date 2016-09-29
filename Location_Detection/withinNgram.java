//title			:withinNgram.java
//description	:The program is used to calculate the similarity between two given n-gram, this is utilized by BISIM.java
//author		:Shixun Liu
//date			:2016/08/23
//usage			:Unimelb_KT_Assignment1_Approx String Matching
//resource      :<N-Gram similarity and distance> by Grzegorz Kondrak
//=============================================================================
public class withinNgram {
	
	private String query;
	private String keyWord;
	private double[][] functionS;

	public double similarity(String query, String keyWord){
		
		this.query = query;
	    this.keyWord = keyWord;
		
		int K = this.query.length();
		int L = this.keyWord.length();
		
		this.functionS = new double[K+1][L+1];
		
		for(int i = 0; i <= K; i++){
			functionS[i][0] = 0;
		}
		
		for(int j = 1; j <= L; j++){
			functionS[0][j] = 0;
		}
		
		for(int i = 1; i <= K; i++){
			for(int j = 1; j <= L; j++){
				functionS[i][j] = Math.max(Math.max(S(i-1,j), S(i,j-1)), S(i-1,j-1) + lastChar(i,j));
			}
		}
		return functionS[K][L];
	}
	
	public double S(int queryLen, int keyLen){

			return functionS[queryLen][keyLen];		
	}
		
	public int lastChar(int queryLen, int keyLen){
		if(queryLen < 1 || keyLen < 1){
			return 0;
		}else if(this.query.substring(queryLen - 1, queryLen).equals(this.keyWord.substring(keyLen - 1, keyLen))){
			return 1;
		}else{
			return 0;
		}	
	}
}

