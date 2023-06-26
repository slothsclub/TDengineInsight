package org.slothsclub.tdengineinsight.bind;


public enum ResponseCode {

    SUCCESS("SUCCESS"),
    DATASOURCE_NOT_FOUND("Data source not initialized"),

    UNPROCESSABLE_ENTITY("Unprocessable Entity"),
    BAD_REQUEST("Bad Request"),
    NOT_FOUND("Not Found"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    ;

    private final String description;

    ResponseCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
