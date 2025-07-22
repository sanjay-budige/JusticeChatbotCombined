# chatbot-justice
Developing an AI based interactive Chatbot or virtual assistant for the Department of Justice’s Website.


POST  API URL: http://localhost:8080/justice-chatbot

Request Body:
{
    "queryInput": {
        "text": {
            "text": "Appointments Division",
            "languageCode": "en"
        }
    }
}

Response:

{
  "responseId": "df1ea185-3dcb-4089-a9da-ad260289afd7-306ff19d",
  "queryResult": {
    "queryText": "Appointments Division",
    "parameters": {},
    "allRequiredParamsPresent": true,
    "fulfillmentText": "The Appointments Division handles the appointment of judges to the Supreme Court, High Courts, and District/Subordinate Courts.",
    "fulfillmentMessages": [
      {
        "text": {
          "text": [
            "The Appointments Division handles the appointment of judges to the Supreme Court, High Courts, and District/Subordinate Courts."
          ]
        }
      }
    ],
    "intent": {
      "name": "projects/dojchatbot/agent/intents/d1400117-3281-4e85-84b3-118a2bfc8c8c",
      "displayName": "Appointments_Division"
    },
    "intentDetectionConfidence": 0.8115074,
    "languageCode": "en"
  }
}
