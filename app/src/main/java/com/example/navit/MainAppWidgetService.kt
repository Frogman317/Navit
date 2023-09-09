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
        TODO("Not yet implemented")
    }

    override fun onDataSetChanged() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getViewAt(position: Int): RemoteViews {
        TODO("Not yet implemented")
        return RemoteViews(context.packageName, R.layout.main_app_widget_item).apply {
            setTextViewText(R.id.widget_item, testData[0][position])
        }
    }

    override fun getLoadingView(): RemoteViews {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItemId(position: Int): Long {
        TODO("Not yet implemented")
    }

    override fun hasStableIds(): Boolean {
        TODO("Not yet implemented")
    }

}
