package de.hsflensburg

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.sessions.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

data class Students(val matriculationNumber: List<Number>)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Sessions) {
        cookie<Students>("SESSION")
    }
    routing {
        get("/") {
            call.sessions.set(Students(
                    listOf(123, 1654, 378923)
            ))
            call.respond("Session Beispiel")
        }
        get("/session") {
            val session = call.sessions.get<Students>()
            call.respondText(session?.matriculationNumber.toString())
        }
    }
}

