public class MVCPatternDemo {
    public static void main(String [] args){
        // fetch student record based on his roll no from the database
        Student model = new Student("1001", "John Smith");

        // create a view: to write student details on console
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        // update model data
        controller.setStudentName("Alex Nathan");
        controller.setStudentRollNo("1002");

        // update what user sees
        controller.updateView();
    }
}
