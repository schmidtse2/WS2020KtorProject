package de.hsflensburg

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.util.pipeline.*
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt

fun main(args: Array<String>): Unit = EngineMain.main(args)

//@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    //Routing

    routing {

        get("/"){
            call.respondText("Welcome :)")
        }

        get("/getSomethingElse"){
            call.respondText("something else")
        }

        get("/user/{username}"){
            val username = call.parameters["username"]
            call.respondText("Username: $username")
        }

        get("/user/settings"){
            call.respondText("Higher quality")
        }


        post("/simplePost"){
            call.respondText("This is a simple Post-Request")
        }

        post("/postVariable"){
            val postValues = call.receiveParameters()
            val post01 = postValues["value01"]
            val post02 = postValues["value02"] ?: "default value"
            call.respondText("Post-Request: Value01 = $post01, Value02 = $post02")
        }

    }

}

