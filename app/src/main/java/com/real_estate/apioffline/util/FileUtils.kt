package com.real_estate.apioffline.util


import android.content.Context
import android.os.Environment
import androidx.core.content.ContextCompat
import java.io.File

object FileUtils {

    fun getPdfNameFromAssets(): String {
        return "MindOrks_Android_Online_Professional_Course-Syllabus.pdf"
    }

    fun getPdfUrl(): String {
        return "https://docs.google.com/viewer?a=v&pid=sites&srcid=ZGVmYXVsdGRvbWFpbnx5b3V0aGJhbGFuamlrYXxneDo1ZTdkNzJiZTM0ZTMwOGQ1"
    }

    fun getRootDirPath(context: Context): String {
        return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
            val file: File = ContextCompat.getExternalFilesDirs(
                context.applicationContext,
                null
            )[0]
            file.absolutePath
        } else {
            context.applicationContext.filesDir.absolutePath
        }
    }

}