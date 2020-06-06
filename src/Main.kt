
val API_URL = js("getApiUrl()") as String

fun main(args: Array<String>) {
    val bookStorePresenter = CoursePresenter()
    val bookStorePage = CoursePage(bookStorePresenter)
    bookStorePage.show()
}
