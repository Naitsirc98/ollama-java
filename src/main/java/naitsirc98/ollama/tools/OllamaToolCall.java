package naitsirc98.ollama.tools;

import com.google.gson.Gson;

public class OllamaToolCall {

	private OllamaToolCallFunction function;

	public OllamaToolCall() {
	}

	public OllamaToolCall(OllamaToolCallFunction function) {
		this.function = function;
	}

	public OllamaToolCallFunction function() {
		return function;
	}

	public OllamaToolCall function(OllamaToolCallFunction function) {
		this.function = function;
		return this;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
