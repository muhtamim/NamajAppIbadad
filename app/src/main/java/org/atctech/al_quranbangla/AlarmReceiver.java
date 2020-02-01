package org.atctech.al_quranbangla;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.WakefulBroadcastReceiver;

import java.util.Calendar;


public class AlarmReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        AlarmManagerUtil alarmUtil = new AlarmManagerUtil();
        alarmUtil.initAlarmNotification(context);
        createNotification(context, 1);
    }

    private static PendingIntent criarPendingIntent(
            Context ctx, int id) {
        Intent resultIntent = new Intent(ctx, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        return stackBuilder.getPendingIntent(id, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static void createNotification(Context ctx, int id) {

        Bitmap largeIcon = BitmapFactory.decodeResource(
                ctx.getResources(), R.drawable.ilme_shifa_logo);

        PendingIntent pitNotificacao = criarPendingIntent(ctx, id);


        Calendar calendar = Calendar.getInstance();

        String notificationName;
        String notificationText;
        MediaPlayer mediaPlayer ;

        if (calendar.get(Calendar.HOUR_OF_DAY) == 2 && calendar.get(Calendar.MINUTE)<=29)
        {
            notificationName = "সেহেরি রান্নার আওয়াজ";
            notificationText = "সেহেরি রান্নার সময় হয়ে গিয়েছে";
            mediaPlayer = MediaPlayer.create(ctx, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
            mediaPlayer.start();

        }else if(calendar.get(Calendar.HOUR_OF_DAY) ==3 && calendar.get(Calendar.MINUTE)<=44)
        {
            notificationName = "সতর্কতা";
            notificationText = "আপনার সেহেরির সময় আর কম বেশি 20 মিনিট এর মত আছে";
            mediaPlayer = MediaPlayer.create(ctx, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
            mediaPlayer.start();
        }else if(calendar.get(Calendar.HOUR_OF_DAY) == 3 && calendar.get(Calendar.MINUTE)<=59)
        {
            notificationName = "আজান";
            notificationText = "এখন ফজরের ওয়াক্ত শুরু হলো, সালাত আদায়ের জন্যে প্রস্তুত হন";
            mediaPlayer = MediaPlayer.create(ctx, R.raw.adhan_fajr);
            mediaPlayer.start();
        }else if(calendar.get(Calendar.HOUR_OF_DAY) ==12 && calendar.get(Calendar.MINUTE)<=59)
        {
            notificationName = "আজান";
            notificationText = "এখন যোহরের ওয়াক্ত শুরু হলো, সালাত আদায়ের জন্যে প্রস্তুত হন";
            mediaPlayer = MediaPlayer.create(ctx, R.raw.adhan);
            mediaPlayer.start();
        }else if(calendar.get(Calendar.HOUR_OF_DAY) ==16 && calendar.get(Calendar.MINUTE)<=59)
        {
            notificationName = "আজান";
            notificationText = "এখন আছরের ওয়াক্ত শুরু হলো, সালাত আদায়ের জন্যে প্রস্তুত হন";
            mediaPlayer = MediaPlayer.create(ctx, R.raw.adhan);
            mediaPlayer.start();
        }else if(calendar.get(Calendar.HOUR_OF_DAY) ==18 && calendar.get(Calendar.MINUTE)<=59)
        {
            notificationName = "সতর্কতা";
            notificationText = "আপনার ইফতার এর সময় আর কম বেশি 20 মিনিট এর মত আছে";
            mediaPlayer = MediaPlayer.create(ctx, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
            mediaPlayer.start();
        }else if(calendar.get(Calendar.HOUR_OF_DAY) ==18 && calendar.get(Calendar.MINUTE)<=59)
        {
            notificationName = "আজান";
            notificationText = "এখন মাগরিবের ওয়াক্ত শুরু হলো, সালাত আদায়ের জন্যে প্রস্তুত হন";
            mediaPlayer = MediaPlayer.create(ctx, R.raw.adhan);
            mediaPlayer.start();
        }else if(calendar.get(Calendar.HOUR_OF_DAY) ==20 && calendar.get(Calendar.MINUTE)<=59)
        {
            notificationName = "আজান";
            notificationText = "এখন এশার ওয়াক্ত শুরু হলো, সালাত আদায়ের জন্যে প্রস্তুত হন";
            mediaPlayer = MediaPlayer.create(ctx, R.raw.adhan);
            mediaPlayer.start();
        }else
        {
            notificationName="আজান";
            mediaPlayer = MediaPlayer.create(ctx, R.raw.adhan);
            mediaPlayer.start();
            notificationText ="আজান হচ্ছে";
        }

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(ctx)
                        .setSmallIcon(R.drawable.ilme_shifa_logo)
                        .setContentTitle(notificationName)
                        .setContentText(notificationText)
                        .setWhen(System.currentTimeMillis())
                        .setLargeIcon(largeIcon)
                        .setAutoCancel(true)
                        .setContentIntent(pitNotificacao)
                        .setLights(Color.BLUE, 1000, 5000)
                        .setVibrate(new long[]{100, 500, 200, 800})
                        .setNumber(id)
                        .setSubText("ধন্যবাদ");

        NotificationManagerCompat nm = NotificationManagerCompat.from(ctx);
        nm.notify(id, mBuilder.build());
    }
}
