/**
 * adding modules from Node.
 */
external fun require(module: String): dynamic

fun main(args: Array<String>) {
    println("Hello Kotlin and JavaScript!")

    val express = require("express")
    val app = express()
    val zhihu = Zhihu()

    app.get("/", { _, res ->
        res.type("application/json")
        zhihu.getLatest {
            res.send(it)
        }
    })

    app.listen(3000, {
        println("Listening on port 3000")
    })
}