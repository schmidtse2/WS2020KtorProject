package de.hsflensburg

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.sessions.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

data class Student(val name: String, val matriculationNumber: Number)
data class Students(val value: List<Student>)

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
                    Student("Alexander Kaiser", 123456),
                    Student("Andre Müller", 456789),
                    Student("Tilman Haß", 987654),
                    Student("Torge Jensen", 100000),

                ))
            )

//            call.sessions.set(Students(listOf("sdaf", "sdaf", "sdaf")))

            headers.entries().forEach {
                html += "${it.key}: ${it.value}\n"
            }
            call.respondText(html)
        }
        get ("/cookies") {
            val get = call.sessions.get<Students>()
            call.respondText(get?.value?.get(0)?.name.orEmpty())
        }
    }
}

