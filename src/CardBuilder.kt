import org.w3c.dom.*
import kotlin.browser.document
import kotlin.browser.window
import kotlin.dom.addClass

class CardBuilder {

    fun build(course: Course): HTMLElement {

        val containerDiv = document.createElement("div") as HTMLDivElement
        val imageDiv = document.createElement("img") as HTMLImageElement
        val titleDiv = document.createElement("div") as HTMLDivElement
        val priceDiv = document.createElement("div") as HTMLDivElement
        val descriptionDiv = document.createElement("div") as HTMLDivElement
        val detailsButton = document.createElement("button") as HTMLButtonElement

        bindDataToCard(course = course,
                imageDiv = imageDiv,
                titleDiv = titleDiv,
                priceDiv = priceDiv,
                descriptionDiv = descriptionDiv,
                detailsButton = detailsButton)

        applyStyle(containerDiv,
                imageDiv = imageDiv,
                titleDiv = titleDiv,
                priceDiv = priceDiv,
                descriptionDiv = descriptionDiv,
                detailsButton = detailsButton)

        containerDiv
                .appendChild(
                        imageDiv,
                        titleDiv,
                        descriptionDiv,
                        priceDiv,
                        detailsButton
                )
        return containerDiv
    }

    private fun Element.appendChild(vararg elements: Element) {
        elements.forEach {
            this.appendChild(it)
        }
    }

    private fun bindDataToCard(course: Course,
                               imageDiv: HTMLImageElement,
                               titleDiv: HTMLDivElement,
                               priceDiv: HTMLDivElement,
                               descriptionDiv: HTMLDivElement,
                               detailsButton: HTMLButtonElement) {

        imageDiv.src = course.coverImageUrl

        titleDiv.innerHTML = course.title
        priceDiv.innerHTML = course.price
        descriptionDiv.innerHTML = course.description
        detailsButton.innerHTML = "details"

        detailsButton.addEventListener("click", {
            window.open(course.url)
        })
    }

    private fun applyStyle(containerElement: HTMLDivElement,
                           imageDiv: HTMLImageElement,
                           titleDiv: HTMLDivElement,
                           priceDiv: HTMLDivElement,
                           descriptionDiv: HTMLDivElement,
                           detailsButton: HTMLButtonElement) {
        containerElement.addClass("card", "card-shadow")
        imageDiv.addClass("cover-image")
        titleDiv.addClass("text-title", "float-left")
        descriptionDiv.addClass("text-description", "float-left")
        priceDiv.addClass("text-price", "float-left")
        detailsButton.addClass("view-details", "ripple", "float-right")
    }

}
