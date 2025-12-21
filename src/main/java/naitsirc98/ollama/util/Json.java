package naitsirc98.ollama.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Json {

	private static final Gson GSON_PRETTY_INSTANCE = new GsonBuilder().setPrettyPrinting().create();
	private static final Gson GSON_INSTANCE = new GsonBuilder().create();

	public static String toJsonPretty(Object obj) {
		return GSON_PRETTY_INSTANCE.toJson(obj);
	}

	public static String toJson(Object obj) {
		return GSON_INSTANCE.toJson(obj);
	}

	public static void toJsonPretty(Object obj, File file) {
		try {
			if(file.getParentFile() != null) file.getParentFile().mkdirs();
			try(FileWriter writer = new FileWriter(file)) {
				GSON_PRETTY_INSTANCE.toJson(obj, writer);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void toJson(Object obj, File file) {
		try {
			if(file.getParentFile() != null) file.getParentFile().mkdirs();
			try(FileWriter writer = new FileWriter(file)) {
				GSON_INSTANCE.toJson(obj, writer);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T fromJson(String json, Class<T> clazz) {
		return GSON_PRETTY_INSTANCE.fromJson(json, clazz);
	}

	public static <T> T fromJson(File file, Class<T> clazz) {
		try(FileReader reader = new FileReader(file)) {
			return GSON_PRETTY_INSTANCE.fromJson(reader, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
