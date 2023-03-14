package com.matheusverissimo.homelive.controller;

import java.io.IOException;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class VideoHandler extends BinaryWebSocketHandler{

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		session.sendMessage(new TextMessage("Olaa!"));
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	}
	
	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
	}
	
	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {

		try {
			System.out.println(message.getPayload());
			session.sendMessage(new TextMessage("Hello World"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
