/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.devz.config;

import com.devz.model.User;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Ravinath
 */
@Configuration
public class SpringBatchConfig {

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory
    ,StepBuilderFactory stepBuilderFactory
    ,ItemReader<User> itemReader
    ,ItemProcessor<User,User> itemProcessor
    ,ItemWriter<User> itemWriter) {
        
        Step step = stepBuilderFactory.get("ETL-file-load")
                .<User, User>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
        
        Job job =  jobBuilderFactory.get("ETL-load")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
        return job;
    }
}
