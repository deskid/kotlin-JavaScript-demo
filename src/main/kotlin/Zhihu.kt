class Zhihu {

    private val request: dynamic = require("request")
    private val api = "https://news-at.zhihu.com/api/4/news/latest"

    fun getLatest(function: (String) -> dynamic) {
        request(api) { error: String?, _, body: String ->
            if (error.isNullOrEmpty()) {
                function(body)
            } else {
                println(error)
            }
        }
    }
}