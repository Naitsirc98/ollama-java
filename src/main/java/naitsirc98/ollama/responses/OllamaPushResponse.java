package naitsirc98.ollama.responses;

public class OllamaPushResponse extends OllamaResponse {

	private String status;
	private String digest;
	private long total;
	private long completed;

	public String status() {
		return status;
	}

	public String digest() {
		return digest;
	}

	public long total() {
		return total;
	}

	public long completed() {
		return completed;
	}
}
