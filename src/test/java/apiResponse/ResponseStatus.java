package apiResponse;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {
    boolean status;
    String result;
    int id;
    String errorMessage;
    ErrorFields errorFields;

}
