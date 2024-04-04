package com.example.colorsample.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.Spannable
import android.text.SpannableString
import android.text.format.DateFormat
import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.colorsample.SampleMyApp
import com.example.colorsample.utils.DateTimePattern.PATTERN_ABR_MONTH_NAME_WITH_DATE_AND_YEAR
import java.util.Calendar
import java.util.Locale


const val ZERO_STRING = "0"
const val EMPTY_STRING: String = ""
const val SPACE: String = " "
const val ZERO_DOUBLE: Double = 0.0
const val ZERO_FLOAT: Float = 0.0f
const val ZERO_INT: Int = 0

/**
 * Extension function to check if the string value is less than or equal to the provided number.
 */
fun String.shouldLessThenNumber(number: Int): Boolean {
    return this.toFloat() <= number
}

/**
 * Extension function to check if the string value is equal to ZERO_FLOAT.
 */
fun String.IsZERO(): Boolean {
    return this.toFloat() == ZERO_FLOAT
}

/**
 * Extension function to check if the string value is equal to ZERO_INT.
 */
fun String.IsZero(): Boolean {
    return this.toInt() == ZERO_INT
}

/**
 * Extension function to get the string value from Editable, returning an empty string if blank.
 */
fun Editable.getString(): String {
    return if (isBlank()) EMPTY_STRING else toString()
}

/**
 * Extension function to get a non-null or non-blank string value, returning an empty string if null or blank.
 */
fun String?.getDataString(): String {
    return if (isNullOrBlank()) EMPTY_STRING else this
}

/**
 * Extension function to lazily retrieve a ViewModel instance within an AppCompatActivity.
 */
inline fun <reified T : ViewModel> AppCompatActivity.lazyViewModel() = lazy {
    ViewModelProvider(this).get(T::class.java)
}

/**
 * Extension function to load an image into an AppCompatImageView using Glide with progress indicator.
 */
fun AppCompatImageView.loadImage(url: String, error: Int, placeHolder: Int) {
    if (!url.isNullOrBlank()) {
        var circularProgressDrawable = Utils.getCircularProgressDrawable(context)
        circularProgressDrawable.start()
        Glide.with(this)
            .load(url)
            .error(error)
            .timeout(30000)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    circularProgressDrawable.stop()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    circularProgressDrawable.stop()
                    return false
                }
            })
            .placeholder(placeHolder)
            .into(this)
    }
}

/**
 * Function to format timestamp into a string with the provided format.
 */
fun getFormatDate(ts: Long?): String {
    if (ts == null) return ""

    val cal = Calendar.getInstance(Locale.ENGLISH)
    cal.timeInMillis = (ts)?.times(1000L) ?: 0L
    return DateFormat.format(PATTERN_ABR_MONTH_NAME_WITH_DATE_AND_YEAR, cal).toString()
}

/**
 * Extension function to smoothly snap RecyclerView to the specified position.
 */
fun RecyclerView.smoothSnapToPosition(
    position: Int,
    snapMode: Int = LinearSmoothScroller.SNAP_TO_ANY,
) {
    val smoothScroller = object : LinearSmoothScroller(this.context) {
        override fun getVerticalSnapPreference(): Int = snapMode
        override fun getHorizontalSnapPreference(): Int = snapMode
    }
    smoothScroller.targetPosition = position
    layoutManager?.startSmoothScroll(smoothScroller)
}

/**
 * Extension function to set the visibility of a View based on a boolean value.
 */
fun View.setVisible(isVisible: Boolean) {
    visibility = if (isVisible) {
        View.VISIBLE
    } else {
        View.GONE
    }
}

/**
 * Extension function to check network availability using the application context.
 */
fun Context.isNetworkAvailable(): Boolean {
    return Utils.isNetworkAvailable(SampleMyApp.INSTANCE)
}

/**
 * Extension function to create a spannable text with customized spans.
 */
fun String.spannableText(
    start: Int,
    end: Int,
    defaultSpan: CharacterStyle = ForegroundColorSpan(Color.RED),
): SpannableString {
    val mSpannableTitle = SpannableString(this)
    mSpannableTitle.setSpan(
        defaultSpan,
        start, end,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )
    return (mSpannableTitle)
}


