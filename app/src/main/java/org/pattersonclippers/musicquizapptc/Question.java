package org.pattersonclippers.musicquizapptc;

public class Question
{
    // instance variable
    private String qText, hint;
    private boolean correctAnswer;

    // default constructor
    public Question(){
        qText = "";
        correctAnswer = false;
        hint = "";
    }

    // pass-through constructor
    public Question(String newQText, String newHint, boolean newCorredtAnswer)
    {
        qText = newQText;
        correctAnswer = newCorredtAnswer;
        hint = newHint;
    }

    public String getqText() { return qText; }
    public boolean getCorrectAnswer() { return correctAnswer; }
    public void setqText(String newQtext) { qText = newQtext; }
    public void setCorrectAnswer(boolean newCorrectAnswer) { correctAnswer = newCorrectAnswer; }
    public String getHint() { return hint; }
    public void setHint(String newHint) { hint = newHint; }

    @Override
    public String toString()
    {
        return "question text: " + qText + "\n" + "correct answer: " + correctAnswer;
    }

}
