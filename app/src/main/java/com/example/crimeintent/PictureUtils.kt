package com.example.crimeintent

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point

fun getScaledBitmap(path: String, activity: Activity): Bitmap {
    val size = Point()
    activity.windowManager.defaultDisplay.getSize(size)

    return getScaledBitmap(path, size.x, size.y)
}

fun getScaledBitmap(path: String, destWidth: Int, destHeight: Int): Bitmap {
    var option = BitmapFactory.Options()
    option.inJustDecodeBounds = true
    BitmapFactory.decodeFile(path, option)

    val srcWidth = option.outWidth.toFloat()
    val srcHeight = option.outHeight.toFloat()

    var inSampleSize = 1
    if (srcHeight > destHeight || srcWidth > destWidth) {
        val heightScale = srcHeight / destHeight
        val widthScale = srcWidth / destWidth

        val sampleScale = if (heightScale > widthScale) {
            heightScale
        } else {
            widthScale
        }
        inSampleSize = Math.round(sampleScale)
    }

    option = BitmapFactory.Options()
    option.inSampleSize = inSampleSize

    return BitmapFactory.decodeFile(path,option)
}