package com.chatbot_justice.dailogflow;

import java.util.List;

public class DialogflowResponse {
	private String responseId;
	private QueryResult queryResult;

	// Getters and setters
	public String getResponseId() {
		return responseId;
	}

	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public QueryResult getQueryResult() {
		return queryResult;
	}

	public void setQueryResult(QueryResult queryResult) {
		this.queryResult = queryResult;
	}

	public static class QueryResult {
		private String queryText;
		private Parameters parameters;
		private boolean allRequiredParamsPresent;
		private String fulfillmentText;
		private List<FulfillmentMessage> fulfillmentMessages;
		private Intent intent;
		private float intentDetectionConfidence;
		private String languageCode;

		// Getters and setters
		public String getQueryText() {
			return queryText;
		}

		public void setQueryText(String queryText) {
			this.queryText = queryText;
		}

		public Parameters getParameters() {
			return parameters;
		}

		public void setParameters(Parameters parameters) {
			this.parameters = parameters;
		}

		public boolean isAllRequiredParamsPresent() {
			return allRequiredParamsPresent;
		}

		public void setAllRequiredParamsPresent(boolean allRequiredParamsPresent) {
			this.allRequiredParamsPresent = allRequiredParamsPresent;
		}

		public String getFulfillmentText() {
			return fulfillmentText;
		}

		public void setFulfillmentText(String fulfillmentText) {
			this.fulfillmentText = fulfillmentText;
		}

		public List<FulfillmentMessage> getFulfillmentMessages() {
			return fulfillmentMessages;
		}

		public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
			this.fulfillmentMessages = fulfillmentMessages;
		}

		public Intent getIntent() {
			return intent;
		}

		public void setIntent(Intent intent) {
			this.intent = intent;
		}

		public float getIntentDetectionConfidence() {
			return intentDetectionConfidence;
		}

		public void setIntentDetectionConfidence(float intentDetectionConfidence) {
			this.intentDetectionConfidence = intentDetectionConfidence;
		}

		public String getLanguageCode() {
			return languageCode;
		}

		public void setLanguageCode(String languageCode) {
			this.languageCode = languageCode;
		}
	}

	public static class Parameters {
		// This class is empty in your example, but you can add fields if needed
	}

	public static class FulfillmentMessage {
		private Text text;

		// Getters and setters
		public Text getText() {
			return text;
		}

		public void setText(Text text) {
			this.text = text;
		}

		public static class Text {
			private List<String> text;

			// Getters and setters
			public List<String> getText() {
				return text;
			}

			public void setText(List<String> text) {
				this.text = text;
			}
		}
	}

	public static class Intent {
		private String name;
		private String displayName;

		// Getters and setters
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
	}
}
