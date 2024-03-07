package com.example.taksone.utils.mapper;

import com.example.taksone.dto.ConfigurationReadDto;
import com.example.taksone.dto.ConfigurationReqDto;
import com.example.taksone.model.Configuration;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class ConfigurationMapper {

    /**
     * Converts a Configuration entity to a ConfigurationReadDto
     * @param model the Configuration entity to convert
     * @return The converted ConfigurationReadDto
     */

    public ConfigurationReadDto toDto(Configuration model){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        String formattedDate = model.getCreationDate().format(formatter);
        return new ConfigurationReadDto(model.getConfiguration(),formattedDate);
    }

}
