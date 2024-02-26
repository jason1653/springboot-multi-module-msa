package io.jason.configsecurity.filter

import jakarta.servlet.ServletOutputStream
import jakarta.servlet.WriteListener
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpServletResponseWrapper
import java.io.ByteArrayOutputStream
import java.io.CharArrayWriter
import java.io.PrintWriter

class LogginResponseWrapper(response: HttpServletResponse) : HttpServletResponseWrapper(response) {
    private val charWriter = CharArrayWriter()
    private val byteOutputStream = ByteArrayOutputStream()
    private var usedWriter = false
    private var usedOutputStream = false
    override fun getWriter(): PrintWriter {
        usedWriter = true
        return PrintWriter(charWriter)
    }

    override fun getOutputStream(): ServletOutputStream {
        usedOutputStream = true
        return object : ServletOutputStream() {
            override fun write(b: Int) {
                byteOutputStream.write(b)
            }

            override fun isReady(): Boolean {
                return true
            }

            override fun setWriteListener(p0: WriteListener?) {
            }
        }
    }

    fun getResponseData(): String {
        return if (usedWriter) {
            charWriter.toString()
        } else {
            byteOutputStream.toString("UTF-8")
        }
    }
}