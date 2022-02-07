import java.io.*;
import java.util.Scanner;

public class MasterMindGame {
    public static void main(String[] args) throws IOException {
        MasterMind mGame = new MasterMind();
        displayScreen();
        while (mGame.isProgress()){
            System.out.print("Enter Your Guess : ");
            String answer = "";
            while(true){
                answer = acceptNumber();
                if(answer.length() != 4){
                    System.out.println("You must enter all 4 numeric characters!");
                }
                else{
                    try {
                        Integer.parseInt(answer);
                        break;
                    }
                    catch (NumberFormatException ex){
                        System.out.println("You must enter all 4 numeric characters!");
                    }
                }
                System.out.print("Enter Your Guess : ");
            }
            Answer ans = new Answer(answer);
            mGame.evaluateResult(ans);
            System.out.print(mGame.getResult()+"\n");
        }
        if (mGame.isWon())
            System.out.print("YOU WIN");
        else {
            System.out.print("YOU LOST \n");
            System.out.print("CORRECT ANSWER IS " +
                    mGame.getHiddenNumber());
        }
    }
    public static void displayScreen(){
        System.out.println("Please Guess four Hidden Digits");
    }
    private static String acceptNumber() throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
