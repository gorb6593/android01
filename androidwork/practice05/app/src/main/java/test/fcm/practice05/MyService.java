package test.fcm.practice05;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG,"onCreate() 호출됨.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"StartCommand() 호출됨.");

        if(intent==null){
            return Service.START_STICKY;
        }else{
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent){
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG,"command:"+command+",name :"+name);

        for (int i=0; i<5; i++){
            try{
                Thread.sleep(1000);
            }catch (Exception e){}
            Log.d(TAG, "wating"+i+"seconds.");
        }
        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
        //showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | I
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}