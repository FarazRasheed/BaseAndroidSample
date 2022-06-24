package com.yap.yappk.base

import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader

object ReadAssetFile {
    @Throws(IOException::class)
    fun readJsonFile(fileName: String): String {
        val br =
            BufferedReader(InputStreamReader(FileInputStream("../yappk/src/main/assets/$fileName")))
        val sb = StringBuilder()
        var line: String? = br.readLine()
        while (line != null) {
            sb.append(line)
            line = br.readLine()
        }
        return sb.toString()
    }
}