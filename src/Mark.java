public class Mark {

    private int point=0;

    private String letterPoint;

    public void convertation() {
        if (point>=90 && point<95) this.letterPoint = "A-"; else
        if (point>=95) this.letterPoint = "A"; else
        if (point>=85 && point<90) this.letterPoint = "B+"; else
        if (point>=80 && point<85) this.letterPoint = "B"; else
        if (point>=75 && point<80) this.letterPoint = "B-"; else
        if (point>=70 && point<75) this.letterPoint = "C+"; else
        if (point>=65 && point<70) this.letterPoint = "C"; else
        if (point>=60 && point<65) this.letterPoint = "C-"; else
        if (point>=55 && point<60) this.letterPoint = "D+"; else
        if (point>=50 && point<55) this.letterPoint = "D"; else
        if (point<50) this.letterPoint = "F";
    }

    public int getPoint() {
        return this.point;
    }
    public void addPoint(int point){
        this.point += point;
    }
    public void setPoint(int point) {
        this.point = point;
    }

    public String getLetter() {
        return this.letterPoint;
    }
}
