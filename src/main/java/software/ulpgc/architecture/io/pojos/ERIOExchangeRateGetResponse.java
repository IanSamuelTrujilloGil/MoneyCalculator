package software.ulpgc.architecture.io.pojos;

import java.util.Map;

public record ERIOExchangeRateGetResponse(boolean success, String date, Map<String, Double> rates) {
}