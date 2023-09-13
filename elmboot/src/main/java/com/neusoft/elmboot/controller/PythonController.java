package com.neusoft.elmboot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PythonController")
public class PythonController {

    @RequestMapping("/callPythonScript")
    public String callPythonScript(Integer age, Double rating, Double distance, Integer isPeak) {
        // StringBuilder output = new StringBuilder(); // Create a StringBuilder to collect Python output
        String res = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python",
                    "D:\\project-summer-2023\\Mlearn\\ML.py", age.toString(), rating.toString(), distance.toString(), isPeak.toString());
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                //output.append(line).append("\n"); // Append Python output to the StringBuilder
                res = line;
            }

            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // return output.toString(); // Return the collected Python output
        return res.substring(2, res.length() - 2);
    }
}
