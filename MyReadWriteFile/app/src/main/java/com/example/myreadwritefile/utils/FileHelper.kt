package com.example.myreadwritefile.utils

import android.content.Context
import com.example.myreadwritefile.model.FileModel

object FileHelper {
    fun writeToFile(fileModel: FileModel, context: Context){
        context.openFileOutput(fileModel.filename, Context.MODE_PRIVATE).use {
            it.write(fileModel.data?.toByteArray())
        }
    }

    fun readFromFile(context: Context,filename: String): FileModel{
        val fileModel = FileModel()
        fileModel.filename = filename
        fileModel.data = context.openFileInput(filename).bufferedReader().useLines {
            it.fold(""){ some, text ->
                "$some$text\n"
            }
        }
        return fileModel
    }
}