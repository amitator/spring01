import services.QuizImpl;

public class Main {
    public static void main(String[] args) {

        QuizImpl quiz = new QuizImpl();
        quiz.userName();
        quiz.collectQuestions();
        quiz.getAnswer();
        quiz.showResult();

    }
}
