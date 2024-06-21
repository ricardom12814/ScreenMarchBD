package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto){
        OpenAiService service = new OpenAiService("sk-proj-crtozOLG1YcGumzMmTaxT3BlbkFJW2Xk11D7caWP7CU6RVhK");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Traduce al español el siguiente texto: "+texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();
        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();

    }
}