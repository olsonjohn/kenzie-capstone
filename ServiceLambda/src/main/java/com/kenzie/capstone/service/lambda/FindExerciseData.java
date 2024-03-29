package com.kenzie.capstone.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kenzie.capstone.service.ExerciseService;
import com.kenzie.capstone.service.dependency.DaggerServiceComponent;
import com.kenzie.capstone.service.dependency.ServiceComponent;
import com.kenzie.capstone.service.model.ExerciseData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class FindExerciseData implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    static final Logger log = LogManager.getLogger();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        log.info(gson.toJson(input));

        ServiceComponent serviceComponent = DaggerServiceComponent.create();
        ExerciseService service = serviceComponent.provideExerciseService();

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);

        String exerciseId = input.getPathParameters().get("exerciseId");

        if(exerciseId == null || exerciseId.isEmpty()){
            return response
                    .withStatusCode(400)
                    .withBody("Id is invalid");
        }

        try{
            ExerciseData exerciseData = service.getExerciseData(exerciseId);
            String output = gson.toJson(exerciseData);

            return response
                    .withStatusCode(200)
                    .withBody(output);
        }catch (Exception e){
            return response
                    .withStatusCode(400)
                    .withBody(gson.toJson(e.getMessage()));
        }

    }
}
