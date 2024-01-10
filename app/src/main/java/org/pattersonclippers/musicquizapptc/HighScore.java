package org.pattersonclippers.musicquizapptc;

public class HighScore
{
    private int score;
    private  String name;
    public HighScore(int score, String name) {
        this.score = score;
        this.name = name;
    }
    public HighScore()
    {
        score = 0;
        name = "unknown";
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "HighScore{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
