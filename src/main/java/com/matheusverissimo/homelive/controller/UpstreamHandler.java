package com.matheusverissimo.homelive.controller;

import java.io.IOException;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class UpstreamHandler extends BinaryWebSocketHandler{
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Emissor conectado: " + session.getRemoteAddress());
		session.sendMessage(new TextMessage("Conectado ao upstream handler ws!"));
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		session.close();
	}
	
	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
	}
	
	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		DownStreamHandler.sessionList.parallelStream().forEach(s -> {
			try {
				s.sendMessage(new BinaryMessage(message.getPayload()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
