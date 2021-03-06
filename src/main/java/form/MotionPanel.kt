package form

import java.awt.Point
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionAdapter
import javax.swing.JFrame
import javax.swing.JPanel


class MotionPanel(parent: JFrame) : JPanel() {
    private var initialClick: Point? = null

    companion object {
        private const val serialVersionUID = -7809099445700761794L
    }

    init {
        addMouseListener(object : MouseAdapter() {
            override fun mousePressed(e: MouseEvent) {
                initialClick = e.point
                getComponentAt(initialClick)
            }
        })
        addMouseMotionListener(object : MouseMotionAdapter() {
            override fun mouseDragged(e: MouseEvent) {

                // get location of Window
                val thisX = parent.location.x
                val thisY = parent.location.y

                // Determine how much the mouse moved since the initial click
                val xMoved = e.x - initialClick!!.x
                val yMoved = e.y - initialClick!!.y

                // Move window to this position
                val X = thisX + xMoved
                val Y = thisY + yMoved
                parent.setLocation(X, Y)
            }
        })
    }
}