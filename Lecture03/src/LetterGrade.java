public class LetterGrade extends Grade {
    private String grade;

    public LetterGrade(String grade){
        this.grade = grade;
    }

    @Override
    public double gpa(){
        double gpaValue = 0.0;
        switch(this.grade){
            case "A": gpaValue = 4.0; break;
            case "B": gpaValue = 3.0; break;
            case "C": gpaValue = 2.0; break;
            case "D": gpaValue = 1.0; break;
            case "E": gpaValue = 0.0; break;
            default: throw new RuntimeException("Exception");
        }

        return gpaValue;
    }
}
