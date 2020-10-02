public class NumericGrade extends Grade {

    private int grade;

    public NumericGrade(int grade){
        this.grade = grade;
    }

    @Override
    public double gpa(){
        if (grade < 50) {
            return 0.0;
        }
        else if (grade < 53) {
            return 0.3;
        }
        else if (grade < 57) {
            return 0.7;
        }
        return 4.0;
    }

}
