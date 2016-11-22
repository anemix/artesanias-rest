package co.edu.uelbosque.software.entities;

/**
 * Created by david on 16/11/16.
 */
public class PayuRequest {

    private String response_code_pol;

    public String getResponse_code_pol() {
        return response_code_pol;
    }

    public void setResponse_code_pol(String response_code_pol) {
        this.response_code_pol = response_code_pol;
    }

    @Override
    public String toString() {
        return "PayuRequest{" +
                "response_code_pol='" + response_code_pol + '\'' +
                '}';
    }
}
