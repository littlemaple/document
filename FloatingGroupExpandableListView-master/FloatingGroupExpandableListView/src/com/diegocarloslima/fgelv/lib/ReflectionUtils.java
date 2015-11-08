package com.diegocarloslima.fgelv.lib;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import android.content.Context;
import android.util.Log;

public class ReflectionUtils {

	private static final String	TAG	= ReflectionUtils.class.getName();

	public static Object getFieldValue(Class<?> fieldClass, String fieldName, Object instance) {
		try {
			final Field field = fieldClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(instance);
		}
		catch (Exception e) {
			Log.w(TAG, Log.getStackTraceString(e));
		}
		return null;
	}

	public static void setFieldValue(Class<?> fieldClass, String fieldName, Object instance, Object value) {
		try {
			final Field field = fieldClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(instance, value);
		}
		catch (Exception e) {
			Log.w(TAG, Log.getStackTraceString(e));
		}
	}

	public static Object invokeMethod(Class<?> methodClass, String methodName, Class<?>[] parameters, Object instance, Object... arguments) {
		try {
			final Method method = methodClass.getDeclaredMethod(methodName, parameters);
			method.setAccessible(true);
			return method.invoke(instance, arguments);
		}
		catch (Exception e) {
			Log.w(TAG, Log.getStackTraceString(e));
		}
		return null;
	}

	public static int getLayoutId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "layout", context.getPackageName());
	}

	public static int getStringId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "string", context.getPackageName());
	}

	public static int getDrawableId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "drawable", context.getPackageName());
	}

	public static int getStyleId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "style", context.getPackageName());
	}

	public static int getId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "id", context.getPackageName());
	}

	public static int getColorId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "color", context.getPackageName());
	}

	public static int getArrayId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "array", context.getPackageName());
	}

	public static int getDimenId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "dimen", context.getPackageName());
	}

	public static int getAnimId(Context context, String attribute) {
		return context.getResources().getIdentifier(attribute, "anim", context.getPackageName());
	}
}
