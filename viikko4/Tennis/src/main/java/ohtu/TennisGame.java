package ohtu;

public class TennisGame {
    
    private int score1;
    private int score2;
    private String player1;
    private String player2;
    private String gameResult;


    public TennisGame(String name1, String name2) {
    	this.score1 = 0;
    	this.score2 = 0;
        this.player1 = name1;
        this.player2 = name2;
    }
    
	public void wonPoint(String name) {
        if (name.equals(player1)) {
            score1 +=1;
        } else if (name.equals(player2)) {
        	score2 +=1;
        }
        else {
            return;
        }
    }
	
	private void getGameResultWhenEqualPoints() {
		switch (score1) {
            case 0:
                    gameResult = "Love-All";
                break;
            case 1:
                    gameResult = "Fifteen-All";
                break;
            case 2:
                    gameResult = "Thirty-All";
                break;
            case 3:
                    gameResult = "Forty-All";
                break;
            default:
                    gameResult = "Deuce";
                break;
            
        }
	}
	
	private void getWinOrAdvantage() {
        int playerScoreDifference = score1-score2;
        if (playerScoreDifference==1) {
        	gameResult ="Advantage player1";
        } else if (playerScoreDifference ==-1) {
        	gameResult ="Advantage player2";
        } else if (playerScoreDifference>=2) {
        	gameResult = "Win for player1";
        } else {
        	gameResult ="Win for player2";
        }
	}
	
	private void getGameResult() {
        int tempScore=0;
        for (int i=1; i<3; i++) {
            if (i==1) {
            	tempScore = score1;
            } else { 
            	gameResult+="-"; tempScore = score2;
            }
            switch(tempScore)
            {
                case 0:
                    gameResult+="Love";
                    break;
                case 1:
                    gameResult+="Fifteen";
                    break;
                case 2:
                    gameResult+="Thirty";
                    break;
                case 3:
                    gameResult+="Forty";
                    break;
            }
        }		
	}
	
    public String getScore() {
        gameResult = ""; 
        boolean equalPoints = false;
        boolean winOrAdvantage = false;
        
        if (score1==score2) {
        	equalPoints = true;
        }            
        if (score1>=4 || score2>=4) {
        	winOrAdvantage = true;
        }
        
        if (equalPoints) {
            getGameResultWhenEqualPoints();
        } else if (winOrAdvantage) {
        	getWinOrAdvantage();
        } else {
        	getGameResult();
        }
        return gameResult;
    }
}