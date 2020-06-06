import org.w3c.dom.HTMLDivElement
import kotlin.browser.document

class CoursePage(private val presenter: CourseContract.Presenter) : CourseContract.View {

    private val loader = document.getElementById("loader") as HTMLDivElement
    private val content = document.getElementById("content") as HTMLDivElement
    private val cardBuilder = CardBuilder()

    override fun showCourses(course: List<Course>) {
        course.forEach { course ->
            val card = cardBuilder.build(course)
            content.appendChild(card)
        }
    }

    override fun showLoader() {
        loader.style.visibility = "visible"
    }

    override fun hideLoader() {
        loader.style.visibility = "hidden"
    }

    fun show() {
        presenter.attach(this)
        presenter.loadCourses()
    }

}