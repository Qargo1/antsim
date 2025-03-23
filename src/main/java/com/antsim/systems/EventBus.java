// com/antsim/systems/EventBus.java
package com.antsim.systems;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
public class EventBus {
    private static final Map<Class<?>, List<EventListener>> listeners = new HashMap<>();

    public static <T> void subscribe(Class<T> eventType, EventListener<T> listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public static <T> void publish(T event) {
        List<EventListener> eventListeners = listeners.get(event.getClass());
        if (eventListeners != null) {
            eventListeners.forEach(listener -> listener.handle(event));
        }
    }
}
*/