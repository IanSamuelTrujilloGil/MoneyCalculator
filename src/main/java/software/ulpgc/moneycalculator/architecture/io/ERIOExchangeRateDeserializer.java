package software.ulpgc.moneycalculator.architecture.io;

import com.google.gson.Gson;
import software.ulpgc.moneycalculator.architecture.io.pojos.ERIOExchangeRateGetResponse;

public class ERIOExchangeRateDeserializer implements ExchangeRateDeserializer{
    @Override
    public Object deserialize(String json) {
        return new Gson().fromJson(json, ERIOExchangeRateGetResponse.class);
    }
}
