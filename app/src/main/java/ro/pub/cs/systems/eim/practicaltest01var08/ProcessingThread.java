package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Context;
import android.content.Intent;

import java.util.Date;
import java.util.Random;

public class ProcessingThread extends Thread {
    private final String answer;
    private final Context context;

    public ProcessingThread(Context context, String answer) {
        this.context = context;
        this.answer = answer;
    }


    @Override
    public void run() {
        while (true) {
            sendMessage();
            sleep();
        }
    }

    private void sleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void sendMessage() {
        Intent intent = new Intent();
        intent.setAction("action");

        String hint = new String(new char[answer.length()]). replace("\0", "*");

        Random random = new Random();
        int index = random.nextInt(answer.length());
        hint = hint.substring(0, index) + answer.charAt(index) + hint.substring(index + 1);

        intent.setAction(Constants.hintService);
        intent.putExtra("message", hint);
        context.sendBroadcast(intent);
    }
}
