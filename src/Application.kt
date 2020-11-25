package de.hsflensburg

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.sessions.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

data class Students(val value: List<Number>)

//@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Sessions) {
        cookie<Students>("SESSION")
    }
    routing {
        get ("/") {
            val headers = call.request.headers
            var html = ""

            call.sessions.set(
                Students(listOf(
                    123456,
                    456789,
                    987654,
                    100000,
                ))
            )

            headers.entries().forEach {
                html += "${it.key}: ${it.value}\n"
            }
            call.respondText(html)
        }
        get ("/cookies") {
            val session = call.sessions.get<Students>()
            call.respondText(session?.value.toString())
        }
    }
}

