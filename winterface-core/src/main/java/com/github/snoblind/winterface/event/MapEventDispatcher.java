package com.github.snoblind.winterface.event;

import java.util.HashSet;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;
import static org.apache.commons.lang.Validate.notNull;
import static org.apache.commons.lang.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang.builder.HashCodeBuilder.reflectionHashCode;
import static java.lang.String.format;

public class MapEventDispatcher extends AbstractEventDispatcher {
	
	private final Map<Key, Collection<EventListener>> map;

	public MapEventDispatcher(final Map<Key, Collection<EventListener>> map) {
		notNull(map);
		this.map = map;
	}

	public MapEventDispatcher() {
		this(new HashMap<Key, Collection<EventListener>>());
	}

	public EventListener getEventListener(EventTarget target, String type, boolean useCapture) {
		final Collection<EventListener> listeners = getEventListeners(target, type, useCapture);
		if (listeners.isEmpty()) {
			return null;
		}
		if (listeners.size() > 1) {
			LOGGER.warn("There are {} event listeners for target {}, type {}, and use capture {}.", listeners.size(), target, type, useCapture);
		}
		return listeners.iterator().next();
	}

	public ExtendedEvent createEvent(String eventInterface) {
		if ("Event".equals(eventInterface)) {
			return new DefaultEvent();
		}
		throw new IllegalArgumentException(String.valueOf(eventInterface));
	}

	public void addEventListener(EventTarget target, String type, EventListener listener, boolean useCapture) {
		Key key = new Key(target, type, useCapture);
		Collection<EventListener> listeners = map.get(key);
		if (listeners == null) {
			map.put(key, listeners = new HashSet<EventListener>());
		}
		listeners.add(listener);
	}

	public void removeEventListener(EventTarget target, String type, EventListener listener, boolean useCapture) {
		Key key = new Key(target, type, useCapture);
		Collection<EventListener> list = map.get(key);
		if (list != null) {
			list.remove(listener);
		}
	}

	protected Collection<EventListener> getEventListeners(EventTarget target, String type, boolean useCapture) {
		Key key = new Key(target, type, useCapture);
		Collection<EventListener> listeners = map.get(key);
		if (listeners == null) {
			listeners = Collections.emptyList();
		}
		else {
			listeners = Collections.unmodifiableCollection(listeners);
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(format("%,d event listeners registered for target %s.", listeners.size(), target));
			LOGGER.debug(map.keySet().toString());
		}
		return listeners;
	}

	private static class Key {

		@SuppressWarnings("unused") private final EventTarget target;
		@SuppressWarnings("unused") private final String type;
		@SuppressWarnings("unused") private final boolean useCapture;

		private Key(EventTarget target, String type, boolean useCapture) {
			notNull(this.target = target);
			notNull(this.type = type);
			this.useCapture = useCapture;
		}

		public boolean equals(Object object) {
			return reflectionEquals(this, object);
		}

		public int hashCode() {
			return reflectionHashCode(this);
		}

		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}
}
