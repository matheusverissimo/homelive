package com.matheusverissimo.homelive.controller;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.PongMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class DownStreamHandler extends BinaryWebSocketHandler {

	public static CopyOnWriteArrayList<WebSocketSession> sessionList = new CopyOnWriteArrayList<>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Receptor conectado: " + session.getRemoteAddress());
		DownStreamHandler.sessionList.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		session.close();
	}
	
	@Override
	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
	}
	
	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
	}
}
