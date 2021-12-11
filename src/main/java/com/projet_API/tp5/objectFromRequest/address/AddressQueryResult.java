package com.projet_API.tp5.objectFromRequest.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressQueryResult {

	@JsonProperty
	private AddressFeatureData[] features;

	public AddressQueryResult() {}

	public AddressFeatureData[] getFeatures() {
		return features;
	}
	public void setFeatures(AddressFeatureData[] features) {
		this.features = features;
	}
}
