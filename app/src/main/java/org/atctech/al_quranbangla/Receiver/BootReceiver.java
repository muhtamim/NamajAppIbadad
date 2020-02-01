package org.atctech.al_quranbangla.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.atctech.al_quranbangla.AlarmManagerUtil;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            AlarmManagerUtil cAlarm = new AlarmManagerUtil();
            cAlarm.initAlarmNotification(context);
        }
    }
}