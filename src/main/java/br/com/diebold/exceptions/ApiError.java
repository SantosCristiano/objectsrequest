package br.com.diebold.exceptions;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {
    private String statucCode;
    @JsonFormat(pattern = "dd/MM/yyyy HH:MM:SS")
    private LocalDateTime dataErro;
    private List<String> erros;
}
