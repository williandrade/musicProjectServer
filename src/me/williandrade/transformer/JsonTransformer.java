package me.williandrade.transformer;

import com.google.gson.Gson;

import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

	@Override
	public String render(Object model) throws Exception {
		return new Gson().toJson(model);
	}

}
