package naitsirc98.ollama.responses;

import com.google.gson.Gson;

import java.io.Serializable;

public class OllamaResponse implements Serializable {

	public static <T extends OllamaResponse> T fromJson(String json, Class<T> type) {
		return new Gson().fromJson(json, type);
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

	@Override
	public String toString() {
		return toJson();
	}
}
