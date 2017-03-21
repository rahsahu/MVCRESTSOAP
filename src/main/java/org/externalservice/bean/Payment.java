package org.externalservice.bean;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"senderAccount",
"receiverAccount",
"dollars"
})
public class Payment {

@JsonProperty("senderAccount")
private String senderAccount;
@JsonProperty("receiverAccount")
private String receiverAccount;
@JsonProperty("dollars")
private String dollars;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("senderAccount")
public String getSenderAccount() {
return senderAccount;
}

@JsonProperty("senderAccount")
public void setSenderAccount(String senderAccount) {
this.senderAccount = senderAccount;
}

@JsonProperty("receiverAccount")
public String getReceiverAccount() {
return receiverAccount;
}

@JsonProperty("receiverAccount")
public void setReceiverAccount(String receiverAccount) {
this.receiverAccount = receiverAccount;
}

@JsonProperty("dollars")
public String getDollars() {
return dollars;
}

@JsonProperty("dollars")
public void setDollars(String dollars) {
this.dollars = dollars;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}