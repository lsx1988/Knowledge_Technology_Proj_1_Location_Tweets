//title			:BISIM.java
//description	:The program is used to calculate the similarity between two strings
//author		:Shixun Liu
//date			:2016/08/23
//usage			:Unimelb_KT_Assignment1_Approx String Matching
//resource      :<N-Gram similarity and distance> by Grzegorz Kondrak
//=============================================================================
public class BISIM {
	
	private String query;
	private String keyWord;
	private double[][] functionS;

	//Adding affixing at the front of a given string, the new added char is same as the first letter of string
	public String affixing(String str){

		String processedString= str;
		
		if(str == null || str == ""){
			processedString = ""; //if given string is null or "", processesString keeps the same
		}else{
			String firstStr = str.substring(0,1); //Get first letter of given string
			processedString = firstStr + processedString; //Add the first letter to given string	
		}		
		return processedString;
	}
	
	//Below function calculate the similarity between to given strings, the algorithm referred to <N-Gram similarity and distance> by Grzegorz Kondrak
	public double biSIM(String query, String keyWord){
		
		this.query = affixing(query);
	    this.keyWord = affixing(keyWord);
	    	
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
				functionS[i][j] = Math.max(Math.max(S(i-1,j), S(i,j-1)), S(i-1,j-1) + Sn(i,j));
			}
		}
		return functionS[K][L] / (double)(Math.max(K,L)-1);
	}
	
	public double S(int queryLen, int keyLen){
		
		return functionS[queryLen][keyLen];
	}
		
	public double Sn(int queryLen, int keyLen){
		
		withinNgram inNgram = new withinNgram();
		
		if(queryLen < 2 || keyLen < 2){
			return 0;
		}else{
			return 0.5*(inNgram.similarity(this.query.substring(queryLen - 2,queryLen), this.keyWord.substring(keyLen - 2, keyLen)));
		}
	}
}



