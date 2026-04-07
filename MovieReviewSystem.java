// Parent class
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

// Child class 1 
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

//  Child class 2 
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

// Main class (entry point) 
public class MovieReviewSystem {

    public static void main(String[] args) {

        CriticReview critic = new CriticReview(
            "Roger Ebert",
            "A brilliant movie with stunning visuals.",
            5,
            "Chicago Sun-Times"
        );

        AudienceReview audience = new AudienceReview(
            "John",
            "Really enjoyed it, watched it twice!",
            4,
            "Netflix"
        );

        System.out.println("---- Critic Review ----");
        critic.display();

        System.out.println();

        System.out.println("---- Audience Review ----");
        audience.display();
    }
}
