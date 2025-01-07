package com.indium;

public class DataProcessingEngine {
    public OutputData process(InputData inputData) {
        OutputData outputData = new OutputData();
        //Processing logic goes here
        StringBuilder builder = constructOutputData(inputData);
        outputData.setData(builder.toString());
        return outputData;
    }

    private StringBuilder constructOutputData(InputData inputData) {
        StringBuilder builder = new StringBuilder("");
        builder.append("Firstname,Lastname,Age\n");
        builder.append(inputData.getFirstName());
        builder.append(",");
        builder.append(inputData.getLastName());
        builder.append(",");
        builder.append(inputData.getAge());
        builder.append("\n");
        return builder;
    }
}
