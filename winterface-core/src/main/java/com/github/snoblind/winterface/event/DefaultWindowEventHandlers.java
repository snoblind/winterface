package com.github.snoblind.winterface.event;

import com.github.snoblind.winterface.WindowEventHandlers;
import org.w3c.dom.events.EventListener;

public class DefaultWindowEventHandlers implements WindowEventHandlers {

	private EventListener onafterprint;
	private EventListener onunload;

	public EventListener getOnunload() {
		return onunload;
	}

	public void setOnunload(EventListener onunload) {
		this.onunload = onunload;
	}

	public EventListener getOnafterprint() {
		return onafterprint;
	}

	public void setOnafterprint(EventListener onafterprint) {
		this.onafterprint = onafterprint;
	}

	public EventListener getOnbeforeprint() {
		throw new UnsupportedOperationException();
	}

	public void setOnbeforeprint(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnbeforeunload() {
		throw new UnsupportedOperationException();
	}

	public void setOnbeforeunload(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnfullscreenchange() {
		throw new UnsupportedOperationException();
	}

	public void setOnfullscreenchange(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnfullscreenerror() {
		throw new UnsupportedOperationException();
	}

	public void setOnfullscreenerror(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnhashchange() {
		throw new UnsupportedOperationException();
	}

	public void setOnhashchange(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnmessage() {
		throw new UnsupportedOperationException();
	}

	public void setOnmessage(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnoffline() {
		throw new UnsupportedOperationException();
	}

	public void setOnoffline(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnonline() {
		throw new UnsupportedOperationException();
	}

	public void setOnonline(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnpagehide() {
		throw new UnsupportedOperationException();
	}

	public void setOnpagehide(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnpageshow() {
		throw new UnsupportedOperationException();
	}

	public void setOnpageshow(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnpopstate() {
		throw new UnsupportedOperationException();
	}

	public void setOnpopstate(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnresize() {
		throw new UnsupportedOperationException();
	}

	public void setOnresize(EventListener handler) {
		throw new UnsupportedOperationException();
	}

	public EventListener getOnstorage() {
		throw new UnsupportedOperationException();
	}

	public void setOnstorage(EventListener handler) {
		throw new UnsupportedOperationException();
	}
}
