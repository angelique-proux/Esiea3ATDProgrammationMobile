package com.example.esiea3atd1

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage




class NotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.notification != null) {
            // 1 - Get message sent by Firebase
            val message = remoteMessage.notification!!.body
            //2 - Show message in console
            Log.e("TAG", message!!)
        }
    }
}