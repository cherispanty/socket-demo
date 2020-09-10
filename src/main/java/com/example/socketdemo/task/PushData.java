package com.example.socketdemo.task;

import com.example.socketdemo.server.WebSocketServer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author linchong
 * @date 2020/9/10 11:00
 */
@Component
//@Configuration
public class PushData {

    @Scheduled(cron = "*/3 * * * * ?")
    @Async
    public void pushTask() throws IOException {
        CopyOnWriteArraySet<WebSocketServer> webSocketSet = WebSocketServer.webSocketSet;
        //定时
        for (WebSocketServer ws: webSocketSet) {
            ws.sendMessage(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        }
    }
}
