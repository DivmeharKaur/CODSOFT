import java.util.Scanner;

public class QuizApplicationWithTimer {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;

    public static void main(String[] args) {
        QuizQuestion[] quizQuestions = setupQuiz();

        System.out.println("Welcome to the Quiz!");

        for (QuizQuestion question : quizQuestions) {
            presentQuestion(question);
            boolean answeredCorrectly = handleAnswer(question);
            if (answeredCorrectly) {
                score++;
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + quizQuestions.length);

        scanner.close();
    }

    private static QuizQuestion[] setupQuiz() {
        // Define your quiz questions here
        QuizQuestion[] quizQuestions = {
            new QuizQuestion("What is the capital of France?",
                    new String[]{"London", "Paris", "Berlin", "Madrid"}, 1),
            new QuizQuestion("Which planet is known as the Red Planet?",
                    new String[]{"Earth", "Mars", "Jupiter", "Saturn"}, 1),
            // Add more questions as needed
        };

        return quizQuestions;
    }

    private static void presentQuestion(QuizQuestion question) {
        System.out.println("\nQuestion: " + question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private static boolean handleAnswer(QuizQuestion question) {
        System.out.print("\nEnter your answer (1-" + question.getOptions().length + "): ");
        int userAnswerIndex = scanner.nextInt() - 1;

        if (userAnswerIndex >= 0 && userAnswerIndex < question.getOptions().length) {
            if (userAnswerIndex == question.getCorrectOptionIndex()) {
                System.out.println("Correct!");
                return true;
            } else {
                System.out.println("Incorrect! The correct answer was: " +
                        question.getOptions()[question.getCorrectOptionIndex()]);
            }
        } else {
            System.out.println("Invalid option. Please enter a number between 1 and " +
                    question.getOptions().length);
        }

        return false;
    }
}
