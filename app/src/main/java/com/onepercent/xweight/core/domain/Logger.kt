package com.onepercent.xweight.core.domain

class Logger(
    private val tag: String,
    private val isDebug: Boolean = true
) {

    fun log(message: String) {
        if (!isDebug) {
            // production logging - Crashlytics or w/e you are using
        }
        else {
            printLogD(tag, message)
        }
    }

    private fun printLogD(tag: String, message: String) {
        println("$tag: $message")
    }

    companion object Factory {

        fun buildDebug(tag: String) : Logger {
            return Logger(tag = tag, isDebug = true)
        }

        fun buildRelease(tag: String) : Logger {
            return Logger(tag = tag, isDebug = false)
        }
    }

}

