package com.marianpekar.teapp.activities

import android.app.Application
import com.posthog.android.PostHogAndroid
import com.posthog.android.PostHogAndroidConfig

class MyApp : Application() {

    companion object {
        const val POSTHOG_API_KEY = "phc_pQ70jJhZKHRvDIL5ruOErnPy6xiAiWCqlL4ayELj4X8"
        // usually 'https://app.posthog.com' or 'https://eu.posthog.com'
        const val POSTHOG_HOST = "https://app.posthog.com"
    }

    override fun onCreate() {
        super.onCreate()

        val config = PostHogAndroidConfig(
            apiKey = POSTHOG_API_KEY,
            host = POSTHOG_HOST,
        )
        config.sessionReplay = true
        config.debug = true
        config.sessionReplayConfig.maskAllImages = false
        config.sessionReplayConfig.maskAllTextInputs = false
        config.flushAt = 1
        PostHogAndroid.setup(this, config)
    }
}