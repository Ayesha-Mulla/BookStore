import org.w3c.xhr.XMLHttpRequest

class CoursePresenter : CourseContract.Presenter {
    private lateinit var view: CourseContract.View
    override fun attach(view: CourseContract.View) {
        this.view = view
    }

    override fun loadCourses() {

        view.showLoader()
        getDataAsync(API_URL) { response ->
            val courses = JSON.parse<Array<Course>>(response)
            view.hideLoader()
            view.showCourses(courses.toList())
        }

    }

    private fun getDataAsync(url: String, callback: (String) -> Unit) {
        val xmlHttp = XMLHttpRequest()
        xmlHttp.open("GET", url)
        xmlHttp.onload = {
            if (xmlHttp.readyState == 4.toShort() && xmlHttp.status == 200.toShort()) {
                callback.invoke(xmlHttp.responseText)
            }
        }
        xmlHttp.send()
    }

}
