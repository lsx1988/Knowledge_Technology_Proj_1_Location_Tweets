import java.io.IOException;

public class Test_GED {

		public static void main(String args[]) throws IOException{
			GED ged = new GED();
			LevenshteinDis lenDis = new LevenshteinDis();			
			String query;

			double temp = 0;
			double bestSimilarity = 0;
			String tempQuery = null;
			int tweetNum = 0;
			int lenDistanceThreshold = 3;
			int lenDistanceOfQuery = 0;
			
			Tree tree = new Tree();
			Node root = null;
			
			ProcessLocationList location = new ProcessLocationList(".\\geonames\\US-loc-names.txt");
			ProcessTweet tweets = new ProcessTweet(".\\geonames\\shixunl_tweets_small.txt");
			location.getText();
			tweets.getText();
			
			for(String loc:location.list){
				root = tree.insert(root, lenDis.getDis(loc, "Water Well"), loc);			
			}
			
			for(String[] tweet:tweets.list){
				temp = 0;
				bestSimilarity = 0;
				tweetNum++;
				for(int queryIndex = 0; queryIndex < tweet.length - 1; queryIndex++){
					query = tweet[queryIndex];
					lenDistanceOfQuery = lenDis.getDis(query, "water well");
					for(int limit = lenDistanceOfQuery - lenDistanceThreshold; limit <= lenDistanceOfQuery + lenDistanceThreshold; limit++){
						tree.searchResult.clear();
						tree.search(root, limit);
						for(String loc:tree.searchResult){
							temp= ged.getDis(query,loc);
							if(temp >= 4){
								bestSimilarity = temp;
								tempQuery = query;
								System.out.println("Tweet" + tweetNum + ": Word: " + tempQuery + " Location: " + loc + " : " + bestSimilarity);
							}	
						}
					}			
				}
				if(bestSimilarity == 0){
					System.out.println("Tweet" + tweetNum + ": No proper location");
				}
			}
		}
}

