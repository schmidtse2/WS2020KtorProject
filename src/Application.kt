package de.hsflensburg

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

//@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val server = embeddedServer(Netty, port = 8080) {
        routing {
            get ("/") {
                call.respondText("Hello World!")
            }
        }
    }
}

