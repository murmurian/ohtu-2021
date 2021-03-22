package ohtu;

public class TennisGame {
    
    private int firstPlayerScore;
    private int secondPlayerScore;
    private String firstPlayerName;
    private String secondPlayerName;
    private String inLead;
    final private String[] scores = new String[] {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(firstPlayerName)) firstPlayerScore++;
        else secondPlayerScore++;
    }

    public String getScore() {
        if (gameIsOver()) {
            return "Win for " + inLead;
        }
        if (advantage()) {
            return "Advantage " + inLead;
        }
        if (firstPlayerScore == secondPlayerScore) {
            if (firstPlayerScore >= 4) {
                return "Deuce";
            }
            return scores[firstPlayerScore] + "-All";
        }        
        return scores[firstPlayerScore] + "-" + scores[secondPlayerScore];
    }

    private boolean gameIsOver() {
        if (firstPlayerScore >= 4 && firstPlayerScore > secondPlayerScore + 1) {
            inLead = firstPlayerName;
            return true;
        } else if (secondPlayerScore >= 4 && secondPlayerScore > firstPlayerScore + 1) {
            inLead = secondPlayerName;
            return true;
        }
        return false;
    }

    private boolean advantage() {
        if (firstPlayerScore >= 4 && firstPlayerScore > secondPlayerScore) {
            inLead = firstPlayerName;
            return true;
        } else if (secondPlayerScore >= 4 && secondPlayerScore > firstPlayerScore) {
            inLead = secondPlayerName;
            return true;
        }
        return false;
    }
}