package newjavaprograms.cleancodefunction;

public class BlocksAndIntending {

    int player1Score = 5;
    int player2Score = 7;

    public String decideWinner(){
//        check if not draw
        if(player1Score != player2Score){
//            return player with most score
            return playerWithMostScore();
        }

//        Avoid nested structures.
//        if(player1Score != player2Score){
//            if(player1Score>player2Score){
//                return "Player1";
//            }
//        }
        return null;
    }

    private String playerWithMostScore() {
        return player1Score > player2Score ? "Player1" : "Player2";
    }

}
