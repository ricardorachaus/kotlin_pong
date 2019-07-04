import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.stage.Stage
import javafx.scene.layout.Pane
import kotlin.concurrent.thread
import javafx.event.EventHandler
import javafx.scene.input.KeyEvent

class Game: Application() {

    override fun start(stage: Stage) {
        val pane = Pane()
        val button = Button("Paddle")
        var scene = Scene(pane, 600.0, 400.0)

        pane.children.add(button)

        stage.title = "PONG!!! XD"
        stage.scene = scene
        stage.show()

        val thread = Thread {
            for (i in 1..30) {
                button.translateY += 10
                Thread.sleep(100)
            }
        }
        thread.start()

        button.onKeyPressed = EventHandler {
            print(it.code)
        }
    }

}