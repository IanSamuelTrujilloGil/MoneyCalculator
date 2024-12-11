package software.ulpgc.architecture.io;

import com.google.gson.Gson;
import software.ulpgc.architecture.io.pojos.ERIOExchangeRateGetResponse;

public class ERIOExchangeRateDeserializer implements ExchangeRateDeserializer{
    @Override
    public Object deserialize(String json) {
        return new Gson().fromJson(json, ERIOExchangeRateGetResponse.class);
    }
}
