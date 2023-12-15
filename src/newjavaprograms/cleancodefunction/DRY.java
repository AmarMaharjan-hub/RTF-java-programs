package newjavaprograms.cleancodefunction;

public class DRY {

    char boardCell[] = new char[9];

    Player player = new Player();

    public boolean checkWinnerBad(){

//        check first row
        if(boardCell[0] == player.symbol && boardCell[1] == player.symbol && boardCell[2] == player.symbol){
            return true;
        }

//        check second row
        if(boardCell[3] == player.symbol && boardCell[4] == player.symbol && boardCell[5] == player.symbol){
            return true;
        }

//        check third row
        if(boardCell[6] == player.symbol && boardCell[7] == player.symbol && boardCell[8] == player.symbol){
            return true;
        }

//        check first column
        if(boardCell[0] == player.symbol && boardCell[3] == player.symbol && boardCell[6] == player.symbol){
            return true;
        }

//        check second column
        if(boardCell[1] == player.symbol && boardCell[4] == player.symbol && boardCell[7] == player.symbol){
            return true;
        }

//        check third column
        if(boardCell[2] == player.symbol && boardCell[5] == player.symbol && boardCell[8] == player.symbol){
            return true;
        }

//        check downhill diagonal
        if(boardCell[0] == player.symbol && boardCell[4] == player.symbol && boardCell[8] == player.symbol){
            return true;
        }

//        check uphill diagonal
        if(boardCell[2] == player.symbol && boardCell[4] == player.symbol && boardCell[6] == player.symbol){
            return true;
        }

        return false;
    }

    public boolean checkWinnerGood(){
        int winningCombinations[][] = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}};

        for(int[] combination : winningCombinations){
            if(isWinner(combination)){
                return true;
            }
        }
        return false;
    }

    private boolean isWinner(int[] combination) {

        for(int symbolIndex : combination){
            if(player.symbol != boardCell[symbolIndex]){
                return false;
            }
        }
        return true;

    }

    public class Player{
        int player;
        char symbol;
    }

}
