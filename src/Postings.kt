package de.hsflensburg

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.postings(){
    routing{
        get("/po"){
            call.respondText("This is the Postings Site")
        }
        post { TODO() }
    }
}