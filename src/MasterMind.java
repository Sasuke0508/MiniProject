import java.util.*;
public class MasterMind {
    // Số lần đoán tối đa
    private static int defaultmaxAllowTime = 8;
    // Số chữ số của số cần đoán
    private static int QUIZZ_LENGTH = 4;
    // Nếu đúng cả số và vị trí
    private static char allCorrect='*';
    // Nếu đúng số và sai vị trí
    private static char numberCorrect='!';
    // Các trạng thái của game
    public enum State {PROGRESS, LOST, WIN }
    // Số cần đoán
    private String hiddenNumber;
    // Trạng thái game
    private State gameState;
    // Số lần đoán tối đa
    private int maxAllowTime;
    // List các đáp án đã trả lời
    private List<Answer> attemptList;
    // Đáp án chính xác
    private String correctAnswer = new String();

    public MasterMind() {
        gameState = State.PROGRESS;
        hiddenNumber = "4567";
        maxAllowTime = defaultmaxAllowTime;
        for(int i=1;i<= QUIZZ_LENGTH;i++){
            correctAnswer = correctAnswer + allCorrect;
        }
        attemptList = new ArrayList<Answer>();
    }
    public String getHiddenNumber(){
        return hiddenNumber;
    }
    public boolean isProgress(){
        return gameState==State.PROGRESS;
    }
    public boolean isGameOver(){
        return gameState==State.LOST;
    }
    public boolean isWon(){
        return gameState==State.WIN;
    }
    private String generateHiddenNumber(){
        Random rand = new Random();
        return String.format("%04d", rand.nextInt(10000));
    }
    public String getResult(){
        /* ========================= A ======================*/
        Answer ans = this.attemptList.get(this.attemptList.size() - 1);
        /* ========================= A ======================*/
        return ans.getResult();
    }

    public void evaluateResult(Answer ans){
        /* ========================= B ======================*/
        if (ans.getAnswer()!=null) {
        /* ========================= B ======================*/
            ans.setResult(matchResult(ans.getAnswer()));
            this.attemptList.add(ans);
        }
        changeGameStatus(ans);
    }
    private void changeGameStatus(Answer paraAttmpt){
        if (attemptList.size() < maxAllowTime){
            /* ========================= C ======================*/
            if ( matchResult(paraAttmpt.getAnswer()).equals(correctAnswer))
            /* ========================= C ======================*/
                gameState=State.WIN;
        } else
            gameState = State.LOST;
    }
//    So sánh số nhập vào và số cần đoán
    public String matchResult(String inputNumber){
        char[] inChar;
        char[] hidChar;
        String rtnValue = new String();
        inChar = inputNumber.toCharArray();
        hidChar = hiddenNumber.toCharArray();
        for (int i=0;i < hiddenNumber.length();i++){
            if (inChar[i]==hidChar[i]){
                // mark the character is already used
                inChar[i] = '#';
                rtnValue= rtnValue + this.allCorrect;
            } else
                for (int j=0;j < hiddenNumber.length();j++){
                    /* ========================= D ======================*/
                    if (inChar[i]==hidChar[j]) {
                    /* ========================= D ======================*/
                // mark the character is already used
                        inChar[i] = '#';
                        rtnValue=rtnValue + this.numberCorrect;
                        break;
                    }
                }
        }
        return rtnValue;
    }
}