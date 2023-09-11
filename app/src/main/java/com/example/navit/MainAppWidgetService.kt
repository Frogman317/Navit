package com.example.navit

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService

class MainAppWidgetService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return StackRemoteViewsFactory(this.applicationContext, intent)
    }
}

class StackRemoteViewsFactory(
    private val context: Context,
    intent: Intent
) : RemoteViewsService.RemoteViewsFactory {

    val testData = arrayOf(
        arrayOf("00:00", "05:26", "13:46"),
        arrayOf("23:59", "09:39", "21:36"),
        arrayOf("名古屋", "名古屋", "名古屋"),
        arrayOf("名鉄名古屋本線", "名鉄名古屋本線", "名鉄名古屋本線")
    )
    override fun onCreate() {
    }

    override fun onDataSetChanged() {
    }

    override fun onDestroy() {
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getViewAt(position: Int): RemoteViews {
        return RemoteViews(context.packageName, R.layout.main_app_widget_item).apply {
            setTextViewText(R.id.ride_time, testData[0][position])
            setTextViewText(R.id.drop_off_time, testData[1][position])
            setTextViewText(R.id.last_station_text, testData[2][position])
            setTextViewText(R.id.route_text, testData[3][position])
        }
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

}
