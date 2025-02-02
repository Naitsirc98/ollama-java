package naitsirc98.ollama.tools;

import com.google.gson.Gson;

public class OllamaTool {

	public static OllamaTool of(OllamaFunction function) {
		return new OllamaTool(Type.function, function);
	}

	private Type type;
	private OllamaFunction function;

	public OllamaTool(Type type, OllamaFunction function) {
		this.type = type;
		this.function = function;
	}

	public Type type() {
		return type;
	}

	public OllamaTool type(Type type) {
		this.type = type;
		return this;
	}

	public OllamaFunction function() {
		return function;
	}

	public OllamaTool function(OllamaFunction function) {
		this.function = function;
		return this;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}

	public enum Type {
		function
	}
}
