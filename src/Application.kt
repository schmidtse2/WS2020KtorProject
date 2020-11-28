package de.hsflensburg

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

//@Suppress("unused") // Referenced in application.conf
//@kotlin.jvm.JvmOverloads


fun main(args: Array<String>){
    val server = embeddedServer(Netty, commandLineEnvironment(args)).start(wait = true)
}


fun Application.module() {
    install(CallLogging)
    routing {
        get ("/hello") {
            call.respondText("Hello !")
        }
        get ("/bye"){
            call.respondText("Goodbye !")
        }
    }
}

fun Application.myModule(){
    routing {
        get("/test"){
            call.respondText { "This test." }
        }
    }
}

fun Routing.root(){
    get("/"){
        call.respondText("Sweet Home.")
    }
}

