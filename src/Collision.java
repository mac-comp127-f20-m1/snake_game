import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Point;

public class Collision {

    private Snake snake;

    private FoodManager foodPieces;

    private WallManager wallManager;

    private GraphicsGroup group;


    /**
     * 
     * Tests for distance between the snake and the food, returning true if the two are
     * close. Can add collisions for walls and passages to to other side of screen 
     * later.
     * 
     */

    public Collision (Snake snake, FoodManager foodPieces, WallManager wallManager, GraphicsGroup group) {
        this.foodPieces = foodPieces;
        this.snake = snake;
        this.wallManager = wallManager;
        this.group = group;
    }

    public boolean eatsFood() {
        Point leftEye = snake.snakeEyes().get(0);
        Point rightEye = snake.snakeEyes().get(1);

        if (foodPieces.getElementAt(leftEye) == null && 
                    foodPieces.getElementAt(rightEye) == null){
            return false;
        }
        else if (foodPieces.getElementAt(leftEye) != null) {
            foodPieces.remove(foodPieces.getElementAt(leftEye));
            return true;
        }
        else {
            foodPieces.remove(foodPieces.getElementAt(rightEye));
            return true;
        }
    }

    public boolean eatsFood2() {
        Point leftEye = snake.snakeEyes().get(0);
        Point rightEye = snake.snakeEyes().get(1);

        if (foodPieces.getElementAt(leftEye) == null && 
                    foodPieces.getElementAt(rightEye) == null){
            return false;
        }
        else if (foodPieces.getElementAt(leftEye) != null) {
            return true;
        }
        else if (foodPieces.getElementAt(rightEye) != null) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Checks to see if the snake collides with a wall
     */
    public boolean wallCollision() {
        Point leftEye = snake.snakeEyes().get(0);
        Point rightEye = snake.snakeEyes().get(1);

        if (wallManager.getElementAt(leftEye) == null && 
                    wallManager.getElementAt(rightEye) == null){
            return false;
        }
        else if (wallManager.getElementAt(leftEye) != null) {
            return true;
        }
        else if (wallManager.getElementAt(rightEye) != null) {
            return true;
        }
        return false;
    }
    /**
     * Checks to see if the snake collides with its tail
     */
    public boolean snakeCollision() {
        Point leftEye = snake.snakeEyes().get(0);
        Point rightEye = snake.snakeEyes().get(1);

        if (group.getElementAt(leftEye) instanceof Segments) {
            return true;
        }
        else if (group.getElementAt(rightEye) instanceof Segments) {
            return true;
        }
        else {
            return false;
        }
    }
}
