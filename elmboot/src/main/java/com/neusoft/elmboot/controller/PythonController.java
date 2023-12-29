package com.neusoft.elmboot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PythonController")
public class PythonController {

    @GetMapping("/deliveryTime")
    public String callPythonScript(@RequestParam("age") Integer age, @RequestParam("rating") Double rating,
            @RequestParam("distance") Double distance, @RequestParam("isPeak") Integer isPeak) {
        // collect Python output
        String res = new String();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python",
                    "D:\\project-summer-2023\\Mlearn\\ML.py", age.toString(), rating.toString(), distance.toString(),
                    isPeak.toString());
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                res = line;
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return res.substring(2, res.length() - 2);
    }
}
