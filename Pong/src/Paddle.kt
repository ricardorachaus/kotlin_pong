import javafx.scene.input.KeyEvent
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

class Paddle(val position: Vector2, val size: Vector2): Rectangle(position.x, position.y, size.x, size.y) {

    init {
        fill = Color.WHITE
    }

}

