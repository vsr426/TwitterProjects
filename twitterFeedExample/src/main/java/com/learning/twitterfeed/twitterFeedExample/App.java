package com.learning.twitterfeed.twitterFeedExample;

import java.util.ArrayList;
import java.util.List;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class App 
{
	private static String CONSUMERKEY="xxx";
	private static String CONSUMERKEY_SECRET="xxx";
	private static String ACCESSTOKEN="xxxx";
	private static String ACCESSTOKEN_SECRET="xxxx";

    public static void main( String[] args )
    {
    	List<Status> responseStatuses= new ArrayList<Status>();
    	ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setOAuthConsumerKey(CONSUMERKEY)
    	.setOAuthConsumerSecret(CONSUMERKEY_SECRET)
    	.setOAuthAccessToken(ACCESSTOKEN)
    	.setOAuthAccessTokenSecret(ACCESSTOKEN_SECRET)
    	.setDebugEnabled(true)
    	.setJSONStoreEnabled(true)
    	.setTweetModeExtended(true);
    	Query query = new Query("Bigdata, DataScience, MachineLearning");
    	query.setCount(100);
    	Twitter twitter = new TwitterFactory(cb.build()).getInstance();
    	
    	try {
//			responseStatuses=twitter.getHomeTimeline();
    		responseStatuses = twitter.search(query).getTweets();
			for (Status status: responseStatuses) {
				String message = status.isRetweet()? status.getRetweetedStatus().getText(): status.getText();
				System.out.println(status.getUser().getName() + "  tweeted at "+ status.getCreatedAt()+ " Message: "+ message);
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    		
    			
    }
}
