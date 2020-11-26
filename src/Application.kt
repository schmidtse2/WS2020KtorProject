package de.hsflensburg

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

//@Suppress("unused") // Referenced in application.conf
//@kotlin.jvm.JvmOverloads

fun Application.module() {
    install(CallLogging)
    routing {
        get ("/hello") {
            call.respondText("Hellooo Worlds!")
        }
        get ("/bye"){
            call.respondText("Goodbye miserable World!")
        }
    }
}

