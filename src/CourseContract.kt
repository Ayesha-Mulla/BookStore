interface CourseContract {
    interface View {
        fun showCourses(course: List<Course>)
        fun showLoader()
        fun hideLoader()
    }

    interface Presenter {
        fun attach(view: View)
        fun loadCourses()
    }
}