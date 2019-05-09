package com.parfka.util;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.parfka.ParfkaObject;
import com.parfka.ParseClassName;
import com.parfka.ParfkaRole;
import com.parfka.ParfkaUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseRegistry {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ParseRegistry.class);

	private static final Map<Class<? extends ParfkaObject>, String> classNames =
			new ConcurrentHashMap<Class<? extends ParfkaObject>, String>();

	private static final Map<String, Class<? extends ParfkaObject>> objectTypes =
			new ConcurrentHashMap<String, Class<? extends ParfkaObject>>();

	public static void registerDefaultSubClasses() {
		registerSubclass(ParfkaUser.class);
		registerSubclass(ParfkaRole.class);
	}
	
	public static void unregisterSubclass(String className) {
		objectTypes.remove(className);
	}

	public static void registerSubclass(Class<? extends ParfkaObject> subclass) {

		String className = getClassName(subclass);
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Registering sub class {}", className);
		}
		if (className == null) {
			throw new IllegalArgumentException(
					"No ParseClassName annoation provided on " + subclass);
		}
	    
		if (subclass.getDeclaredConstructors().length > 0) {
			try {
				if (!isAccessible(subclass.getDeclaredConstructor(new Class[0])))
					throw new IllegalArgumentException(
							"Default constructor for " + subclass
									+ " is not accessible.");
			} catch (NoSuchMethodException e) {
				throw new IllegalArgumentException(
						"No default constructor provided for " + subclass);
			}
		}
		
		Class<? extends ParfkaObject> oldValue = (Class<? extends ParfkaObject>) objectTypes.get(className);
	    if ((oldValue != null) && (subclass.isAssignableFrom(oldValue))) {
	      return;
	    }
	    
	    objectTypes.put(className, subclass);

	}

	private static boolean isAccessible(Member m) {
		return (Modifier.isPublic(m.getModifiers()))
				|| ((m.getDeclaringClass().getPackage().getName()
						.equals("com.parse"))
						&& (!Modifier.isPrivate(m.getModifiers())) && (!Modifier
							.isProtected(m.getModifiers())));
	}

	public static String getClassName(Class<? extends ParfkaObject> clazz) {
		String name = (String) classNames.get(clazz);
		if (name == null) {
			ParseClassName info = (ParseClassName) clazz.getAnnotation(ParseClassName.class);
			if (info == null) {
				return null;
			}
			name = info.value();
			classNames.put(clazz, name);
		}
		return name;
	}
	
	public static Class<? extends ParfkaObject> getParseClass(String className) {
		Class<? extends ParfkaObject> value = (Class<? extends ParfkaObject>) objectTypes.get(className);
		return value;
	}
	
}
