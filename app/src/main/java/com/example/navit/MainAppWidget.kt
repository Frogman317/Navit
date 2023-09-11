package com.example.navit

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in [MainAppWidgetConfigureActivity]
 */
class MainAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onDeleted(context: Context, appWidgetIds: IntArray) {
        // When the user deletes the widget, delete the preference associated with it.
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val intent = Intent(context, MainAppWidgetService::class.java)
    val views = RemoteViews(context.packageName, R.layout.main_app_widget).apply{
        setRemoteAdapter(R.id.stack_view,intent)
        setEmptyView(R.id.stack_view, R.id.empty_view)
    }

    appWidgetManager.updateAppWidget(appWidgetId, views)
}