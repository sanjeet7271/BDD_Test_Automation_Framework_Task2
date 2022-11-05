package com.userdto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "results", "info" })
public class User {
	@JsonProperty("results")
	private List<Results> results = null;
	@JsonProperty("info")
	private Info info;

	@JsonProperty("results")
	public List<Results> getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(List<Results> results) {
		this.results = results;
	}

	@JsonProperty("info")
	public Info getInfo() {
		return info;
	}

	@JsonProperty("info")
	public void setInfo(Info info) {
		this.info = info;
	}

}