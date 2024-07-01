import java.util.*;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public QuizQuestion(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}

public class QuizApplicationWithTimer {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static final int TIME_LIMIT = 10; // time limit in seconds

    public static void main(String[] args) {
        QuizQuestion[] quizQuestions = setupQuiz();

        System.out.println("Welcome to the Quiz!");

        for (QuizQuestion question : quizQuestions) {
            boolean answeredCorrectly = presentQuestionWithTimer(question);
            if (answeredCorrectly) {
                score++;
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + quizQuestions.length);
    }

    private static QuizQuestion[] setupQuiz() {
        QuizQuestion[] quizQuestions = {
            new QuizQuestion("What is the capital of France?", new String[]{"London", "Paris", "Berlin", "Madrid"}, 1),
            new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1),
            new QuizQuestion("What is the chemical symbol for water?", new String[]{"H2O", "O2", "CO2", "NaCl"}, 0)
        };

        return quizQuestions;
    }

    private static boolean presentQuestionWithTimer(QuizQuestion question) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                System.exit(0);
            }
        };

        System.out.println("\nQuestion: " + question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        timer.schedule(task, TIME_LIMIT * 1000);

        int userAnswerIndex = -1;
        try {
            System.out.print("\nEnter your answer (1-" + options.length + "): ");
            userAnswerIndex = scanner.nextInt() - 1;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number between 1 and " + options.length);
            scanner.next(); // Clear the invalid input
        }

        timer.cancel();

        if (userAnswerIndex == question.getCorrectOptionIndex()) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("Incorrect! The correct answer was: " + options[question.getCorrectOptionIndex()]);
            return false;
        }
    }
}
