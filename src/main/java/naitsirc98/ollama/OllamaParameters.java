package naitsirc98.ollama;

import java.util.*;

public interface OllamaParameters<Self extends OllamaParameters<Self>> {

	default Integer numGpu() {
		return parameter("num_gpu");
	}

	/**
	 * Indicates to llama.cpp how many GPUs are available.
	 * 0 disables GPU usage. Values greater than 1 may increase VRAM usage and risk OOM errors.
	 */
	default Self numGpu(Integer numGpu) {
		return parameter("num_gpu", numGpu);
	}

	default Integer mirostat() {
		return parameter("mirostat");
	}

	/**
	 * Enable Mirostat sampling for controlling perplexity.
	 * 0 = disabled, 1 = Mirostat, 2 = Mirostat 2.0
	 */
	default Self mirostat(Integer mirostat) {
		return parameter("mirostat", mirostat);
	}

	default Double mirostatEta() {
		return parameter("mirostat_eta");
	}

	/**
	 * Learning rate for Mirostat.
	 * Lower values react slower, higher values react faster. (Default: 0.1)
	 */
	default Self mirostatEta(Double mirostatEta) {
		return parameter("mirostat_eta", mirostatEta);
	}

	default Double mirostatTau() {
		return parameter("mirostat_tau");
	}

	/**
	 * Target entropy for Mirostat.
	 * Lower values produce more focused text. (Default: 5.0)
	 */
	default Self mirostatTau(Double mirostatTau) {
		return parameter("mirostat_tau", mirostatTau);
	}

	default Integer numCtx() {
		return parameter("num_ctx");
	}

	/**
	 * Context window size. (Default: 2048)
	 */
	default Self numCtx(Integer numCtx) {
		return parameter("num_ctx", numCtx);
	}

	default Integer repeatLastN() {
		return parameter("repeat_last_n");
	}

	/**
	 * Number of previous tokens to consider for repetition penalty.
	 * 0 = disabled, -1 = num_ctx (Default: 64)
	 */
	default Self repeatLastN(Integer repeatLastN) {
		return parameter("repeat_last_n", repeatLastN);
	}

	default Double repeatPenalty() {
		return parameter("repeat_penalty");
	}

	/**
	 * Strength of repetition penalty. (Default: 1.1)
	 */
	default Self repeatPenalty(Double repeatPenalty) {
		return parameter("repeat_penalty", repeatPenalty);
	}

	default Integer numKeep() {
		return parameter("num_keep");
	}

	/**
	 * Number of tokens to retain when context is shifted.
	 */
	default Self numKeep(Integer numKeep) {
		return parameter("num_keep", numKeep);
	}

	default Integer numThread() {
		return parameter("num_thread");
	}

	/**
	 * Number of CPU threads used for inference.
	 */
	default Self numThread(Integer numThread) {
		return parameter("num_thread", numThread);
	}

	default Integer numBatch() {
		return parameter("num_batch");
	}

	/**
	 * Batch size for token processing.
	 */
	default Self numBatch(Integer numBatch) {
		return parameter("num_batch", numBatch);
	}

	default Double temperature() {
		return parameter("temperature");
	}

	/**
	 * Sampling temperature. Higher values increase creativity. (Default: 0.8)
	 */
	default Self temperature(Double temperature) {
		return parameter("temperature", temperature);
	}

	default Integer seed() {
		return parameter("seed");
	}

	default String template() {
		return parameter("template");
	}

	default Self template(String template) {
		return parameter("template", template);
	}

	/**
	 * Random seed for deterministic output. (Default: 0)
	 */
	default Self seed(Integer seed) {
		return parameter("seed", seed);
	}

	default List<String> stop() {
		String[] stop = parameter("stop");
		return stop == null ? null : Arrays.asList(stop);
	}

	/**
	 * Stop sequences that end generation.
	 */
	default Self stop(Collection<String> stop) {
		return parameter("stop", stop == null ? null : stop.toArray(String[]::new));
	}

	/**
	 * Stop sequences that end generation.
	 */
	default Self stop(String... stop) {
		return stop(stop == null ? null : Arrays.asList(stop));
	}

	default Double tfsZ() {
		return parameter("tfs_z");
	}

	/**
	 * Tail-free sampling parameter. 1.0 disables it. (Default: 1.0)
	 */
	default Self tfsZ(Double tfsZ) {
		return parameter("tfs_z", tfsZ);
	}

	default Integer numPredict() {
		return parameter("num_predict");
	}

	/**
	 * Maximum number of tokens to generate.
	 * -1 = infinite, -2 = fill context (Default: 128)
	 */
	default Self numPredict(Integer numPredict) {
		return parameter("num_predict", numPredict);
	}

	default Integer topK() {
		return parameter("top_k");
	}

	/**
	 * Top-k sampling. Lower values are more conservative. (Default: 40)
	 */
	default Self topK(Integer topK) {
		return parameter("top_k", topK);
	}

	default Double topP() {
		return parameter("top_p");
	}

	/**
	 * Nucleus sampling probability. (Default: 0.9)
	 */
	default Self topP(Double topP) {
		return parameter("top_p", topP);
	}

	default Double minP() {
		return parameter("min_p");
	}

	/**
	 * Minimum probability relative to the most likely token. (Default: 0.0)
	 */
	default Self minP(Double minP) {
		return parameter("min_p", minP);
	}

	default Double typicalP() {
		return parameter("typical_p");
	}

	/**
	 * Typical sampling parameter. (Default: 1.0)
	 */
	default Self typicalP(Double typicalP) {
		return parameter("typical_p", typicalP);
	}

	default Double presencePenalty() {
		return parameter("presence_penalty");
	}

	/**
	 * Penalizes tokens that already appeared at least once.
	 */
	default Self presencePenalty(Double presencePenalty) {
		return parameter("presence_penalty", presencePenalty);
	}

	default Double frequencyPenalty() {
		return parameter("frequency_penalty");
	}

	/**
	 * Penalizes tokens proportionally to how often they appeared.
	 */
	default Self frequencyPenalty(Double frequencyPenalty) {
		return parameter("frequency_penalty", frequencyPenalty);
	}

	default Boolean penalizeNewline() {
		return parameter("penalize_newline");
	}

	/**
	 * Whether to penalize newline tokens. (Default: true)
	 */
	default Self penalizeNewline(Boolean penalizeNewline) {
		return parameter("penalize_newline", penalizeNewline);
	}

	default Object think() {
		return parameter("think");
	}

	/**
	 * Use this capability to audit model steps, animate the model thinking in a UI, or hide the trace entirely when you only need the final response.
	 * Set the think field on chat or generate requests. Most models accept booleans. GPT-OSS models expects one of low, medium, or high to tune the trace length.
	 * */
	default Self think(Object think) {
		return parameter("think", think);
	}

	Map<String, Object> parametersMap();

	@SuppressWarnings("unchecked")
	default <T> T parameter(String name) {
		return (T) parametersMap().get(name);
	}

	default Self parameter(String name, Object value) {
		if (value == null) {
			parametersMap().remove(name);
		} else {
			parametersMap().put(name, value);
		}
		return self();
	}

	@SuppressWarnings("unchecked")
	default Self self() {
		return (Self) this;
	}
}
