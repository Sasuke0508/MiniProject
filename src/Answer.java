public class Answer {
    private String answer;
    private String result;
    public Answer(String ans){
        this.answer = new String(ans);
        result= new String();
    }
    public String getResult(){return this.result;}
    public String getAnswer(){return this.answer;}
    public void setAnswer(String answer){this.answer = answer;}
    public void setResult(String result){this.result = result;}
}
