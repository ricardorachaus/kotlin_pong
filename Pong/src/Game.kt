import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage
import javafx.scene.layout.Pane
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle

class Game: Application() {

    companion object {
        val width = 600.0
        val height = 400.0
        val paddleVelocity = 20
    }

    override fun start(stage: Stage) {
        val pane = Pane()
        var scene = Scene(pane, Game.width, Game.height)

        pane.background = Background(BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))

        stage.title = "PONG!!! XD"
        stage.scene = scene
        stage.show()

        val leftPaddlePosition = Vector2(Game.width * 0.05,
                                      Game.height * 0.5 - Game.height * 0.2)
        val rightPaddlePosition = Vector2(Game.width * 0.9,
                                          Game.height * 0.5 - Game.height * 0.2)
        val paddleSize = Vector2(Game.width * 0.05,
                                 Game.height * 0.25)
        val leftPaddle = Paddle(leftPaddlePosition, paddleSize)
        val rightPaddle= Paddle(rightPaddlePosition, paddleSize)

        pane.children.add(leftPaddle)
        pane.children.add(rightPaddle)

        scene.onKeyPressed = EventHandler {
            when (it.code) {
                KeyCode.W -> leftPaddle.translateY -= Game.paddleVelocity
                KeyCode.S -> leftPaddle.translateY += Game.paddleVelocity

                KeyCode.UP -> rightPaddle.translateY -= Game.paddleVelocity
                KeyCode.DOWN -> rightPaddle.translateY += Game.paddleVelocity

                else -> println("Invalid input!!!")
            }
        }
    }

}