package de.hsflensburg

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.routing.*
import io.netty.handler.codec.DefaultHeaders
import kotlinx.coroutines.delay

fun Application.home(){
    //install(CallLogging)
    routing{
        root()
    }
}