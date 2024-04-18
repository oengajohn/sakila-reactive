package io.github.oengajohn.sakilareactive.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDetails {
    @Builder.Default
    private boolean success=false;
    private HttpStatus code;
    private List<String> msg;
}
