package com.michaeljordanr.memesounds

import android.content.ContentProvider
import android.content.ContentValues
import android.content.res.AssetFileDescriptor
import android.database.Cursor
import android.net.Uri
import android.os.CancellationSignal
import java.io.FileNotFoundException
import java.io.IOException

class AssetsProvider : ContentProvider() {

    @Throws(FileNotFoundException::class)
    override fun openAssetFile(uri: Uri, mode: String): AssetFileDescriptor? {
        val am = context!!.assets
        val fileName = uri.lastPathSegment ?: throw FileNotFoundException()
        var afd: AssetFileDescriptor? = null
        try {
            afd = am.openFd(fileName)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return afd
    }

    override fun getType(p1: Uri): String? {
        return null
    }

    override fun delete(p1: Uri, p2: String?, p3: Array<String>?): Int {
        return 0
    }

    override fun query(p1: Uri, p2: Array<String>?, p3: String?, p4: Array<String>?, p5: String?): Cursor? {
        return null
    }

    override fun insert(p1: Uri, p2: ContentValues?): Uri? {
        return null
    }

    override fun onCreate(): Boolean {
        return false
    }

    override fun update(p1: Uri, p2: ContentValues?, p3: String?, p4: Array<String>?): Int {
        return 0
    }
}