import java.util.Scanner;
import java.util.ArrayList;

// ── Parent class ──────────────────────────────────────
class Review {

    String reviewerName;
    String reviewText;
    int rating;

    public Review(String reviewerName, String reviewText, int rating) {
        this.reviewerName = reviewerName;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public void display() {
        System.out.println("Reviewer : " + reviewerName);
        System.out.println("Review   : " + reviewText);
        System.out.println("Rating   : " + rating + "/5");
    }
}

// ── Child class 1 ─────────────────────────────────────
class CriticReview extends Review {

    String publication;

    public CriticReview(String reviewerName, String reviewText, int rating, String publication) {
        super(reviewerName, reviewText, rating);
        this.publication = publication;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Publication: " + publication);
    }
}

// ── Child class 2 ─────────────────────────────────────
class AudienceReview extends Review {

    String watchedOn;

    public AudienceReview(String reviewerName, String reviewText, int rating, String watchedOn) {
        super(reviewerName, reviewText, rating);
        this.watchedOn = watchedOn;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Watched on : " + watchedOn);
    }
}

// ── Main class ────────────────────────────────────────
public class MovieReviewSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // List to store all reviews
        ArrayList<Review> reviews = new ArrayList<>();
        ArrayList<String> movieNames = new ArrayList<>();

        String choice = "";

        while (!choice.equals("3")) {

            // Menu
            System.out.println("\n=============================");
            System.out.println("   MOVIE REVIEW SYSTEM");
            System.out.println("=============================");
            System.out.println("1. Add a review");
            System.out.println("2. View all reviews");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            // ── Option 1: Add a review ──
            if (choice.equals("1")) {

                System.out.print("\nEnter movie name: ");
                String movieName = scanner.nextLine();

                System.out.print("Are you a critic or audience? (c/a): ");
                String type = scanner.nextLine();

                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                System.out.print("Enter your review: ");
                String reviewText = scanner.nextLine();

                System.out.print("Enter your rating (1-5): ");
                int rating = scanner.nextInt();
                scanner.nextLine(); // clear leftover newline

                if (type.equals("c")) {
                    System.out.print("Enter your publication name: ");
                    String publication = scanner.nextLine();

                    reviews.add(new CriticReview(name, reviewText, rating, publication));

                } else {
                    System.out.print("Where did you watch it? (e.g. Netflix, Theater): ");
                    String watchedOn = scanner.nextLine();

                    reviews.add(new AudienceReview(name, reviewText, rating, watchedOn));
                }

                movieNames.add(movieName);
                System.out.println("\n✔ Review added successfully!");

            // ── Option 2: View all reviews ──
            } else if (choice.equals("2")) {

                if (reviews.isEmpty()) {
                    System.out.println("\nNo reviews yet. Add one first!");
                } else {
                    System.out.println("\n===== ALL REVIEWS =====");
                    for (int i = 0; i < reviews.size(); i++) {
                        System.out.println("\nMovie : " + movieNames.get(i));
                        reviews.get(i).display();
                        System.out.println("-----------------------");
                    }
                }

            // ── Option 3: Exit ──
            } else if (choice.equals("3")) {
                System.out.println("\nGoodbye!");

            } else {
                System.out.println("\nInvalid choice. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}
