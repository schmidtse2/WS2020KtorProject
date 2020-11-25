package de.hsflensburg

import de.hsflensburg.static
import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.static() {
    routing {
        get("/static"){
            call.respondText("Static Website")
        }
    }
}